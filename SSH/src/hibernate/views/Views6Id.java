package hibernate.views;

/**
 * Views6Id entity. @author MyEclipse Persistence Tools
 */

public class Views6Id implements java.io.Serializable {

	// Fields

	private String sid;
	private Integer suborder;

	// Constructors

	/** default constructor */
	public Views6Id() {
	}

	/** full constructor */
	public Views6Id(String sid, Integer suborder) {
		this.sid = sid;
		this.suborder = suborder;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getSuborder() {
		return this.suborder;
	}

	public void setSuborder(Integer suborder) {
		this.suborder = suborder;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Views6Id))
			return false;
		Views6Id castOther = (Views6Id) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getSuborder() == castOther.getSuborder()) || (this
						.getSuborder() != null
						&& castOther.getSuborder() != null && this
						.getSuborder().equals(castOther.getSuborder())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getSuborder() == null ? 0 : this.getSuborder().hashCode());
		return result;
	}
}