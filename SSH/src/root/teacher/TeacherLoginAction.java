package root.teacher;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hibernate.tables.Property;
import hibernate.tables.PropertyDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.SecurityEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class TeacherLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5780930845291823047L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(TeacherLoginAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private TeacherDAO teacherDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Teacher teacher;

	@Autowired
	private PropertyDAO propertyDAO;

	/**
	 * 实现教师登录验证
	 */
	@Override
	@Transactional(readOnly = false)
	// FIXME 批量更新最大预选比例MaxAssign
	public String execute() throws Exception {
		String name = teacher.getName();
		String password = teacher.getPassword();
		log.debug("教师号：" + name + "密码：" + password);
		Teacher teacher = teacherDAO.findById(name);
		if (teacher == null) {
			addActionError("用户不存在！");
			return INPUT;
		} else if (!teacher.getPassword().equals(password)) {
			addActionError("密码错误！");
			return INPUT;
		}
		// 写入Session
		String sessionName = teacher.getName();
		String sessionType = "2";
		String sessionId = teacher.getTeacherno();
		byte[] sessionDigest = SecurityEx.getHash(sessionId, SecurityEx.SHA1);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sessionName", sessionName);
		session.put("sessionType", sessionType);
		session.put("sessionId", sessionId);
		session.put("sessionDigest", sessionDigest);

		// FIXME 批量更新最大预选比例MaxAssign
		updateMaxAssign();
		return SUCCESS;
	}

	@Transactional(readOnly = false)
	private void updateMaxAssign() throws Exception {
		Property p = propertyDAO.findByKey("MaxAssign");
		int percent;
		try {
			percent = Integer.parseInt(p.getValue());
		} catch (Exception e) {
			log.warn(e.toString());
			percent = 20;
		}

		List<Teacher> teachers_ = teacherDAO.findAll();
		Iterator<Teacher> it = teachers_.iterator();
		while (it.hasNext()) {
			Teacher teacher_ = it.next();
			if (teacher_.getSubnum() == null)
				teacher_.setSubnum(0);
			int max = Math.round((float) percent * (float) teacher_.getSubnum()
					/ 100);
			if (max <= 0 && teacher_.getSubnum() > 0)
				max = 1;
			teacher_.setMaxassign(max);
		}
	}

	@Override
	public void validate() {
		// 关闭后台用户名密码校验
		// if(log.isDebugEnabled())
		// return;
		// String name = teacher.getName();
		// String password =teacher.getPassword();
		// if (name.length() ==0)
		// addFieldError("teacher.name", "输入用户名为空");
		// if (password.length() < 6)
		// addFieldError("teacher.password", "输入的密码长度小于6位");
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

	public void setPropertyDAO(PropertyDAO propertyDAO) {
		this.propertyDAO = propertyDAO;
	}
}
