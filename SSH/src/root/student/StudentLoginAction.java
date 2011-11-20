package root.student;

import java.util.Map;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.SecurityEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class StudentLoginAction extends ActionSupport {
	private static final long serialVersionUID = 6785412481737335717L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(StudentLoginAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Student student;

	/**
	 * 实现用户登录
	 */
	@Override
	public String execute() throws Exception {
		String studentno = student.getStudentno();
		String password = student.getPassword();
		log.debug("输入用户名：" + studentno + "密码：" + password + "进行登录校验。");
		Student student_ = studentDAO.findById(studentno);
		if (student_ == null) {
			addActionError("用户不存在！");
			return INPUT;
		} else if (!student_.getPassword().equals(password)) {
			addActionError("密码错误！");
			return INPUT;
		}
		// 写入Session
		String sessionName = student_.getName();
		String sessionType = "1";
		String sessionId = student_.getStudentno();
		byte[] sessionDigest = SecurityEx.getHash(sessionId, SecurityEx.SHA1);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sessionName", sessionName);
		session.put("sessionType", sessionType);
		session.put("sessionId", sessionId);
		session.put("sessionDigest", sessionDigest);
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (student == null) {
			addActionError("没有输入数据！");
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
