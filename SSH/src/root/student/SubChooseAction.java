package root.student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Property;
import hibernate.tables.PropertyDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 课题选择
 */
@Transactional(readOnly = true)
public class SubChooseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3524988917468830501L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubChooseAction.class);

	@Autowired
	private ThesisDAO thesisDAO;

	@Autowired
	private PreviewDAO previewDAO;

	@Autowired
	private StudentDAO studentDAO;

	private List<Thesis> thesiss;

	private int page;

	private int totalPage;

	private int thesisno;

	private int order;

	private List<Integer> num;

	private String sessionId;

	@Autowired
	private PropertyDAO propertyDAO;

	/**
	 * 查询课程信息，按页返回
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String query() throws Exception {
		// 增加后台控制学生预选时间
		Property property = propertyDAO.findByKey("StudentPreview"); // 获取预选时间控制参数
		if (property != null && property.getValueD() != null) { // 没有设置预选控制
			Date preview_date = property.getValueD();
			Date now = new Date();
			Calendar cal_1 = Calendar.getInstance();
			Calendar cal_2 = Calendar.getInstance();
			cal_1.setTime(preview_date);
			cal_2.setTime(now);
			if (cal_2.after(cal_1)) { // 超出预选课题时间
				addActionError("预选课题已经截止，如需帮助请联系管理员!");
				return "error";
			}
		}
		Student student = studentDAO.findById(sessionId);
		if (page == 0)
			page = 1;

		// 根据教师名排序后输出
		String queryString = "from Thesis thesis order by thesis.teacher.name asc";
		thesiss = thesisDAO.getHibernateTemplate().find(queryString);

		log.debug(ReflectionToStringBuilder.toString(student));
		Iterator<Thesis> it_ = thesiss.iterator();
		while (it_.hasNext()) {
			Iterator<Preview> it2 = it_.next().getPreviews().iterator();
			while (it2.hasNext()) {
				if (it2.next().getStudent() == student) {
					it_.remove();
					break;
				}
			}
		}
		// 计算总页数
		totalPage = thesiss.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= thesiss.size())
			listEnd = thesiss.size();
		thesiss = thesiss.subList(listStart, listEnd);

		Iterator<Thesis> it = thesiss.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
		return "querySuccess";
	}

	/**
	 * 选择课程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String select() throws Exception {

		thesiss = new ArrayList<Thesis>();
		Thesis thesis = thesisDAO.findById(thesisno);
		log.debug("选择课题编号为" + thesisno + "，名称：" + thesis.getName());
		thesiss.add(thesis);
		Iterator<Thesis> it = thesiss.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
		return "selectSuccess";
	}

	/**
	 * 添加预选对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		Student student = studentDAO.findById(sessionId);

		// 获得选中课题对象
		Thesis thesis = thesisDAO.findById(thesisno);
		log.debug("课题编号：" + thesisno + "，课题名称：" + thesis.getName());

		Iterator<Preview> it = student.getPreviews().iterator();
		while (it.hasNext()) {
			int order_ = it.next().getSuborder().intValue();
			if (order_ == order) {
				addActionError("对不起，你已经选过该志愿");
				return SUCCESS;
			}
		}

		if (order < 1 || order > 3) {
			addActionError("对不起，你提交了错误的数据：order=" + order);
			return SUCCESS;
		}

		// 创建新预选对象并保存
		Preview preview = new Preview();
		preview.setStudent(student);
		preview.setSuborder(order);
		preview.setThesis(thesis);
		thesis.getPreviews().add(preview);
		previewDAO.save(preview);
		log.info("创建预选条目：" + ReflectionToStringBuilder.toString(preview));
		return SUCCESS;
	}

	public List<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(List<Thesis> thesiss) {
		this.thesiss = thesiss;
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

	public int getThesisno() {
		return thesisno;
	}

	public void setThesisno(int thesisno) {
		this.thesisno = thesisno;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<Integer> getNum() {
		return num;
	}

	public void setNum(List<Integer> num) {
		this.num = num;
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
