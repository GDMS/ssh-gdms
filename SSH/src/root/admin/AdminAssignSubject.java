package root.admin;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAssignSubject extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(AdminAssignSubject.class);

	private int thesisno;

	private String studentno;
	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private ThesisDAO thesisDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		Student student = studentDAO.findById(studentno);
		Thesis thesis = thesisDAO.findById(thesisno);
		if (student.getAssign() != null
				&& student.getAssign().equals("teacher")) {
			student.getThesis().setAssigned(null);
			student.setAssign(null);
			student.setAutoassign(null);
		}
		student.setThesis(thesis);
		student.setAssign("admin");
		student.setAutoassign("admin");
		thesis.setAssigned("admin");
		return SUCCESS;
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

	public int getThesisno() {
		return thesisno;
	}

	public void setThesisno(int thesisno) {
		this.thesisno = thesisno;
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
