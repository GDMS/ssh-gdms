package root.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import hibernate.tables.Major;
import hibernate.tables.MajorDAO;
import hibernate.tables.StuClass;
import hibernate.tables.StuClassDAO;
import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class StudentModAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1651540870354707297L;
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(StudentModAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */
	@Autowired
	private StudentDAO studentDAO;
	/**
	 * 用于页面提交的Bean类
	 */
	private Student student;

	// private Set<StuClass> stuclass;
	// private List<Major> major_;
	@Autowired
	private StuClassDAO stuclassDAO;
	@Autowired
	private MajorDAO majorDAO;

	private List<Major> major;
	private Map<Integer, List<StuClass>> classname;

	private int classno;
	// private List<String> mjr;
	// private List<String> cls;
	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	/**
	 * 修改学生信息Action
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {

		// String name = student.getName();
		String phone = student.getPhone();
		// String major =student.getName();
		// String gender = student.getGender();
		// Double credit = student.getCredit();
		String email = student.getEmail();

		student = studentDAO.findById(sessionId);
		StuClass stuClass = stuclassDAO.findById(classno);
		// student.setName(name);
		student.setPhone(phone);
		// student.setMajor(major);
		//student.setStuClass(stuClass);
		// student.setCredit(credit);
		// student.setGender(gender);
		student.setEmail(email);
		return "studentmod";
	}

	public String query() throws Exception {
		student = studentDAO.findById(sessionId);
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
		return SUCCESS;
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;

	}

	/**
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	// /**
	// * @return the major_
	// */
	// public List<Major> getMajor_() {
	// return major_;
	// }
	//
	// /**
	// * @param major_
	// * the major_ to set
	// */
	// public void setMajor_(List<Major> major_) {
	// this.major_ = major_;
	// }
	//
	// /**
	// * @return the stuclassDAO
	// */
	// public StuClassDAO getStuclassDAO() {
	// return stuclassDAO;
	// }
	//
	// /**
	// * @param stuclassDAO
	// * the stuclassDAO to set
	// */
	public void setStuclassDAO(StuClassDAO stuclassDAO) {
		this.stuclassDAO = stuclassDAO;
	}

	//
	// /**
	// * @return the majorDAO
	// */
	// public MajorDAO getMajorDAO() {
	// return majorDAO;
	// }
	//
	/**
	 * @param majorDAO
	 *            the majorDAO to set
	 */
	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	/**
	 * @return the major
	 */
	public List<Major> getMajor() {
		return major;
	}

	/**
	 * @param major
	 *            the major to set
	 */
	public void setMajor(List<Major> major) {
		this.major = major;
	}

	/**
	 * @return the classname
	 */
	public Map<Integer, List<StuClass>> getClassname() {
		return classname;
	}

	/**
	 * @param classname
	 *            the classname to set
	 */
	public void setClassname(Map<Integer, List<StuClass>> classname) {
		this.classname = classname;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
