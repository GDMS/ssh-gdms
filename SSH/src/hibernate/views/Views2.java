package hibernate.views;

/**
 * Views2 entity. @author MyEclipse Persistence Tools
 */

public class Views2 implements java.io.Serializable {

	// Fields

	private Views2Id id;
	private String sname;
	private Double credit;
	private String tutor;
	private String expr;
	private String subname;

	// Constructors

	/** default constructor */
	public Views2() {
	}

	/** minimal constructor */
	public Views2(Views2Id id) {
		this.id = id;
	}

	/** full constructor */
	public Views2(Views2Id id, String sname, Double credit, String tutor,
			String expr, String subname) {
		this.id = id;
		this.sname = sname;
		this.credit = credit;
		this.tutor = tutor;
		this.expr = expr;
		this.subname = subname;
	}

	// Property accessors

	public Views2Id getId() {
		return this.id;
	}

	public void setId(Views2Id id) {
		this.id = id;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getExpr() {
		return this.expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

}