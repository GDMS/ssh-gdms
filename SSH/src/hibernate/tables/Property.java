package hibernate.tables;

import java.util.Date;

/**
 * Property entity. @author MyEclipse Persistence Tools
 */

public class Property implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyId;
	private Boolean valueB;
	private Date valueD;
	private String value;

	// Constructors

	/** default constructor */
	public Property() {
	}

	/** minimal constructor */
	public Property(String name, String keyId) {
		this.name = name;
		this.keyId = keyId;
	}

	/** full constructor */
	public Property(String name, String keyId, Boolean valueB, Date valueD,
			String value) {
		this.name = name;
		this.keyId = keyId;
		this.valueB = valueB;
		this.valueD = valueD;
		this.value = value;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyId() {
		return this.keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public Boolean getValueB() {
		return this.valueB;
	}

	public void setValueB(Boolean valueB) {
		this.valueB = valueB;
	}

	public Date getValueD() {
		return this.valueD;
	}

	public void setValueD(Date valueD) {
		this.valueD = valueD;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return this.keyId;
	}

	public void setKey(String key) {
		this.keyId = key;
	}
}