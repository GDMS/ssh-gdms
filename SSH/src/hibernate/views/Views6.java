package hibernate.views;

/**
 * Views6 entity. @author MyEclipse Persistence Tools
 */

public class Views6 implements java.io.Serializable {

	// Fields

	private Views6Id id;
	private String sname;
	private String gender;
	private String major;
	private String class_;
	private Double credit;
	private String pretutor;
	private String subname;
	private String tutor;

	// Constructors

	/** default constructor */
	public Views6() {
	}

	/** minimal constructor */
	public Views6(Views6Id id) {
		this.id = id;
	}

	/** full constructor */
	public Views6(Views6Id id, String sname, String gender, String major,
			String class_, Double credit, String pretutor, String subname,
			String tutor) {
		this.id = id;
		this.sname = sname;
		this.gender = gender;
		this.major = major;
		this.class_ = class_;
		this.credit = credit;
		this.pretutor = pretutor;
		this.subname = subname;
		this.tutor = tutor;
	}

	// Property accessors

	public Views6Id getId() {
		return this.id;
	}

	public void setId(Views6Id id) {
		this.id = id;
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

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getPretutor() {
		return this.pretutor;
	}

	public void setPretutor(String pretutor) {
		this.pretutor = pretutor;
	}

	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

}