package root.teacher;

import java.util.Map;
import java.util.Set;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.MathEx;

import hibernate.tables.Major;
import hibernate.tables.Py;
import hibernate.tables.PyDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class GradeInputAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 688842117547662254L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(GradeInputAction.class);
	@Autowired
	private TeacherDAO teacherDAO;
	private Teacher teacher;
	private Set<Thesis> thesiss;
	private Integer thesisNo;
	public Thesis thesis;
	private List<Py> pys;
	private StudentScore studentScore;
	@Autowired
	private StudentScoreDAO studentScoreDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	private Student student;
	private PyDAO pyDAO;
	private int score;
	private int lv;
	private String Dbpingyu;
	private String Pypingyu;
	private String Zdpingyu;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String select() {
		thesis = thesisDAO.findById(thesisNo);
		student = thesis.getStudent();
		studentScore = student.getStudentScore();
		pys = pyDAO.findAll();

		return "selectsuccess";
	}

	@Transactional(readOnly = false)
	public String query() {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		Integer grade = studentScore.getGrade();
		int zd1grade=0,zd2grade=0,
		zd3grade=0,zd4grade=0,
		py1grade=0,py2grade=0,
		db1grade=0,db2grade=0;
		
		String projdesc = studentScore.getProjDesc();
		String thesdesc = studentScore.getThesDesc();
		String studentNo = student.getStudentno();
		studentScore = studentScoreDAO.findById(studentNo);
		studentScore.setGrade(grade);
		studentScore.setProjDesc(projdesc);
		studentScore.setThesDesc(thesdesc);
		if(grade==null)
		{return "in";}
		else if(grade<100&&grade>0)
		{
			zd1grade = (int) (random(1,1.05) * grade) ;
			zd2grade = (int) (random(1,1.05) * grade) ;
			zd3grade = (int) (random(1,1.05) * grade) ;
			zd4grade = (int) (random(1,1.05) * grade) ;
			py1grade = (int) (random(1,1.05) * grade) ;
			py2grade = (int) (random(1,1.05) * grade) ;
			db1grade = (int) (random(1,1.05) * grade) ;
			db2grade = (int) (random(1,1.05) * grade) ;
			studentScore.setGrade(grade);
			studentScore.setZd1grade(zd1grade);
			studentScore.setZd2grade(zd2grade);
			studentScore.setZd3grade(zd3grade);
			studentScore.setZd4grade(zd4grade);
			studentScore.setPy1grade(py1grade);
			studentScore.setPy2grade(py2grade);
			studentScore.setDb1grade(db1grade);
			studentScore.setDb2grade(db2grade);
		

		 if (studentScore.getDbpingyu() != null
				&& studentScore.getPypingyu() != null
				&& studentScore.getZdpingyu() != null) {
			Dbpingyu = studentScore.getDbpingyu();
			Pypingyu = studentScore.getPypingyu();
			Zdpingyu = studentScore.getZdpingyu();
		}

		else {

			int size = 0;
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
		 }
		return "exsucc";
	}

	@Transactional(readOnly = false)
	public String pyinfo() {
		studentScore = studentScoreDAO.findById(student.getStudentno());
		studentScore.setDbpingyu(Dbpingyu);
		studentScore.setPypingyu(Pypingyu);
		studentScore.setZdpingyu(Zdpingyu);

		return "pyinfosuccess";
	}

	public double random(double bound1, double bound2) {
		return Math.random() * (bound1 - bound2) + bound2;
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

	public Set<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(Set<Thesis> thesiss) {
		this.thesiss = thesiss;
	}

	public Integer getThesisNo() {
		return thesisNo;
	}

	public void setThesisNo(Integer thesisNo) {
		this.thesisNo = thesisNo;
	}

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Py> getPys() {
		return pys;
	}

	public void setPys(List<Py> pys) {
		this.pys = pys;
	}

	public PyDAO getPyDAO() {
		return pyDAO;
	}

	public void setPyDAO(PyDAO pyDAO) {
		this.pyDAO = pyDAO;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
