package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String studentno;
	private StuClass stuClass;
	private Thesis thesis;
	private String name;
	private String gender;
	private Double credit;
	private String password;
	private String assign;
	private String autoassign;
	private String phone;
	private String email;
	private StudentMaterialUpload studentMaterialUpload;
	private StudentScore studentScore;
	private Set previews = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentno) {
		this.studentno = studentno;
	}

	/** full constructor */
	public Student(String studentno, StuClass stuClass, Thesis thesis,
			String name, String gender, Double credit, String password,
			String assign, String autoassign, String phone, String email,
			StudentMaterialUpload studentMaterialUpload,
			StudentScore studentScore, Set previews) {
		this.studentno = studentno;
		this.stuClass = stuClass;
		this.thesis = thesis;
		this.name = name;
		this.gender = gender;
		this.credit = credit;
		this.password = password;
		this.assign = assign;
		this.autoassign = autoassign;
		this.phone = phone;
		this.email = email;
		this.studentMaterialUpload = studentMaterialUpload;
		this.studentScore = studentScore;
		this.previews = previews;
	}

	// Property accessors

	public String getStudentno() {
		return this.studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public StuClass getStuClass() {
		return this.stuClass;
	}

	public void setStuClass(StuClass stuClass) {
		this.stuClass = stuClass;
	}

	public Thesis getThesis() {
		return this.thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAssign() {
		return this.assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

	public String getAutoassign() {
		return this.autoassign;
	}

	public void setAutoassign(String autoassign) {
		this.autoassign = autoassign;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentMaterialUpload getStudentMaterialUpload() {
		return this.studentMaterialUpload;
	}

	public void setStudentMaterialUpload(
			StudentMaterialUpload studentMaterialUpload) {
		this.studentMaterialUpload = studentMaterialUpload;
	}

	public StudentScore getStudentScore() {
		return this.studentScore;
	}

	public void setStudentScore(StudentScore studentScore) {
		this.studentScore = studentScore;
	}

	public Set getPreviews() {
		return this.previews;
	}

	public void setPreviews(Set previews) {
		this.previews = previews;
	}

}