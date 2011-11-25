package root.teacher;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hibernate.tables.News;
import hibernate.tables.NewsDAO;
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
	private static final long serialVersionUID = 5780930845291823047L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(TeacherLoginAction.class);
	/**
	 * Spring依赖注入的DAO类.
	 */
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private NewsDAO newsDao;
	@Autowired
	private PropertyDAO propertyDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Teacher teacher;
	private String message;

	/**
	 * 实现教师登录验证
	 */
	@Override
	@Transactional(readOnly = false)
	// FIXME 批量更新最大预选比例MaxAssign
	public String execute() throws Exception {
		News news = newsDao.findById(1);
		message = news.getMsgToTea();
		addActionMessage(message);
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
		String sessionNews = message;
		String sessionName = teacher.getName();
		String sessionType = "2";
		String sessionId = teacher.getTeacherno();
		byte[] sessionDigest = SecurityEx.getHash(sessionId, SecurityEx.SHA1);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sessionNews", sessionNews);
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
		if (teacher == null) {
			addActionError("没有输入数据！");
		}
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

	public NewsDAO getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDAO newsDao) {
		this.newsDao = newsDao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
