package root.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
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
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubResultAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentDAO studentDAO;

	private Student student;
	@Autowired
	private PreviewDAO previewDAO;

	private Set<Preview> previews;

	private ArrayList<Integer> num;

	private List<Thesis> thesiss;

	/*
	 * 获得网页上的需操作的previewno
	 */
	private Integer No;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	/**
	 * 用于页面提交的Bean类
	 */

	@Transactional(readOnly = false)
	public String delete() throws Exception {
		Preview previewdelete = previewDAO.findById(No);
		log.info("删除预选条目："+ReflectionToStringBuilder.toString(previewdelete));
		previewDAO.delete(previewdelete);
		return "DELSUCCESS";
	}

	@Transactional(readOnly = false)
	public String Up() {
		student = studentDAO.findById(sessionId);
		previews = student.getPreviews();
		Preview previewUp = previewDAO.findById(No);
		int upID = previewUp.getSuborder();
		Preview previewDown = null;
		if (upID <= 1) {
			return "MOVEFAILED";
		} else {
			Iterator<Preview> it = previews.iterator();
			while (it.hasNext()) {
				Preview preview_ = new Preview();
				preview_ = it.next();
				if (preview_.getSuborder() == upID - 1) {
					previewDown = preview_; // 获得下降条目
				}
			}
		}
		if (previewDown != null)
			previewDown.setSuborder(upID);
		previewUp.setSuborder(upID - 1);
		return "MOVESUCCESS";
	}

	@Transactional(readOnly = false)
	public String Down() {
		student = studentDAO.findById(sessionId);
		previews = student.getPreviews();
		Preview previewDown = previewDAO.findById(No);
		int downID = previewDown.getSuborder();
		Preview previewUp = null;
		if (downID >= 3) {
			return "MOVEFAILED";
		} else {
			Iterator<Preview> it = previews.iterator();
			while (it.hasNext()) {
				Preview preview_ = new Preview();
				preview_ = it.next();
				if (preview_.getSuborder() == downID + 1) {
					previewUp = preview_; // 获得下降条目
				}
			}
		}
		if (previewUp != null)
			previewUp.setSuborder(downID);
		previewDown.setSuborder(downID + 1);
		return "MOVESUCCESS";
	}

	@Override
	@Transactional(readOnly = true)
	public String execute() throws Exception {
		thesiss = new ArrayList<Thesis>();
		// 获得session
		String sessionType;
		String sessionId;
		Map<String, Object> session = ActionContext.getContext().getSession();
		sessionId = (String) session.get("sessionId");
		sessionType = (String) session.get("sessionType");
		if ((sessionType == null || sessionId == null) && sessionType != "1") {
			addActionError("用户不存在！");
			return ERROR;
		} else {
			student = studentDAO.findById(sessionId);
			previews = student.getPreviews();

			if (previews == null || previews.isEmpty()) {
				return "null";// 无预选
			} else {
				Iterator<Preview> it = previews.iterator();
				num = new ArrayList<Integer>();
				thesiss = new ArrayList<Thesis>();
				while (it.hasNext()) {
					Preview preview_ = it.next();
					int num_ = preview_.getThesis().getPreviews().size();
					num.add(num_);
					thesiss.add(preview_.getThesis());
				}
				return SUCCESS;
			}
		}
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

	public PreviewDAO getPreviewDAO() {
		return previewDAO;
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public Set<Preview> getPreviews() {
		return previews;
	}

	public void setPreviews(Set<Preview> previews) {
		this.previews = previews;
	}

	public ArrayList<Integer> getNum() {
		return num;
	}

	public void setNum(ArrayList<Integer> num) {
		this.num = num;
	}

	public List<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(List<Thesis> thesiss) {
		this.thesiss = thesiss;
	}

	public Integer getNo() {
		return No;
	}

	public void setNo(Integer no) {
		No = no;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
