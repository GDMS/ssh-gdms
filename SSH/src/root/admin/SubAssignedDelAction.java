package root.admin;

import java.util.Map;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubAssignedDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6248987304983393795L;
	
	/**
	 * Log
	 */
	private  final Log log = LogFactory.getLog(getClass());
	
	/**
	 * 用于页面获得studentNo
	 */
	private String studentNo;

	/**
	 * 用于页面提交的Bean类
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

	@Transactional(readOnly = true)
	public String query() {
		student = studentDAO.findById(studentNo);
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		String SID = student.getStudentno();
		student = studentDAO.findById(SID);
		student.getThesis().setAssigned(null);
		student.setThesis(null);
		student.setAssign(null);
		student.setAutoassign(null);
		return SUCCESS;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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
