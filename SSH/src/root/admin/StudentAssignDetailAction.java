package root.admin;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAssignDetailAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2590893167887702553L;

	private String studentNo;

	private Student student;

	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	public String execute() throws Exception {
		if (studentNo == null) {
			addActionError("学生不存在！");
			return "wrong";
		}
		student = studentDAO.findById(studentNo);
		return SUCCESS;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
