package root.admin;

import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Major;
import hibernate.tables.MajorDAO;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MajorAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3620996780311902074L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(MajorAddAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private AdministratorDAO administratorDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Administrator administrator;

	/**
	 * 用于页面提交的Bean类
	 */
	private Major major;

	/**
	 * 用于页面提交的Bean类
	 */
	private MajorDAO majorDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	/**
	 * 实现用户登录
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		if (major.getName() == null || major.getName().isEmpty()) {
			addActionError("专业为空");
			return INPUT;
		}
		majorDAO.save(major);
		log.info("增加专业:"+major);
		return "majorsuccess";
	}

	public String query() throws Exception {
		return SUCCESS;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public MajorDAO getMajorDAO() {
		return majorDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}