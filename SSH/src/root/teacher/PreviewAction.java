package root.teacher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hibernate.tables.Preview;
import hibernate.tables.Property;
import hibernate.tables.PropertyDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class PreviewAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269515088421680220L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(PreviewAction.class);

	@Autowired
	private TeacherDAO teacherDAO;

	private Teacher teacher;

	private Set<Thesis> thesiss;

	private List<Preview> previews;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private ThesisDAO thesisDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	private int page;

	private int totalPage;

	private String studentNo;

	private Integer thesisNo;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String select() {
		Student st = studentDAO.findById(studentNo);
		Thesis th = thesisDAO.findById(thesisNo);
		Teacher teacher = teacherDAO.findById(sessionId);
		int maxnum = 0;
		if (teacher.getMaxassign() == null || teacher.getMaxassign() == 0) {
			teacher.setMaxassign(teacher.getSubnum());
			maxnum = teacher.getSubnum();// 教师可选最大学生数默认最大
		} else {
			maxnum = teacher.getMaxassign();// 教师可选最大学生数
		}

		// 获取学生选课志愿顺序：1、2、3
		int subOrder = 3;
		try {
			List<Preview> shudentPreviews = new ArrayList<Preview>();
			shudentPreviews.addAll(st.getPreviews());
			for (Preview p_ : shudentPreviews) {
				if (p_.getThesis().getThesisno().equals(th.getThesisno())) {
					subOrder = p_.getSuborder();
					break;
				}
			}
		} catch (Exception e) {
			log.warn(e.toString());
		}

		// 判断选课是否超时
		try {
			Calendar cal_1 = new GregorianCalendar();
			Calendar cal_2 = new GregorianCalendar();
			Calendar cal_3 = new GregorianCalendar();
			Calendar cal_now = new GregorianCalendar();
			Date date_1 = propertyDAO.findByKey("PreviewSelectStart1")
					.getValueD();
			if (date_1 == null)
				date_1 = new Date();
			Date date_2 = propertyDAO.findByKey("PreviewSelectStart2")
					.getValueD();
			if (date_2 == null)
				date_2 = new Date();
			Date date_3 = propertyDAO.findByKey("PreviewSelectStart3")
					.getValueD();
			if (date_3 == null)
				date_3 = new Date();
			cal_1.setTime(date_1);
			cal_2.setTime(date_2);
			cal_3.setTime(date_3);
			if (cal_now.before(cal_1) && subOrder == 1) {
				addActionError("现在还不能预选第一志愿的学生，开始时间："
						+ cal_1.get(Calendar.YEAR) + "年"
						+ (cal_1.get(Calendar.MONTH) + 1) + "月"
						+ cal_1.get(Calendar.DAY_OF_MONTH) + "日。");
				return "wrong";
			} else if (cal_now.before(cal_2) && subOrder == 2) {
				addActionError("现在还不能预选第二志愿的学生，开始时间："
						+ cal_2.get(Calendar.YEAR) + "年"
						+ (cal_2.get(Calendar.MONTH) + 1) + "月"
						+ cal_2.get(Calendar.DAY_OF_MONTH) + "日。");
				return "wrong";
			} else if (cal_now.before(cal_3) && subOrder == 3) {
				addActionError("现在还不能预选第三志愿的学生，开始时间："
						+ cal_3.get(Calendar.YEAR) + "年"
						+ (cal_3.get(Calendar.MONTH) + 1) + "月"
						+ cal_3.get(Calendar.DAY_OF_MONTH) + "日。");
				return "wrong";
			}
		} catch (Exception e) {
			log.warn(e.toString());
		}

		// 判断学生绩点是否低于最低要求
		double creditNotToChoose = 0.0;
		try {
			Property p = propertyDAO.findByKey("CreditNotToChoose");
			creditNotToChoose = Double.parseDouble(p.getValue());
		} catch (NumberFormatException e) {
			creditNotToChoose = 0.0;
			log.warn(e.toString());
		}
		Double credit = 0.0;
		try {
			credit = st.getCredit();
		} catch (NullPointerException e) {
			credit = 0.0;
			log.warn(e.toString());
		}
		if (credit < creditNotToChoose) {
			addActionError("选择的学生绩点为：" + credit + "，小于最低绩点要求："
					+ creditNotToChoose);
			return "wrong";
		}

		int num = 0;// 教师现选学生数
		Iterator<Thesis> it = teacher.getThesises().iterator();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			String assign = thesis_.getAssigned();
			if (assign != null && assign.equals("teacher"))
				num++;
		}

		if (num < maxnum) {// 教师选课人数未超标可以选学生
			th.setAssigned("teacher");
			st.setThesis(th);
			st.setAssign("teacher");
			st.setAutoassign("teacher");
		} else {
			addActionError("您已经不能再选择学生");
			return "wrong";
		}
		return "selectsuccess";
	}

	@Transactional(readOnly = true)
	@Override
	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		previews = new ArrayList<Preview>();
		List<Preview> previews_ = new ArrayList<Preview>();
		List<Preview> previews_selected = new ArrayList<Preview>();
		Iterator<Thesis> it = thesiss.iterator();
		Iterator<Preview> it_ = null;
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			// if (thesis_.getStudent() == null) {
			it_ = thesis_.getPreviews().iterator();
			while (it_.hasNext()) {
				Preview preview_ = it_.next();
				// if (preview_.getStudent().getThesis() == null)
				previews.add(preview_);
				// else
				// previews_.add(preview_);
			}
			// }
			// else {
			// it_ = thesis_.getPreviews().iterator();
			// while (it_.hasNext()) {
			// Preview preview_ = it_.next();
			// previews_.add(preview_);
			// }
			// }
		}
		// previews.addAll(previews_);
		if (page == 0)
			page = 1;
		totalPage = previews.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= previews.size())
			listEnd = previews.size();
		previews = previews.subList(listStart, listEnd);
		return SUCCESS;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(Set<Thesis> thesiss) {
		this.thesiss = thesiss;
	}

	public List<Preview> getPreviews() {
		return previews;
	}

	public void setPreviews(List<Preview> previews) {
		this.previews = previews;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Integer getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(Integer thesisNo) {
		this.thesisNo = thesisNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setPropertyDAO(PropertyDAO propertyDAO) {
		this.propertyDAO = propertyDAO;
	}

}
