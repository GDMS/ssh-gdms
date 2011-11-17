package hibernate.tables;

import java.util.HashSet;
import java.util.Set;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer majorno;
	private String name;
	private Set stuClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** full constructor */
	public Major(String name, Set stuClasses) {
		this.name = name;
		this.stuClasses = stuClasses;
	}

	// Property accessors

	public Integer getMajorno() {
		return this.majorno;
	}

	public void setMajorno(Integer majorno) {
		this.majorno = majorno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStuClasses() {
		return this.stuClasses;
	}

	public void setStuClasses(Set stuClasses) {
		this.stuClasses = stuClasses;
	}

}