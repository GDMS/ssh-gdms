package root.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class TeacherInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1541195721829350783L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(studentInfoAction.class);
	@Autowired
	private List<Teacher> teachers;

	private int page;
	private int totalPage;

	private Teacher teacher;
	@Autowired
	private TeacherDAO teacherDAO;

	private String teacherno;

	private Set<Thesis> thesiss;
	private List<Integer> num;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		teachers = teacherDAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = teachers.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= teachers.size())
			listEnd = teachers.size();
		teachers = teachers.subList(listStart, listEnd);

		num = new ArrayList<Integer>();
		Iterator<Teacher> it_ = teachers.iterator();
		while (it_.hasNext()) {
			int a = 0;
			Teacher teacher = it_.next();
			thesiss = teacher.getThesises();
			Iterator<Thesis> it = thesiss.iterator();

			while (it.hasNext()) {
				Thesis thesis_ = it.next();
				if (thesis_.getStudent() != null)
					a++;
				// num.add(thesis_.getPreviews().size());
			}
			num.add(a);
		}
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		teacher = teacherDAO.findById(teacherno);
		log.info("删除教师："+ReflectionToStringBuilder.toString(teacher));
		teacherDAO.delete(teacher);
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String delete() {
		teacher = teacherDAO.findById(teacherno);
		return "deletequery";
	}

	@Transactional(readOnly = true)
	public String ans() {
		teacher = teacherDAO.findById(teacherno);
		thesiss = teacher.getThesises();
		Iterator<Thesis> it = thesiss.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}

		return "my";

	}
	
	public String Excel(){
		teachers = teacherDAO.findAll();
		num = new ArrayList<Integer>();
		Iterator<Teacher> it_ = teachers.iterator();
		while (it_.hasNext()) {
			int a = 0;
			Teacher teacher = it_.next();
			thesiss = teacher.getThesises();
			Iterator<Thesis> it = thesiss.iterator();

			while (it.hasNext()) {
				Thesis thesis_ = it.next();
				if (thesis_.getStudent() != null)
					a++;
			}
			num.add(a);
		}
		return "excel";
	}

	public Set<Thesis> getThesiss() {
		return thesiss;
	}

	public void setThesiss(Set<Thesis> thesiss) {
		this.thesiss = thesiss;
	}

	public List<Integer> getNum() {
		return num;
	}

	public void setNum(List<Integer> num) {
		this.num = num;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public String getTeacherno() {
		return teacherno;
	}

	public void setTeacherno(String teacherno) {
		this.teacherno = teacherno;
	}
}
