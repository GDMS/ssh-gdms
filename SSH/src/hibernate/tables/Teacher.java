package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private String teacherno;
	private TeacherDept teacherDept;
	private String name;
	private String password;
	private Integer subnum;
	private Integer maxassign;
	private String tel;
	private String mail;
	private Set thesises = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String teacherno) {
		this.teacherno = teacherno;
	}

	/** full constructor */
	public Teacher(String teacherno, TeacherDept teacherDept, String name,
			String password, Integer subnum, Integer maxassign, String tel,
			String mail, Set thesises) {
		this.teacherno = teacherno;
		this.teacherDept = teacherDept;
		this.name = name;
		this.password = password;
		this.subnum = subnum;
		this.maxassign = maxassign;
		this.tel = tel;
		this.mail = mail;
		this.thesises = thesises;
	}

	// Property accessors

	public String getTeacherno() {
		return this.teacherno;
	}

	public void setTeacherno(String teacherno) {
		this.teacherno = teacherno;
	}

	public TeacherDept getTeacherDept() {
		return this.teacherDept;
	}

	public void setTeacherDept(TeacherDept teacherDept) {
		this.teacherDept = teacherDept;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSubnum() {
		return this.subnum;
	}

	public void setSubnum(Integer subnum) {
		this.subnum = subnum;
	}

	public Integer getMaxassign() {
		return this.maxassign;
	}

	public void setMaxassign(Integer maxassign) {
		this.maxassign = maxassign;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set getThesises() {
		return this.thesises;
	}

	public void setThesises(Set thesises) {
		this.thesises = thesises;
	}

}