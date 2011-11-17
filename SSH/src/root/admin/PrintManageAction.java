package root.admin;

import java.util.List;
import java.util.Map;

import hibernate.tables.Py;
import hibernate.tables.PyDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.MathEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PrintManageAction extends ActionSupport {

	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(PrintManageAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentDAO studentDAO;
	private List<Student> students;
	private int page;
	private int totalPage;
	private String studentNo;
	private String Dbpingyu;
	private String Pypingyu;
	private String Zdpingyu;
	private PyDAO pyDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	public String adminuse() {
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
		return "admin";
	}

	public String view() {
		if (studentNo == null || studentNo == "") {
			addActionError("学生不存在！");
			return "error";
		}
		// log.fatal(studentNo);
		student = studentDAO.findById(studentNo);
		if (student.getStudentScore().getDbpingyu() != null
				&& student.getStudentScore().getPypingyu() != null
				&& student.getStudentScore().getZdpingyu() != null) {
			Dbpingyu = student.getStudentScore().getDbpingyu();
			Pypingyu = student.getStudentScore().getPypingyu();
			Zdpingyu = student.getStudentScore().getZdpingyu();
		}

		else {

			int size = 0;
			if (student.getStudentScore().getGrade() == null) {
				addActionError("没有分数无妨查看评语");
				return "wrong";
			}
			int grade = student.getStudentScore().getGrade();
			List<Py> py;

			if (grade >= 85 && grade <= 100) {
				py = pyDAO.findByLv("A");
				size = py.size();
				Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
				Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
				Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
			} else if (grade >= 75 && grade <= 84) {
				py = pyDAO.findByLv("B");
				size = py.size();
				Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
				Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
				Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
			} else if (grade >= 60 && grade <= 74) {
				py = pyDAO.findByLv("C");
				size = py.size();
				Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
				Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
				Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
			} else if (grade >= 0 && grade <= 59) {
				py = pyDAO.findByLv("D");
				size = py.size();
				Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
				Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
				Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();

			}

		}
		return "viewStudent";
	}

	public String query() {
		student = studentDAO.findById(studentNo);
		return "querysuccess";
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Student student;

	public String getstudentNo() {
		return studentNo;
	}

	public void setstudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getDbpingyu() {
		return Dbpingyu;
	}

	public void setDbpingyu(String dbpingyu) {
		Dbpingyu = dbpingyu;
	}

	public String getPypingyu() {
		return Pypingyu;
	}

	public void setPypingyu(String pypingyu) {
		Pypingyu = pypingyu;
	}

	public String getZdpingyu() {
		return Zdpingyu;
	}

	public void setZdpingyu(String zdpingyu) {
		Zdpingyu = zdpingyu;
	}

	public PyDAO getPyDAO() {
		return pyDAO;
	}

	public void setPyDAO(PyDAO pyDAO) {
		this.pyDAO = pyDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
