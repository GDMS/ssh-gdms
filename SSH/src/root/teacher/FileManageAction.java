package root.teacher;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7101361124487099241L;

	@Autowired
	private TeacherDAO teacherDAO;

	private Teacher teacher;

	private Set<Thesis> thesises;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesises = teacher.getThesises();
		return SUCCESS;
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

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
