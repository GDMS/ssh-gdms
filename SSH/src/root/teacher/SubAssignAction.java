package root.teacher;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubAssignAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2017581083546204L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubAssignAction.class);
	@Autowired
	private TeacherDAO teacherDAO;

	private Teacher teacher;

	private Set<Thesis> thesiss;

	private String studentNo;

	private Student student;

	private int maxassign;
	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String view() {
		if (studentNo == null) {
			addActionError("学生不存在！");
			return "wrong";
		}
		student = studentDAO.findById(studentNo);
		return "viewStudent";
	}

	@Transactional(readOnly = false)
	public String delete() {
		if (studentNo == null) {
			addActionError("学生不存在！");
			return "wrong";
		}
		student = studentDAO.findById(studentNo);
		if (student.getThesis() != null) {
			student.getThesis().setAssigned(null);
			student.setAssign(null);
			student.setAutoassign(null);
			student.setThesis(null);
		}
		log.debug("清除学生选择课题信息！"+ReflectionToStringBuilder.toString(student));
		return "deletesuccess";
	}

	public String Excel() {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		return "excel";
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
