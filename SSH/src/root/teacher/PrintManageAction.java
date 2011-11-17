package root.teacher;

import java.util.List;

import hibernate.tables.Py;
import hibernate.tables.PyDAO;
import hibernate.tables.StuClass;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.MathEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class PrintManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668275861286932521L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(PrintManageAction.class);
	@Autowired
	private TeacherDAO teacherDAO;

	private Teacher teacher;

	private List<Thesis> thesises;
	private PyDAO pyDAO;

	private Thesis thesis;
	private String studentno;

	private int page;
	private int totalPage;

	private StudentScore studentScore;
	private StudentScoreDAO studentScoreDAO;
	private int maxassign;
	@Autowired
	private StudentDAO studentDAO;
	private String Dbpingyu;
	private String Pypingyu;
	private String Zdpingyu;
	private Student student;
	private String studentNo;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		teacher = teacherDAO.findById(sessionId);
		List<Thesis> lists = new ArrayList<Thesis>();
		lists.addAll(teacher.getThesises());
		if (page == 0)
			page = 1;
		totalPage = lists.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= lists.size())
			listEnd = lists.size();
		thesises = lists.subList(listStart, listEnd);
		log.debug(thesises);
		// thesis.getStudent().getStudentScore().getGrade();
		return SUCCESS;
	}

	public String view() throws Exception {
		if (studentno == null || studentno == ""
				|| studentScoreDAO.findById(studentno) == null) {
			addActionError("学生不存在！");
			return "error";
		}
		// log.fatal(studentno);
		studentScore = studentScoreDAO.findById(studentno);
		if (studentScore.getDbpingyu() != null
				&& studentScore.getPypingyu() != null
				&& studentScore.getZdpingyu() != null) {
			Dbpingyu = studentScore.getDbpingyu();
			Pypingyu = studentScore.getPypingyu();
			Zdpingyu = studentScore.getZdpingyu();
		} else {
			int size = 0;
			// log.fatal(grade);
			if (studentScore.getGrade() == null) {
				addActionError("出错！");
				return "error";
			}
			int grade = studentScore.getGrade();
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

	public String query() throws Exception {
		student = studentDAO.findById(studentNo);
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

	public List<Thesis> getThesises() {
		return thesises;
	}

	public void setThesises(List<Thesis> thesises) {
		this.thesises = thesises;
	}

	public String getStudentno() {
		return studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
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

	public StudentScore getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(StudentScore studentScore) {
		this.studentScore = studentScore;
	}

	public StudentScoreDAO getStudentScoreDAO() {
		return studentScoreDAO;
	}

	public void setStudentScoreDAO(StudentScoreDAO studentScoreDAO) {
		this.studentScoreDAO = studentScoreDAO;
	}

	public int getMaxassign() {
		return maxassign;
	}

	public void setMaxassign(int maxassign) {
		this.maxassign = maxassign;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
