package root.teacher;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class TeacherSetRemarkAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7128274745313395256L;
	private static final Log log = LogFactory
			.getLog(TeacherSetRemarkAction.class);
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private StudentDAO studentDAO;

	private Teacher teacher;
	private Student student;
	private String studentno;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public String query() throws Exception {
		teacher = teacherDAO.findById(sessionId);

		if (studentno == null || studentno.isEmpty()) {
			return INPUT;
		} else
			student = studentDAO.findById(studentno);

		return SUCCESS;
	}

	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String remark = student.getStudentScore().getRemark();
		String warn = student.getStudentScore().getWarn();
		student = studentDAO.findById(student.getStudentno());
		teacher = teacherDAO.findById(sessionId);
		student.getStudentScore().setWarn(warn);
		student.getStudentScore().setRemark(remark);
		return "excutesuccess";

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
