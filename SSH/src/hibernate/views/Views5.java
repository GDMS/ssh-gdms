package hibernate.views;

/**
 * Views5 entity. @author MyEclipse Persistence Tools
 */

public class Views5 implements java.io.Serializable {

	// Fields

	private String studentno;
	private String sname;
	private String gender;
	private Double credit;
	private String tutor;
	private String major;
	private String class_;
	private String assign;

	// Constructors

	/** default constructor */
	public Views5() {
	}

	/** minimal constructor */
	public Views5(String studentno) {
		this.studentno = studentno;
	}

	/** full constructor */
	public Views5(String studentno, String sname, String gender,
			Double credit, String tutor, String major, String class_,
			String assign) {
		this.studentno = studentno;
		this.sname = sname;
		this.gender = gender;
		this.credit = credit;
		this.tutor = tutor;
		this.major = major;
		this.class_ = class_;
		this.assign = assign;
	}

	// Property accessors

	public String getStudentno() {
		return this.studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getAssign() {
		return this.assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}
}