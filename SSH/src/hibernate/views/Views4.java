package hibernate.views;

/**
 * Views4 entity. @author MyEclipse Persistence Tools
 */

public class Views4 implements java.io.Serializable {

	// Fields

	private String tid;
	private String tutor;
	private Integer plannum;
	private Long subnum;
	private Long actualnum;
	private Long dif;

	// Constructors

	/** default constructor */
	public Views4() {
	}

	/** minimal constructor */
	public Views4(String tid, Long subnum, Long actualnum) {
		this.tid = tid;
		this.subnum = subnum;
		this.actualnum = actualnum;
	}

	/** full constructor */
	public Views4(String tid, String tutor, Integer plannum, Long subnum,
			Long actualnum, Long dif) {
		this.tid = tid;
		this.tutor = tutor;
		this.plannum = plannum;
		this.subnum = subnum;
		this.actualnum = actualnum;
		this.dif = dif;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Integer getPlannum() {
		return this.plannum;
	}

	public void setPlannum(Integer plannum) {
		this.plannum = plannum;
	}

	public Long getSubnum() {
		return this.subnum;
	}

	public void setSubnum(Long subnum) {
		this.subnum = subnum;
	}

	public Long getActualnum() {
		return this.actualnum;
	}

	public void setActualnum(Long actualnum) {
		this.actualnum = actualnum;
	}

	public Long getDif() {
		return this.dif;
	}

	public void setDif(Long dif) {
		this.dif = dif;
	}
}