package root.teacher;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubnameModAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -988488317361493019L;

	@Autowired
	private TeacherDAO teacherDAO;

	@Autowired
	private ThesisDAO thesisDAO;

	private Teacher teacher;

	private Set<Thesis> thesiss;

	private int thesisNo;

	private Thesis thesis;

	private Thesis newthesis;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String changename() {
		// 判断课题名是否输入
		String newsubname = newthesis.getName();
		thesisNo = thesis.getThesisno();
		if (newsubname.isEmpty()) {
			addActionError("请输入课题名称");
			return "wrong";
		}

		thesis = thesisDAO.findById(thesisNo);
		thesis.setName(newsubname);
		return "changesuccess";
	}

	@Transactional(readOnly = true)
	public String query() {
		teacher = teacherDAO.findById(sessionId);
		thesis = thesisDAO.findById(thesisNo);
		// thesis.setName(subname);
		return "querysuccess";
	}

	@Transactional(readOnly = true)
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

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public int getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(int thesisNo) {
		this.thesisNo = thesisNo;
	}

	public Thesis getNewthesis() {
		return newthesis;
	}

	public void setNewthesis(Thesis newthesis) {
		this.newthesis = newthesis;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
