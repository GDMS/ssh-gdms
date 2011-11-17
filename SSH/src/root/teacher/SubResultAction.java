package root.teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Student;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubResultAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -389747523733531957L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubResultAction.class);

	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	@Autowired
	private PreviewDAO previewDAO;

	private Teacher teacher;

	private Set<Thesis> thesiss;
	private List<Integer> num;

	private int thesisNo;
	private Thesis thesis_;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String delete() {
		Thesis thesis = thesisDAO.findById(thesisNo);
		Student student = thesis.getStudent();
		Set<Preview> previews = thesis.getPreviews();
		Iterator<Preview> it = previews.iterator();
		if (!previews.isEmpty()) {
			while (it.hasNext()) {
				Preview preview_ = it.next();
				previewDAO.delete(preview_);
			}
		}
		if (student != null) {
			 student.setAssign(null);
			 student.setAutoassign(null);
			student.setThesis(null);
		}
		log.info("删除课题:"+ReflectionToStringBuilder.toString(thesis));
		thesisDAO.delete(thesis);
		return "DELSUCCESS";
	}

	@Transactional(readOnly = true)
	@Override
	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		Iterator<Thesis> it = thesiss.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
		return SUCCESS;
	}

	public String modify() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		// Thesis thesis = thesisDAO.findById(thesisNo);
		thesis_ = thesisDAO.findById(thesisNo);

		return "subupdate";
	}
	
	public String Excel(){
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		Iterator<Thesis> it = thesiss.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
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

	public List<Integer> getNum() {
		return num;
	}

	public void setNum(List<Integer> num) {
		this.num = num;
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

	public PreviewDAO getPreviewDAO() {
		return previewDAO;
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public Thesis getThesis_() {
		return thesis_;
	}

	public void setThesis_(Thesis thesis_) {
		this.thesis_ = thesis_;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
