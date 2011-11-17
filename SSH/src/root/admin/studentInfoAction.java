package root.admin;

import java.util.List;
import java.util.Map;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class studentInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4899342407279031907L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(studentInfoAction.class);
	@Autowired
	private List<Student> students;
	private int page;
	private int totalPage;

	private Student student;
	@Autowired
	private StudentDAO studentDAO;

	private int thesisNo;
	@Autowired
	private ThesisDAO thesisDAO;

	private Thesis thesis;

	private String studentno;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		student = studentDAO.findById(studentno);
		Thesis thesis = student.getThesis();
		try {
			if (thesis != null) {
				thesis.setAssigned(null);// 删除学生课程没人选了
			}
		} catch (Exception e) {
//			log.warn(e.toString());
		} finally {
			log.info("删除成功！" + ReflectionToStringBuilder.toString(student));
			studentDAO.delete(student);
		}
		return SUCCESS;

	}

	@Transactional(readOnly = true)
	public String delete() {
		student = studentDAO.findById(studentno);
		return "deletequery";
	}

	public String Excel() {
		students = studentDAO.findAll();
		return "excel";
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public int getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(int thesisNo) {
		this.thesisNo = thesisNo;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public String getStudentno() {
		return studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
