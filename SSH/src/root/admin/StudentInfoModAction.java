package root.admin;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.tables.Major;
import hibernate.tables.MajorDAO;
import hibernate.tables.StuClass;
import hibernate.tables.StuClassDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class StudentInfoModAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6968036601087523637L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(StudentInfoModAction.class);
	
	@Autowired
	private StudentDAO studentDAO;
	private Student student;
	@Autowired
	private StuClassDAO stuclassDAO;
	@Autowired
	private MajorDAO majorDAO;
	
	private List<Major> major;
	private Map<Integer, List<StuClass>> classname;
	
	private String studentno;
	private int classno;
	
	/**
	 * 管理员修改学生信息Action
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		String id= student.getStudentno();
		String name = student.getName();
		String password = student.getPassword();
		String gender = student.getGender();
		Double credit = student.getCredit();
		String phone = student.getPhone();
		String email = student.getEmail();
		student = studentDAO.findById(id);
		StuClass stuClass = stuclassDAO.findById(classno);
		student.setName(name);
		student.setGender(gender);
		student.setPassword(password);
		student.setStuClass(stuClass);
		student.setCredit(credit);
		student.setPhone(phone);
		student.setEmail(email);
		return SUCCESS;
	}

	public String query() {
		student = studentDAO.findById(studentno);
		classname = new HashMap<Integer, List<StuClass>>();
		major = majorDAO.findAll();
		Iterator<Major> it = major.iterator();
		while (it.hasNext()) {
			Major major_ = (Major) it.next();
			Integer majorno = major_.getMajorno();
			Set<StuClass> sets = major_.getStuClasses();
			List<StuClass> lists = new ArrayList<StuClass>();
			lists.addAll(sets);
			classname.put(majorno, lists);
		}
		return "querysuccess";
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

	public String getStudentno() {
		return studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public MajorDAO getMajorDAO() {
		return majorDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public List<Major> getMajor() {
		return major;
	}

	public void setMajor(List<Major> major) {
		this.major = major;
	}

	public Map<Integer, List<StuClass>> getClassname() {
		return classname;
	}

	public void setClassname(Map<Integer, List<StuClass>> classname) {
		this.classname = classname;
	}

	public StuClassDAO getStuclassDAO() {
		return stuclassDAO;
	}

	public void setStuclassDAO(StuClassDAO stuclassDAO) {
		this.stuclassDAO = stuclassDAO;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

}
