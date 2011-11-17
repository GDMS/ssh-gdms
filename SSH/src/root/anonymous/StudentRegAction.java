package root.anonymous;

import hibernate.tables.Major;
import hibernate.tables.MajorDAO;
import hibernate.tables.Property;
import hibernate.tables.PropertyDAO;
import hibernate.tables.StuClass;
import hibernate.tables.StuClassDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.StudentMaterialUpload;
import hibernate.tables.StudentMaterialUploadDAO;
import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class StudentRegAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3620996780311902074L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(StudentRegAction.class);
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private StudentScoreDAO studentScoreDAO;
	@Autowired
	private StudentMaterialUploadDAO studentMaterialUploadDAO;
	/**
	 * 用于页面提交的Bean类
	 */
	private Student student;

	@Autowired
	private StuClassDAO stuclassDAO;
	@Autowired
	private MajorDAO majorDAO;

	private List<Major> major;
	private Map<Integer, List<StuClass>> classname;

	private int classno;
	@Autowired
	private PropertyDAO propertyDAO;

	/**
	 * 实现用户注册
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		if (student == null)
			return query();
		// 根据属性决定是否开启学生注册
		Property p = propertyDAO.findByKey("StudentReg");
		if (p == null || p.getValueB() == false) {
			addActionError("没有开启学生注册");
			return query();
		}

		Student student_ = studentDAO.findById(student.getStudentno());
		if (student_ != null || student.getStudentno().isEmpty()) {
			addActionError("学号" + student.getStudentno() + "已经注册");
			return INPUT;
		}
		StuClass stuClass = stuclassDAO.findById(classno);
		student.setStuClass(stuClass);
		log.info("注册学生：" + ReflectionToStringBuilder.toString(student));
		StudentScore studentScore = new StudentScore();
		studentScore.setStudent(student);
		StudentMaterialUpload studentMaterialUpload = new StudentMaterialUpload();
		studentMaterialUpload.setStudent(student);
		studentDAO.save(student);
		studentScoreDAO.save(studentScore);
		studentMaterialUploadDAO.save(studentMaterialUpload);
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String query() throws Exception {
		// 获得session

		majorDAO.findAll();
		classname = new HashMap<Integer, List<StuClass>>();
		major = majorDAO.findAll();
		Iterator<Major> it = major.iterator();
		while (it.hasNext()) {
			Major major_ = it.next();
			Integer majorno = major_.getMajorno();
			Set<StuClass> sets = major_.getStuClasses();
			List<StuClass> lists = new ArrayList<StuClass>();
			lists.addAll(sets);
			classname.put(majorno, lists);
		}

		return "querySuccess";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
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

	public void setStuclassDAO(StuClassDAO stuclassDAO) {
		this.stuclassDAO = stuclassDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public void setStudentScoreDAO(StudentScoreDAO studentScoreDAO) {
		this.studentScoreDAO = studentScoreDAO;
	}

	public void setStudentMaterialUploadDAO(
			StudentMaterialUploadDAO studentMaterialUploadDAO) {
		this.studentMaterialUploadDAO = studentMaterialUploadDAO;
	}

	public void setPropertyDAO(PropertyDAO propertyDAO) {
		this.propertyDAO = propertyDAO;
	}
}