package root.student;

import java.util.Map;
import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class QAInputAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3335852686695468285L;
	/**
	 * 用于页面提交的Bean类
	 */
	private StudentScore studentscore;
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentScoreDAO studentscoreDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String projDesc = studentscore.getProjDesc();
		String thesDesc = studentscore.getThesDesc();
		String question1 = studentscore.getQuestion1();
		String answer1 = studentscore.getAnswer1();
		String question2 = studentscore.getQuestion2();
		String answer2 = studentscore.getAnswer2();
		String question3 = studentscore.getQuestion3();
		String answer3 = studentscore.getAnswer3();

		studentscore = studentscoreDAO.findById(sessionId);
		studentscore.setProjDesc(projDesc);
		studentscore.setThesDesc(thesDesc);
		studentscore.setQuestion1(question1);
		studentscore.setAnswer1(answer1);
		studentscore.setQuestion2(question2);
		studentscore.setAnswer2(answer2);
		studentscore.setQuestion3(question3);
		studentscore.setAnswer3(answer3);
		return "qainput";
	}

	public String query() throws Exception {
		// 获得session
		String sessionType;
		String sessionId;
		Map<String, Object> session = ActionContext.getContext().getSession();
		sessionId = (String) session.get("sessionId");
		sessionType = (String) session.get("sessionType");
		if ((sessionType == null || sessionId == null) && sessionType != "1")
			return ERROR;
		studentscore = studentscoreDAO.findById(sessionId);
		return "qainput";
	}

	public StudentScore getStudentscore() {
		return studentscore;
	}

	public void setStudentscore(StudentScore studentscore) {
		this.studentscore = studentscore;
	}

	public void setStudentscoreDAO(StudentScoreDAO studentscoreDAO) {
		this.studentscoreDAO = studentscoreDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
