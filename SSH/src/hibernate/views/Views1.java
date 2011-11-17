package hibernate.views;

/**
 * Views1 entity. @author MyEclipse Persistence Tools
 */

public class Views1 implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String gender;
	private Double credit;
	private String tutor;
	private String major;
	private String class_;
	private String assign;
	private String autoassign;

	// Constructors

	/** default constructor */
	public Views1() {
	}

	/** minimal constructor */
	public Views1(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Views1(String sid, String sname, String gender, Double credit,
			String tutor, String major, String class_, String assign,
			String autoassign) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.credit = credit;
		this.tutor = tutor;
		this.major = major;
		this.class_ = class_;
		this.assign = assign;
		this.autoassign = autoassign;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getAutoassign() {
		return this.autoassign;
	}

	public void setAutoassign(String autoassign) {
		this.autoassign = autoassign;
	}

} 