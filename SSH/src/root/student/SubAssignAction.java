package root.student;

import java.util.List;
import java.util.Map;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubAssignAction extends ActionSupport {

	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubAssignAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Student student;
	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public String execute() throws Exception {
		student = studentDAO.findById(sessionId);
		return SUCCESS;
	}

	public String query() throws Exception {
		student = studentDAO.findById(sessionId);
		return "subname";
	}

	public String studentmod() throws Exception {
		student = studentDAO.findById(sessionId);
		return "studentmod";
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
