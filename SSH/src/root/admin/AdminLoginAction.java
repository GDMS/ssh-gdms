package root.admin;

import java.util.Map;
import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.SecurityEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class AdminLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6785412481737335717L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(AdminLoginAction.class);
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
	 * 实现用户登录
	 */
	@Override
	public String execute() throws Exception {
		String name = administrator.getName();
		String password = administrator.getPassword();
		log.debug("输入用户名：" + name + "密码：" + password + "进行登录校验。");
		Administrator administrator_ = administratorDAO.findById(name);
		if (administrator_ == null) {
			addActionError("用户不存在！");
			return INPUT;
		} else if (!administrator_.getPassword().equals(password)) {
			addActionError("密码错误！");
			return INPUT;
		}
		// 写入Session
		String sessionName = administrator_.getName();
		String sessionType = "3";
		String sessionId = administrator_.getName();
		Map<String, Object> session = ActionContext.getContext().getSession();
		byte[] sessionDigest = SecurityEx.getHash(sessionId, SecurityEx.SHA1);
		session.put("sessionName", sessionName);
		session.put("sessionType", sessionType);
		session.put("sessionId", sessionId);
		session.put("sessionDigest", sessionDigest);
		return SUCCESS;
	}

	@Override
	public void validate() {
		// 关闭后台用户名密码校验
		// if(log.isDebugEnabled())
		// return;
		// String no = administrator.getName();
		// String password = administrator.getPassword();
		// if (no.length() != 9)
		// addFieldError("administrator.no", "输入的学号长度不是9位");
		// if (password.length() < 6)
		// addFieldError("administrator.password", "输入的密码长度小于6位");
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

}

