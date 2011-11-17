package root.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import util.MathEx;
import com.opensymphony.xwork2.ActionSupport;

public class AssignAutoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 923898476587926435L;

	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(AssignAutoAction.class);

	private String AUTO = "auto";

	@Autowired
	private PreviewDAO previewDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	@Autowired
	private StudentDAO studentDAO;
	List<Student> students;
	private int page;

	private int totalPage;
	Integer assignMethod;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		if (previewDAO.findAll().size() == 0)
			addActionError("没有预选信息");
		if (assignMethod == null)
			assignMethod = 0;
		switch (assignMethod) {
		case 0:
			cancelAssign();
			break;
		case 9:
			assignConfirm();
			break;
		case 2:
			allAssignWithoutGrade();
			optAssign();
			leftAssign();
			otherAssign();
			break;
		case 1:
		default:
			allAssign();
			optAssign();
			leftAssign();
			otherAssign();
		}
		return SUCCESS;
	}

	/**
	 * 采用平行志愿方式，根据学分排名
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean allAssign() {
		AUTO = "auto1";
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findAllByCreditDesc();
		Iterator<Student> studentsIterator = students.iterator();
		List<Preview> previews = new ArrayList<Preview>();
		while (studentsIterator.hasNext()) {
			Student student_ = studentsIterator.next();
			@SuppressWarnings("unchecked")
			Set<Preview> previews_ = student_.getPreviews();
			previews.addAll(previews_);
		}

		Iterator<Preview> it = previews.iterator();
		Thesis previewThesis = null;
		Student previewStudent = null;
		Student oldPreviewStudent = null;
		String assignedState = null;
		while (it.hasNext()) {
			Preview preview_ = it.next();
			previewThesis = preview_.getThesis();
			previewStudent = preview_.getStudent();
			assignedState = previewThesis.getAssigned();

			// 判断学生是否相同
			if (oldPreviewStudent == previewStudent)
				if (previewStudent.getAssign() != null)
					continue;

			if (assignedState == null || assignedState.isEmpty()) {
				int thesisno = previewThesis.getThesisno();
				String studentno = previewStudent.getStudentno();
				Thesis thesis = thesisDAO.findById(thesisno);
				Student student = studentDAO.findById(studentno);
				// int subOrder = preview_.getSuborder();
				// AUTO = "-" + subOrder;
				if (thesis.getAssigned() == null) {
					thesis.setAssigned(AUTO);
					student.setThesis(thesis);
					student.setAssign(AUTO);
					student.setAutoassign(AUTO);
					thesisDAO.merge(thesis);
					studentDAO.merge(student);
				}
			}

			oldPreviewStudent = previewStudent;
		}

		addActionMessage("第一轮预选成功");
		return true;
	}

	/**
	 * 采用平行志愿方式，根据学分*随机数排名
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean allAssignWithoutGrade() {
		AUTO = "auto1";
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findAll();
		List<Preview> previews = new ArrayList<Preview>();
		while (!students.isEmpty()) {
			int no = MathEx.randomInt(0, students.size() - 1);
			Student student_ = students.get(no);
			@SuppressWarnings("unchecked")
			Set<Preview> previews_ = student_.getPreviews();
			previews.addAll(previews_);
			students.remove(no);
		}

		Iterator<Preview> it = previews.iterator();
		Thesis previewThesis = null;
		Student previewStudent = null;
		Student oldPreviewStudent = null;
		String assignedState = null;
		while (it.hasNext()) {
			Preview preview_ = it.next();
			previewThesis = preview_.getThesis();
			previewStudent = preview_.getStudent();
			assignedState = previewThesis.getAssigned();

			// 判断学生是否相同
			if (oldPreviewStudent == previewStudent)
				if (previewStudent.getAssign() != null)
					continue;

			if (assignedState == null || assignedState.isEmpty()) {
				int thesisno = previewThesis.getThesisno();
				String studentno = previewStudent.getStudentno();
				Thesis thesis = thesisDAO.findById(thesisno);
				Student student = studentDAO.findById(studentno);
				if (thesis.getAssigned() == null) {
					thesis.setAssigned(AUTO);
					student.setThesis(thesis);
					student.setAssign(AUTO);
					student.setAutoassign(AUTO);
					thesisDAO.merge(thesis);
					studentDAO.merge(student);
				}
			}

			oldPreviewStudent = previewStudent;
		}

		addActionMessage("第一轮预选成功");
		return true;
	}

	/**
	 * 剩余选课未选上学生，根据绩点排名，查看所选教师是否还有空位，有空则选上
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	protected boolean optAssign() {
		AUTO = "auto2";
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findAllByCreditDesc();
		Iterator<Student> studentsIterator = students.iterator();
		while (studentsIterator.hasNext()) {
			Student student_ = studentsIterator.next();
			int num = student_.getPreviews().size();
			if (num == 0)
				studentsIterator.remove();
		}

		studentsIterator = students.iterator();
		while (studentsIterator.hasNext()) {
			Student student = studentsIterator.next();
			List<Thesis> thesises = new ArrayList<Thesis>();
			List<Preview> pres = new ArrayList<Preview>();
			pres.addAll(student.getPreviews());
			for (Preview p : pres) {
				List<Thesis> thes = new ArrayList<Thesis>();
				thes.addAll(p.getThesis().getTeacher().getThesises());
				for (Thesis t : thes) {
					if (t.getAssigned() == null)
						thesises.add(t);
				}
				if (thesises.size() > 0)
					break;
			}
			int no = MathEx.randomInt(0, thesises.size() - 1);
			if (thesises == null || thesises.size() <= 0)
				continue;
			Thesis thesis = thesises.get(no);
			if (thesis.getAssigned() == null) {
				thesis.setAssigned(AUTO);
				student.setThesis(thesis);
				student.setAssign(AUTO);
				student.setAutoassign(AUTO);
				thesisDAO.merge(thesis);
				studentDAO.merge(student);
				thesises.remove(no);
			}
		}
		addActionMessage("第二轮预选成功");
		return true;
	}

	/**
	 * 剩余选课未选上学生
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean leftAssign() {
		AUTO = "auto3";
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findAllByCreditDesc();
		Iterator<Student> studentsIterator = students.iterator();
		while (studentsIterator.hasNext()) {
			Student student_ = studentsIterator.next();
			int num = student_.getPreviews().size();
			if (num == 0)
				studentsIterator.remove();
		}

		studentsIterator = students.iterator();
		while (studentsIterator.hasNext()) {
			Student student = studentsIterator.next();
			@SuppressWarnings("unchecked")
			List<Thesis> thesises = thesisDAO.findAllNotAssigned();
			int no = MathEx.randomInt(0, thesises.size() - 1);
			if (thesises == null || thesises.size() <= 0) {
				log.error("自动分配：课题数少于学生数");
				addActionError("自动分配：课题数少于学生数");
				return false;
			}
			Thesis thesis = thesises.get(no);

			if (thesis.getAssigned() == null) {
				thesis.setAssigned(AUTO);
				student.setThesis(thesis);
				student.setAssign(AUTO);
				student.setAutoassign(AUTO);
				thesisDAO.merge(thesis);
				studentDAO.merge(student);
				thesises.remove(no);
			}
		}

		addActionMessage("第三轮预选成功");
		return true;
	}

	/**
	 * 未选课学生
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean otherAssign() {
		AUTO = "auto4";
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findByThesisNull();
		Iterator<Student> studentsIterator = students.iterator();
		while (studentsIterator.hasNext()) {
			Student student = studentsIterator.next();
			@SuppressWarnings("unchecked")
			List<Thesis> thesises = thesisDAO.findAllNotAssigned();
			int no = MathEx.randomInt(0, thesises.size() - 1);
			if (thesises == null || thesises.size() <= 0) {
				log.error("自动分配：课题数少于学生数");
				addActionError("自动分配：课题数少于学生数");
				return false;
			}
			Thesis thesis = thesises.get(no);

			if (thesis.getAssigned() == null) {
				thesis.setAssigned(AUTO);
				student.setThesis(thesis);
				student.setAssign(AUTO);
				student.setAutoassign(AUTO);
				thesisDAO.merge(thesis);
				studentDAO.merge(student);
			}
		}
		addActionMessage("第四轮预选成功");
		return true;
	}

	/**
	 * 撤销自动分配
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean cancelAssign() {
		String[] autos = { "auto1", "auto2", "auto3", "auto4" };
		@SuppressWarnings("unchecked")
		List<Student> students = studentDAO.findAll();
		Iterator<Student> it = students.iterator();
		while (it.hasNext()) {
			Student student = it.next();
			for (String auto : autos) {
				if (student.getAssign() == null)
					break;
				if (student.getAssign().equals(auto)) {
					student.setAssign(null);
					student.setAutoassign(null);
					student.getThesis().setAssigned(null);
					student.setThesis(null);
					break;
				}
			}
		}

		addActionMessage("撤销自动分配成功");
		return true;
	}

	/**
	 * 确认自动分配
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	protected boolean assignConfirm() {
		List<Preview> previews = previewDAO.findAll();
		previewDAO.getHibernateTemplate().deleteAll(previews);

		addActionMessage("确认自动分配成功");
		return true;
	}

	public String query() {
		students = studentDAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = students.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= students.size())
			listEnd = students.size();
		students = students.subList(listStart, listEnd);
		return "querysuccess";
	}

	public String Excel() {
		students = studentDAO.findAll();
		return "excel";
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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

	public PreviewDAO getPreviewDAO() {
		return previewDAO;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getAssignMethod() {
		return assignMethod;
	}

	public void setAssignMethod(Integer assignMethod) {
		this.assignMethod = assignMethod;
	}
}
