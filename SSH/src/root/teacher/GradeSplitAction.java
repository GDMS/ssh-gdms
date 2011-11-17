package root.teacher;

import hibernate.tables.Py;
import hibernate.tables.PyDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.StudentScore;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.MathEx;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GradeSplitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387864568914051413L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(GradeSplitAction.class);

	@Autowired
	private TeacherDAO teacherDAO;
	private Teacher teacher;
	private Set<Thesis> thesiss;
	private String studentNo;
	@Autowired
	private PyDAO pyDAO;
	private Student student;
	@Autowired
	private StudentDAO studentDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		teacher = teacherDAO.findById(sessionId);
		thesiss = teacher.getThesises();
		return "querysuccess";
	}

	public String select() {
		student = studentDAO.findById(studentNo);
		return "selectsuccess";
	}

	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		int size = 0;
		List<Py> py;
		String Dbpingyu;
		String Pypingyu;
		String Zdpingyu;
		String no = student.getStudentno();
		StudentScore studentscore = student.getStudentScore();
		Integer grade = studentscore.getGrade();
		Integer zd1grade = studentscore.getZd1grade();
		Integer zd2grade = studentscore.getZd2grade();
		Integer zd3grade = studentscore.getZd3grade();
		Integer zd4grade = studentscore.getZd4grade();
		Integer py1grade = studentscore.getPy1grade();
		Integer py2grade = studentscore.getPy2grade();
		Integer db1grade = studentscore.getDb1grade();
		Integer db2grade = studentscore.getDb2grade();
		student = studentDAO.findById(no);
		studentscore = student.getStudentScore();
		if (grade >= 100) {
			grade = 99;
			zd1grade = (int) (grade / 0.15);
			zd2grade = (int) (grade / 0.05);
			zd3grade = (int) (grade / 0.05);
			zd4grade = (int) (grade / 0.05);
			py1grade = (int) (grade / 0.2);
			py2grade = (int) (grade / 0.1);
			db1grade = (int) (grade / 0.1);
			db2grade = (int) (grade / 0.3);
			studentscore.setGrade(grade);
			studentscore.setZd1grade(zd1grade);
			studentscore.setZd2grade(zd2grade);
			studentscore.setZd3grade(zd3grade);
			studentscore.setZd4grade(zd4grade);
			studentscore.setPy1grade(py1grade);
			studentscore.setPy2grade(py2grade);
			studentscore.setDb1grade(db1grade);
			studentscore.setDb2grade(db2grade);
			py = pyDAO.findByLv("A");
			size = py.size();
			Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
			Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
			Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();

		} else if (grade < 0) {
			grade = 0;
			studentscore.setGrade(0);
			studentscore.setZd1grade(0);
			studentscore.setZd2grade(0);
			studentscore.setZd3grade(0);
			studentscore.setZd4grade(0);
			studentscore.setPy1grade(0);
			studentscore.setPy2grade(0);
			studentscore.setDb1grade(0);
			studentscore.setDb2grade(0);
			py = pyDAO.findByLv("D");
			size = py.size();
			Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
			Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
			Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
		} else {
			studentscore.setGrade(grade);
			studentscore.setZd1grade(zd1grade);
			studentscore.setZd2grade(zd2grade);
			studentscore.setZd3grade(zd3grade);
			studentscore.setZd4grade(zd4grade);
			studentscore.setPy1grade(py1grade);
			studentscore.setPy2grade(py2grade);
			studentscore.setDb1grade(db1grade);
			studentscore.setDb2grade(db2grade);
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
		return SUCCESS;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public PyDAO getPyDAO() {
		return pyDAO;
	}

	public void setPyDAO(PyDAO pyDAO) {
		this.pyDAO = pyDAO;
	}
}
