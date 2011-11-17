package root.admin;

import java.util.List;
import java.util.Map;

import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
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
public class studentPreviewInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162453465390460659L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(studentPreviewInfoAction.class);
	@Autowired
	private PreviewDAO previewDAO;
	private List<Preview> previews;
	private int page;
	private int totalPage;
	private String studentNo;
	private Student student;
	@Autowired
	private StudentDAO studentDAO;

	private int thesisNo;
	@Autowired
	private ThesisDAO thesisDAO;

	private Thesis thesis;

	private Preview preview;

	private int previewNo;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		previews = previewDAO.findAllOrderByStudentAndSuborder();
		if (page == 0)
			page = 1;
		totalPage = previews.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= previews.size())
			listEnd = previews.size();
		previews = previews.subList(listStart, listEnd);
		return "querysuccess";
	}
	
	public String Excel(){
		previews = previewDAO.findAllOrderByStudentAndSuborder();
		return "excel";
	}
	@Transactional(readOnly = true)
	public String studentDetail() {
		student = studentDAO.findById(studentNo);
		return "studentdetail";
	}

	@Transactional(readOnly = true)
	public String thesisDetail() {
		thesis = thesisDAO.findById(thesisNo);
		return "thesisDetail";
	}

	@Transactional(readOnly = true)
	public String delete() {
		preview = previewDAO.findById(previewNo);
		return "deletequery";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		preview = previewDAO.findById(previewNo);
		log.info("删除预选信息:"+ReflectionToStringBuilder.toString(preview));
		previewDAO.delete(preview);
		return SUCCESS;
	}

	public PreviewDAO getPreviewDAO() {
		return previewDAO;
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public List<Preview> getPreviews() {
		return previews;
	}

	public void setPreviews(List<Preview> previews) {
		this.previews = previews;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	public int getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(int thesisNo) {
		this.thesisNo = thesisNo;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public Preview getPreview() {
		return preview;
	}

	public void setPreview(Preview preview) {
		this.preview = preview;
	}

	public int getPreviewNo() {
		return previewNo;
	}

	public void setPreviewNo(int previewNo) {
		this.previewNo = previewNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
