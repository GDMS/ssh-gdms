package root.admin;

import java.util.List;
import java.util.Map;
import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Py;
import hibernate.tables.PyDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class PyModifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(PyModifyAction.class);
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
	private int pyNo;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		pyDAO.merge(py);
		return SUCCESS;

	}

	public String modify() throws Exception {
		py = pyDAO.findById(pyNo);
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

	public int getPyNo() {
		return pyNo;
	}

	public void setPyNo(int pyNo) {
		this.pyNo = pyNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
