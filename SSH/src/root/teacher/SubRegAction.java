package root.teacher;

import hibernate.tables.TeacherDept;
import hibernate.tables.TeacherDeptDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubRegAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3620996780311902074L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubRegAction.class);
	@Autowired
	private ThesisDAO thesisDAO;
	/**
	 * 用于页面提交的Bean类
	 */
	private Thesis thesis;

	@Autowired
	private TeacherDAO teacherDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	/**
	 * 实现用户登录
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		Teacher teacher = teacherDAO.findById(sessionId);
		thesis.setTeacher(teacher);
		if(thesis.getName()==null||thesis.getName().isEmpty())
			return SUCCESS;
		int num = teacher.getThesises().size();// 教师现有课题数
		
		if (teacher.getSubnum()==null)
			teacher.setSubnum(0);
			
		int subnum = teacher.getSubnum();// 教师最大课程数
		if (num < subnum) {
			log.info("注册新课题:"+ReflectionToStringBuilder.toString(thesis));
			thesisDAO.save(thesis);

		} else {
			addActionError("您的课程数已超标");
			return "wrong";
		}
		return "querysuccess";
	}

	public String query() throws Exception {
		// thesises = thesisesDAO.findAll();
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}