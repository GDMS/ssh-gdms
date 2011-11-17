package root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import root.student.StudentModAction;
import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static final Log log = LogFactory
			.getLog(ChangePasswordAction.class);

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	private StudentDAO studentDAO;

	private TeacherDAO teacherDAO;

	private AdministratorDAO adminDAO;

	private Student student;
	private Teacher teacher;
	private Administrator admin;

	private String oldPassword;
	private String newPassword;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {

		if (studentDAO != null) {
			return studentPassword();
		} else if (teacherDAO != null) {
			return teacherPassword();
		} else if (adminDAO != null) {
			return adminPassword();
		} else {
			return "error";
		}
	}

	public String studentPassword() {
		student = studentDAO.findById(sessionId);
		if (student == null) {
			addActionError("没有这个学生");
			return "setPasswordWrong";
		}
		if (student.getPassword().equals(oldPassword)) {
			student.setPassword(newPassword);
			return "setStudentPasswordSuccess";
		} else {
			addActionError("旧密码错误");
			return "setPasswordWrong";
		}
	}

	public String teacherPassword() {
		teacher = teacherDAO.findById(sessionId);
		if (teacher == null) {
			addActionError("没有这个老师");
			return "setPasswordWrong";
		}
		if (teacher.getPassword().equals(oldPassword)) {
			teacher.setPassword(newPassword);
			return "setTeacherPasswordSuccess";
		} else {
			addActionError("旧密码错误");
			return "setPasswordWrong";
		}
	}

	public String adminPassword() {
		admin = adminDAO.findById(sessionId);
		if (admin == null) {
			addActionError("没有这个管理员");
			return "setPasswordWrong";
		}
		if (admin.getPassword().equals(oldPassword)) {
			admin.setPassword(newPassword);
			return "setAdminPasswordSuccess";
		} else {
			addActionError("旧密码错误");
			return "setPasswordWrong";
		}
	}

	public String adminquery() {
		admin = adminDAO.findById(sessionId);
		if (admin == null) {
			addActionError("error!");
			return ERROR;
		}
		return "adminquery";
	}

	public String teacherquery() {
		teacher = teacherDAO.findById(sessionId);
		if (teacher == null) {
			addActionError("error!");
			return ERROR;
		}
		return "teacherquery";
	}

	public String studentquery() {
		student = studentDAO.findById(sessionId);
		if (student == null) {
			addActionError("error!");
			return ERROR;
		}
		return "studentquery";
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public AdministratorDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdministratorDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

}
