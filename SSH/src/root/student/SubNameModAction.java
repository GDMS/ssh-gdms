package root.student;

import java.util.Map;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubNameModAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3106229126469337597L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubNameModAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 用于页面提交的Bean类
	 */
	private Student newstudent;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String subname = newstudent.getThesis().getName();
		newstudent = studentDAO.findById(sessionId);
		if (newstudent.getThesis() == null) {
			addActionError("课题为空，无法修改");
			return ERROR;
		}
		newstudent.getThesis().setName(subname);// 网络教学平台的应用开发
		return SUCCESS;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getNewstudent() {
		return newstudent;
	}

	public void setNewstudent(Student newstudent) {
		this.newstudent = newstudent;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
