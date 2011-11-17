package root.admin;

import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Major;
import hibernate.tables.MajorDAO;
import hibernate.tables.Student;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.TeacherDept;
import hibernate.tables.TeacherDeptDAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherRegAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3620996780311902074L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(TeacherRegAction.class);
	@Autowired
	private TeacherDAO teacherDAO;
	/**
	 * 用于页面提交的Bean类
	 */
	private Teacher teacher;

	@Autowired
	private TeacherDeptDAO teacherDeptDAO;

	private List<TeacherDept> teacherDept;

	private int deptno;

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
		Teacher teacher_ = teacherDAO.findById(teacher.getTeacherno());
		if (teacher_ != null || teacher.getTeacherno().isEmpty()) {
			addActionError("工号" + teacher.getTeacherno() + "已经注册");
			return INPUT;
		}

		teacher.setTeacherDept(teacherDeptDAO.findById(deptno));
		log.info("注册教师："+ReflectionToStringBuilder.toString(teacher));
		teacherDAO.save(teacher);
		return "querysuccess";

	}

	public String query() throws Exception {
		teacherDept = teacherDeptDAO.findAll();
		return SUCCESS;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
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

	public TeacherDeptDAO getTeacherDeptDAO() {
		return teacherDeptDAO;
	}

	public void setTeacherDeptDAO(TeacherDeptDAO teacherDeptDAO) {
		this.teacherDeptDAO = teacherDeptDAO;
	}

	public List<TeacherDept> getTeacherDept() {
		return teacherDept;
	}

	public void setTeacherDept(List<TeacherDept> teacherDept) {
		this.teacherDept = teacherDept;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}