package root.teacher;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.TeacherDept;
import hibernate.tables.TeacherDeptDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class TeacherModAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1651540870354707297L;
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(TeacherModAction.class);
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
	private TeacherDeptDAO teacherDeptDAO;

	private List<TeacherDept> teacherDept;

	private int deptno;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		Integer subnum = teacher.getSubnum();
		String tel = teacher.getTel();
		String mail = teacher.getMail();

		teacher = teacherDAO.findById(sessionId);
		TeacherDept teacherDept = teacherDeptDAO.findById(deptno);
		// 如果老师没有设置过最大指导学生数，则可以设置一次
		if (teacher.getSubnum() == null || teacher.getSubnum() == 0)
			teacher.setSubnum(subnum);
		// 防止不能够进行预选
		try {
			int maxAssign = (int) (subnum * 0.2);
			if (maxAssign == 0)
				maxAssign = 1;
			teacher.setMaxassign(maxAssign);
		} catch (Exception e) {
			log.warn(e.toString());
		}

		teacher.setTel(tel);
		teacher.setMail(mail);
		teacher.setTeacherDept(teacherDept);
		log.debug("教师信息修改：" + ReflectionToStringBuilder.toString(teacher));
		return "teachermod";
	}

	public String query() throws Exception {
		teacher = teacherDAO.findById(sessionId);
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
