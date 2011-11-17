package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * TeacherDept entity. @author MyEclipse Persistence Tools
 */

public class TeacherDept implements java.io.Serializable {

	// Fields

	private Integer deptno;
	private String name;
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeacherDept() {
	}

	/** full constructor */
	public TeacherDept(String name, Set teachers) {
		this.name = name;
		this.teachers = teachers;
	}

	// Property accessors

	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}