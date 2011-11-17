package hibernate.tables;

/**
 * StudentScore entity. @author MyEclipse Persistence Tools
 */

public class StudentScore implements java.io.Serializable {

	// Fields

	private String studentno;
	private Student student;
	private String progress;
	private String quality;
	private String attitude;
	private String duty;
	private String remark;
	private String warn;
	private Integer grade;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private String question3;
	private String answer3;
	private String projDesc;
	private String thesDesc;
	private Integer zd1grade;
	private Integer zd2grade;
	private Integer zd3grade;
	private Integer zd4grade;
	private Integer py1grade;
	private Integer py2grade;
	private Integer db1grade;
	private Integer db2grade;
	private String zdpingyu;
	private String pypingyu;
	private String dbpingyu;

	// Constructors

	/** default constructor */
	public StudentScore() {
	}

	/** minimal constructor */
	public StudentScore(String studentno, Student student) {
		this.studentno = studentno;
		this.student = student;
	}

	/** full constructor */
	public StudentScore(String studentno, Student student, String progress,
			String quality, String attitude, String duty, String remark,
			String warn, Integer grade, String question1, String answer1,
			String question2, String answer2, String question3, String answer3,
			String projDesc, String thesDesc, Integer zd1grade,
			Integer zd2grade, Integer zd3grade, Integer zd4grade,
			Integer py1grade, Integer py2grade, Integer db1grade,
			Integer db2grade, String zdpingyu, String pypingyu, String dbpingyu) {
		this.studentno = studentno;
		this.student = student;
		this.progress = progress;
		this.quality = quality;
		this.attitude = attitude;
		this.duty = duty;
		this.remark = remark;
		this.warn = warn;
		this.grade = grade;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
		this.question3 = question3;
		this.answer3 = answer3;
		this.projDesc = projDesc;
		this.thesDesc = thesDesc;
		this.zd1grade = zd1grade;
		this.zd2grade = zd2grade;
		this.zd3grade = zd3grade;
		this.zd4grade = zd4grade;
		this.py1grade = py1grade;
		this.py2grade = py2grade;
		this.db1grade = db1grade;
		this.db2grade = db2grade;
		this.zdpingyu = zdpingyu;
		this.pypingyu = pypingyu;
		this.dbpingyu = dbpingyu;
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

	public String getProgress() {
		return this.progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getQuality() {
		return this.quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getAttitude() {
		return this.attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWarn() {
		return this.warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getQuestion1() {
		return this.question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return this.question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getQuestion3() {
		return this.question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getProjDesc() {
		return this.projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public String getThesDesc() {
		return this.thesDesc;
	}

	public void setThesDesc(String thesDesc) {
		this.thesDesc = thesDesc;
	}

	public Integer getZd1grade() {
		return this.zd1grade;
	}

	public void setZd1grade(Integer zd1grade) {
		this.zd1grade = zd1grade;
	}

	public Integer getZd2grade() {
		return this.zd2grade;
	}

	public void setZd2grade(Integer zd2grade) {
		this.zd2grade = zd2grade;
	}

	public Integer getZd3grade() {
		return this.zd3grade;
	}

	public void setZd3grade(Integer zd3grade) {
		this.zd3grade = zd3grade;
	}

	public Integer getZd4grade() {
		return this.zd4grade;
	}

	public void setZd4grade(Integer zd4grade) {
		this.zd4grade = zd4grade;
	}

	public Integer getPy1grade() {
		return this.py1grade;
	}

	public void setPy1grade(Integer py1grade) {
		this.py1grade = py1grade;
	}

	public Integer getPy2grade() {
		return this.py2grade;
	}

	public void setPy2grade(Integer py2grade) {
		this.py2grade = py2grade;
	}

	public Integer getDb1grade() {
		return this.db1grade;
	}

	public void setDb1grade(Integer db1grade) {
		this.db1grade = db1grade;
	}

	public Integer getDb2grade() {
		return this.db2grade;
	}

	public void setDb2grade(Integer db2grade) {
		this.db2grade = db2grade;
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