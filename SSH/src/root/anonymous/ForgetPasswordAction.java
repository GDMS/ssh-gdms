package root.anonymous;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1489672013684763340L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(ForgetPasswordAction.class);

	StudentDAO studentDAO;
	String studentno;

	TeacherDAO teacherDAO;
	String teacherno;

	private MailSender mailSender;
	private SimpleMailMessage templateMessage;

	String mail;
	String password;

	@Override
	@Transactional
	public String execute() throws Exception {
		String result;
		if (studentDAO != null)
			result = forStu();
		else if (teacherDAO != null)
			result = forTea();
		else {
			log.error("No method to do");
			return INPUT;
		}
		if (!result.equals(SUCCESS))
			return result;

		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(mail);
		msg.setText("您的GDMS密码是:" + password + "\n请及时修改!");
		try {
			this.mailSender.send(msg);
			addActionMessage("邮件已经发出");
		} catch (MailException ex) {
			log.error(ex.toString());
			addActionError("邮件发送失败，请重试");
			return INPUT;
		}

		return SUCCESS;
	}

	protected String forStu() {
		Student student = studentDAO.findById(studentno);
		if (student == null) {
			addActionError("找不到学生");
			return INPUT;
		}
		mail = student.getEmail();
		password = student.getPassword();
		return SUCCESS;
	}

	protected String forTea() {
		Teacher teacher = teacherDAO.findById(teacherno);
		if (teacher == null) {
			addActionError("找不到教师");
			return INPUT;
		}
		mail = teacher.getMail();
		password = teacher.getPassword();
		return SUCCESS;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getTemplateMessage() {
		return templateMessage;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public String getStudentno() {
		return studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public String getTeacherno() {
		return teacherno;
	}

	public void setTeacherno(String teacherno) {
		this.teacherno = teacherno;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
}
