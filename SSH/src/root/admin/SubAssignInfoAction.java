package root.admin;

import java.util.List;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class SubAssignInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415283106668747556L;
	
	/**
	 * Log
	 */
	private  final Log log = LogFactory.getLog(getClass());
	@Autowired
	private StudentDAO studentDAO;

	private List<Student> students;

	private int page;
	private int totalPage;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	public String execute() throws Exception {

		students = studentDAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = students.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= students.size())
			listEnd = students.size();
		students = students.subList(listStart, listEnd);
		return SUCCESS;
	}
	
	public String Excel(){
		students = studentDAO.findAll();
		return "excel";
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
