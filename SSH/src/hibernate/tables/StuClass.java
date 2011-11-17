package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * StuClass entity. @author MyEclipse Persistence Tools
 */

public class StuClass implements java.io.Serializable {

	// Fields

	private Integer classno;
	private Major major;
	private String name;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public StuClass() {
	}

	/** full constructor */
	public StuClass(Major major, String name, Set students) {
		this.major = major;
		this.name = name;
		this.students = students;
	}

	// Property accessors

	public Integer getClassno() {
		return this.classno;
	}

	public void setClassno(Integer classno) {
		this.classno = classno;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}