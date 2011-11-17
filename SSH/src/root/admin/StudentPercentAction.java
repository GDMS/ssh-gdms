package root.admin;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class StudentPercentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7126008218830193552L;
	
	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(StudentPercentAction.class);
	private Teacher teacher;
	@Autowired
	private TeacherDAO teacherDAO;
	private List<Teacher> teachers_;
	private Double percent;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		if (percent == null) {

			return INPUT;
		}
		teachers_ = teacherDAO.findAll();
		Iterator<Teacher> it = teachers_.iterator();
		while (it.hasNext()) {
			Teacher teacher_ = it.next();
			if (teacher_.getSubnum() == null)
				teacher_.setSubnum(0);
			int max = Math
					.round((float) (percent * teacher_.getSubnum() / 100));
			if (max <= 0&&teacher_.getSubnum()>0)
				max = 1;
			teacher_.setMaxassign(max);
		}
		return SUCCESS;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public List<Teacher> getTeachers_() {
		return teachers_;
	}

	public void setTeachers_(List<Teacher> teachers_) {
		this.teachers_ = teachers_;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
