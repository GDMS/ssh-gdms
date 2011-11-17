package root.admin;

import java.util.List;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.TeacherDept;
import hibernate.tables.TeacherDeptDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class TeacherInfoModAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882007954145878285L;

	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(TeacherInfoModAction.class);
	
	@Autowired
	private TeacherDAO teacherDAO;
	
	private Teacher teacher;
	
	@Autowired
	private TeacherDeptDAO teacherDeptDAO;

	private List<TeacherDept> teacherDept;
	
	private String teacherno;
	private int deptno;
	
	/**
	 * 管理员修改教师信息Action
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String id = teacher.getTeacherno();
		String name = teacher.getName();
		String password = teacher.getPassword();
		Integer subnum = teacher.getSubnum();
		String tel = teacher.getTel();
		String mail = teacher.getMail();
		teacher = teacherDAO.findById(id);
		TeacherDept teacherDept = teacherDeptDAO.findById(deptno);
		teacher.setName(name);
		teacher.setPassword(password);
		teacher.setSubnum(subnum);
		teacher.setTel(tel);
		teacher.setMail(mail);
		teacher.setTeacherDept(teacherDept);
		log.debug("教师信息修改：" + ReflectionToStringBuilder.toString(teacher));
		return SUCCESS;
	}

	public String query() {
		teacher = teacherDAO.findById(teacherno);
		teacherDept = teacherDeptDAO.findAll();
		return "querysuccess";
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

	public String getTeacherno() {
		return teacherno;
	}

	public void setTeacherno(String teacherno) {
		this.teacherno = teacherno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
