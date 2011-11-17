package root.student;

import java.util.Map;

import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class MidternCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904911421744128278L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(MidternCheckAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentScoreDAO studentScoreDAO;

	private StudentScore studentScore;
	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String progress = studentScore.getProgress();
		String quality = studentScore.getQuality();
		String attitude = studentScore.getAttitude();
		String duty = studentScore.getDuty();
		studentScore = studentScoreDAO.findById(sessionId);
		studentScore.setProgress(progress);
		studentScore.setQuality(quality);
		studentScore.setAttitude(attitude);
		studentScore.setDuty(duty);
		return SUCCESS;
	}

	public String query() {
		// 获得session
		String sessionType;
		String sessionId;
		Map<String, Object> session = ActionContext.getContext().getSession();
		sessionId = (String) session.get("sessionId");
		sessionType = (String) session.get("sessionType");
		if ((sessionType == null || sessionId == null) && sessionType != "1")
			return ERROR;
		else
			studentScore = studentScoreDAO.findById(sessionId);
		return "query";
	}

	public StudentScoreDAO getStudentScoreDAO() {
		return studentScoreDAO;
	}

	public void setStudentScoreDAO(StudentScoreDAO studentScoreDAO) {
		this.studentScoreDAO = studentScoreDAO;
	}

	public StudentScore getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(StudentScore studentScore) {
		this.studentScore = studentScore;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
