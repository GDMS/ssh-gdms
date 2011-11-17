package root.teacher;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubReassignAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8892049475414202797L;

	@Autowired
	private TeacherDAO teacherDAO;

	private Teacher teacher;

	private Set<Thesis> thesiss;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
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

	public Set<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(Set<Thesis> thesiss) {
		this.thesiss = thesiss;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
