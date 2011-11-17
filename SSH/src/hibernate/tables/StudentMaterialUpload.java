package hibernate.tables;

/**
 * StudentMaterialUpload entity. @author MyEclipse Persistence Tools
 */

public class StudentMaterialUpload implements java.io.Serializable {

	// Fields

	private String studentno;
	private Student student;
	private String ktup;
	private String rwsup;
	private String transup;
	private String thesisup;

	// Constructors

	/** default constructor */
	public StudentMaterialUpload() {
	}

	/** minimal constructor */
	public StudentMaterialUpload(String studentno, Student student) {
		this.studentno = studentno;
		this.student = student;
	}

	/** full constructor */
	public StudentMaterialUpload(String studentno, Student student,
			String ktup, String rwsup, String transup, String thesisup) {
		this.studentno = studentno;
		this.student = student;
		this.ktup = ktup;
		this.rwsup = rwsup;
		this.transup = transup;
		this.thesisup = thesisup;
	}

	// Property accessors

	public String getStudentno() {
		return this.studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getKtup() {
		return this.ktup;
	}

	public void setKtup(String ktup) {
		this.ktup = ktup;
	}

	public String getRwsup() {
		return this.rwsup;
	}

	public void setRwsup(String rwsup) {
		this.rwsup = rwsup;
	}

	public String getTransup() {
		return this.transup;
	}

	public void setTransup(String transup) {
		this.transup = transup;
	}

	public String getThesisup() {
		return this.thesisup;
	}

	public void setThesisup(String thesisup) {
		this.thesisup = thesisup;
	}

}