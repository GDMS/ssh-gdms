package root.admin;

import hibernate.tables.Major;
import hibernate.tables.MajorDAO;

import hibernate.tables.StuClass;
import hibernate.tables.StuClassDAO;

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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClassnoDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -342111486746340890L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(ClassnoDelAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */

	@Autowired
	private StuClassDAO stuClassDAO;

	private int majorno;
	@Autowired
	private MajorDAO majorDAO;

	private List<Major> majors;
	private Map<Integer, List<StuClass>> classname;
	private String name;
	private int classno;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	/**
	 * 实现用户登录
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {
		StuClass stuClass= stuClassDAO.findById(classno);
		log.info("删除班级:"+ReflectionToStringBuilder.toString(stuClass));
		stuClassDAO.delete(stuClass);
		return "delSuccess";
	}

	public String query() throws Exception {
		majors = majorDAO.findAll();
		Iterator<Major> it = majors.iterator();
		classname = new HashMap<Integer, List<StuClass>>();
		while (it.hasNext()) {
			Major major_ = it.next();
			Integer majorno = major_.getMajorno();
			Set<StuClass> sets = major_.getStuClasses();
			List<StuClass> lists = new ArrayList<StuClass>();
			lists.addAll(sets);
			classname.put(majorno, lists);

		}
		// log.fatal(majors);
		return SUCCESS;
	}

	public MajorDAO getMajorDAO() {
		return majorDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public void setStuClassDAO(StuClassDAO stuClassDAO) {
		this.stuClassDAO = stuClassDAO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, List<StuClass>> getClassname() {
		return classname;
	}

	public void setClassname(Map<Integer, List<StuClass>> classname) {
		this.classname = classname;
	}

	public StuClassDAO getStuClassDAO() {
		return stuClassDAO;
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