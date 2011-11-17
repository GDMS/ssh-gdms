package hibernate.tables;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	private String name;
	private String password;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(String name) {
		this.name = name;
	}

	/** full constructor */
	public Administrator(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Property accessors

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

}