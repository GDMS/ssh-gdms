package hibernate.tables;

/**
 * Preview entity. @author MyEclipse Persistence Tools
 */

public class Preview implements java.io.Serializable {

	// Fields

	private Integer previewno;
	private Thesis thesis;
	private Student student;
	private Integer suborder;

	// Constructors

	/** default constructor */
	public Preview() {
	}

	/** full constructor */
	public Preview(Thesis thesis, Student student, Integer suborder) {
		this.thesis = thesis;
		this.student = student;
		this.suborder = suborder;
	}

	// Property accessors

	public Integer getPreviewno() {
		return this.previewno;
	}

	public void setPreviewno(Integer previewno) {
		this.previewno = previewno;
	}

	public Thesis getThesis() {
		return this.thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getSuborder() {
		return this.suborder;
	}

	public void setSuborder(Integer suborder) {
		this.suborder = suborder;
	}

}