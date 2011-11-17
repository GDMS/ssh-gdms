package root.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.tables.Preview;
import hibernate.tables.StuClass;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import root.student.SubChooseAction;

import com.opensymphony.xwork2.ActionSupport;

public class SubAssignAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8939975345424205843L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubAssignAction.class);
	private String studentNo;

	@Autowired
	private StudentDAO studentDAO;

	private Student student;

	private Set<Preview> previews;

	@Autowired
	private TeacherDAO teacherDAO;

	private List<Teacher> teacher;
	private List<Thesis> thesis;

	private Map<String, List<Thesis>> map;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional
	public String query() {
		student = studentDAO.findById(studentNo);
		previews = student.getPreviews();
		teacher = teacherDAO.findAll();
		map = new HashMap<String, List<Thesis>>();
		Set<Thesis> thesises = null;
		Teacher teachers;
		for (int i = teacher.size() - 1; i >= 0; i--) {
			teachers = teacher.get(i);
			thesises = teachers.getThesises();
			if (!thesises.isEmpty()) {
				Iterator it = thesises.iterator();
				while (it.hasNext()) {
					Thesis _thesis = (Thesis) it.next();
					if (_thesis.getStudent() != null) {
						thesises.remove(_thesis);
						it = thesises.iterator();
					}
				}
				if (!thesises.isEmpty()) {
					thesis = new ArrayList<Thesis>();
					thesis.addAll(thesises);
					map.put(teacher.get(i).getTeacherno(), thesis);
				} else {
					teacher.remove(i);
				}
			} else
				teacher.remove(i);
		}
		return "querysuccess";
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	public List<Thesis> getThesis() {
		return thesis;
	}

	public void setThesis(List<Thesis> thesis) {
		this.thesis = thesis;
	}

	public Map<String, List<Thesis>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<Thesis>> map) {
		this.map = map;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Preview> getPreviews() {
		return previews;
	}

	public void setPreviews(Set<Preview> previews) {
		this.previews = previews;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
