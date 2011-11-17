package hibernate.tables;

/**
 * Lw entity. @author MyEclipse Persistence Tools
 */

public class Lw implements java.io.Serializable {

	// Fields

	private Integer lwno;
	private String name;

	// Constructors

	/** default constructor */
	public Lw() {
	}

	/** full constructor */
	public Lw(String name) {
		this.name = name;
	}

	// Property accessors

	public Integer getLwno() {
		return this.lwno;
	}

	public void setLwno(Integer lwno) {
		this.lwno = lwno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}