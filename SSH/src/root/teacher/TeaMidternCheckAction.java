package root.teacher;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.tables.Student;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeaMidternCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6309823903664562142L;
	@Autowired
	private TeacherDAO teacherDAO;
	private Set<Thesis> thesises;
	private Teacher teacher;
	private Student student;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesises = teacher.getThesises();
		return SUCCESS;
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

	public Set<Thesis> getThesises() {
		return thesises;
	}

	public void setThesises(Set<Thesis> thesises) {
		this.thesises = thesises;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
