package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * Thesis entity. @author MyEclipse Persistence Tools
 */

public class Thesis implements java.io.Serializable {

	// Fields

	private Integer thesisno;
	private Teacher teacher;
	private String name;
	private String type;
	private String property;
	private String mode;
	private String assigned;
	private Set previews = new HashSet(0);
	private Student student;

	// Constructors

	/** default constructor */
	public Thesis() {
	}

	/** full constructor */
	public Thesis(Teacher teacher, String name, String type, String property,
			String mode, String assigned, Set previews, Student student) {
		this.teacher = teacher;
		this.name = name;
		this.type = type;
		this.property = property;
		this.mode = mode;
		this.assigned = assigned;
		this.previews = previews;
		this.student = student;
	}

	// Property accessors

	public Integer getThesisno() {
		return this.thesisno;
	}

	public void setThesisno(Integer thesisno) {
		this.thesisno = thesisno;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAssigned() {
		return this.assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public Set getPreviews() {
		return this.previews;
	}

	public void setPreviews(Set previews) {
		this.previews = previews;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}