package hibernate.views;

/**
 * Views3 entity. @author MyEclipse Persistence Tools
 */

public class Views3 implements java.io.Serializable {

	// Fields

	private String sid;
	private String subname;
	private String sname;
	private String major;
	private String class_;
	private String tutor;
	private String gender;
	private Double credit;
	private String type;
	private String property;
	private String mode;

	// Constructors

	/** default constructor */
	public Views3() {
	}

	/** minimal constructor */
	public Views3(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Views3(String sid, Integer subid, String subname, String sname,
			String major, String class_, String tutor, String gender,
			Double credit, String type, String property, String mode) {
		this.sid = sid;
		this.subname = subname;
		this.sname = sname;
		this.major = major;
		this.class_ = class_;
		this.tutor = tutor;
		this.gender = gender;
		this.credit = credit;
		this.type = type;
		this.property = property;
		this.mode = mode;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
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
}