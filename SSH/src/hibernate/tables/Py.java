package hibernate.tables;

/**
 * Py entity. @author MyEclipse Persistence Tools
 */

public class Py implements java.io.Serializable {

	// Fields

	private Integer pyno;
	private String lv;
	private String zdpingyu;
	private String pypingyu;
	private String dbpingyu;

	// Constructors

	/** default constructor */
	public Py() {
	}

	/** full constructor */
	public Py(String lv, String zdpingyu, String pypingyu, String dbpingyu) {
		this.lv = lv;
		this.zdpingyu = zdpingyu;
		this.pypingyu = pypingyu;
		this.dbpingyu = dbpingyu;
	}

	// Property accessors

	public Integer getPyno() {
		return this.pyno;
	}

	public void setPyno(Integer pyno) {
		this.pyno = pyno;
	}

	public String getLv() {
		return this.lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public String getZdpingyu() {
		return this.zdpingyu;
	}

	public void setZdpingyu(String zdpingyu) {
		this.zdpingyu = zdpingyu;
	}

	public String getPypingyu() {
		return this.pypingyu;
	}

	public void setPypingyu(String pypingyu) {
		this.pypingyu = pypingyu;
	}

	public String getDbpingyu() {
		return this.dbpingyu;
	}

	public void setDbpingyu(String dbpingyu) {
		this.dbpingyu = dbpingyu;
	}
}