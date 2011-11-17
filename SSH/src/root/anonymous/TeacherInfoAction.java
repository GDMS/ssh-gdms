package root.anonymous;

import hibernate.tables.Teacher;
import hibernate.tables.TeacherDAO;
import hibernate.tables.Thesis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherInfoAction extends ActionSupport {

	private int page;
	private int totalPage;
	private List<Teacher> teachers;
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	@Transactional(readOnly = true)
	public String execute() {
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
		return SUCCESS;
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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
}
