package root.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import com.opensymphony.xwork2.ActionSupport;

public class SubAssignDetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585415905188613784L;
	
	/**
	 * Log
	 */
	private  final Log log = LogFactory.getLog(getClass());
	@Autowired
	private ThesisDAO thesisDAO;

	private Thesis thesis;

	private int thesisNo;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	public String execute() throws Exception {

		thesis = thesisDAO.findById(thesisNo);
		if (thesis == null) {
			addActionError("课程不存在");
			return "wrong";
		}
		return SUCCESS;
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

	public int getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(int thesisNo) {
		this.thesisNo = thesisNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
