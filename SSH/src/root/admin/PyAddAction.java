package root.admin;

import java.util.Map;
import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Py;
import hibernate.tables.PyDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class PyAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(PyAddAction.class);
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
	private Py py;

	/**
	 * 用于页面提交的Bean类
	 */
	private PyDAO pyDAO;

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
		pyDAO.save(py);
		log.info("新增评语："+ReflectionToStringBuilder.toString(py));
		return SUCCESS;

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

	public Py getPy() {
		return py;
	}

	public void setPy(Py py) {
		this.py = py;
	}

	public PyDAO getPyDAO() {
		return pyDAO;
	}

	public void setPyDAO(PyDAO pyDAO) {
		this.pyDAO = pyDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
