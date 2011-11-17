package root.teacher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubjectUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7669471294499729942L;
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private ThesisDAO thesisDAO;

	private Teacher teacher;

	private Thesis thesis_;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String name = thesis_.getName();
		String mode = thesis_.getMode();
		String property = thesis_.getProperty();
		String type = thesis_.getType();
		int theNum = thesis_.getThesisno();
		teacher = teacherDAO.findById(sessionId);
		// thesises = teacher.getThesises();
		thesis_ = thesisDAO.findById(theNum);
		thesis_.setMode(mode);
		thesis_.setName(name);
		thesis_.setType(type);
		thesis_.setProperty(property);
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

	public Thesis getThesis_() {
		return thesis_;
	}

	public void setThesis_(Thesis thesis_) {
		this.thesis_ = thesis_;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
