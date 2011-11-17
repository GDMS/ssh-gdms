package root.admin;

import hibernate.tables.Major;
import hibernate.tables.MajorDAO;

import hibernate.tables.StuClass;
import hibernate.tables.StuClassDAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClassnoAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(ClassnoAddAction.class);
	/**
	 * Sping依赖注入的DAO类.
	 */

	@Autowired
	private StuClassDAO stuClassDAO;

	private List<Major> majors;
	private int majorno;
	@Autowired
	private MajorDAO majorDAO;

	private String name;

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
		if (name==null||name.isEmpty()){
			addActionError("班级为空请重新输入");
			majors = majorDAO.findAll();
			return INPUT;		
		}
	//	log.fatal(name);
		
		StuClass stuClass = new StuClass();
		stuClass.setName(name);
		stuClass.setMajor(majorDAO.findById(majorno));
		stuClassDAO.save(stuClass);
		log.info("增加班级："+ReflectionToStringBuilder.toString(stuClass));
		return "addSuccess";
	}

	public String query() throws Exception {
		majors = majorDAO.findAll();
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}