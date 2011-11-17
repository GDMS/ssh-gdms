package root.admin;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
@Transactional(readOnly=true)
public class SubAssignDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8820946881167773277L;
	
	/**
	 * Log
	 */
	private  final Log log = LogFactory.getLog(getClass());
	@Autowired
	private StudentDAO studentDAO;
	
	private Student student;
	
	private String studentNo;
	
	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly=true)
	public String query(){
		student = studentDAO.findById(studentNo);
		if(student==null)
		{
			addActionError("学生不存在");
			return "wrong";
		}
		return "querysuccess";
	}
	
	@Transactional(readOnly=false)
	@Override
	public String execute() throws Exception {
		student = studentDAO.findById(studentNo);
		if(student==null)
		{
			addActionError("学生不存在");
			return "wrong";
		}
		student.setThesis(null);
		student.setAssign(null);
		student.setAutoassign(null);
		return SUCCESS;
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

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	
}
