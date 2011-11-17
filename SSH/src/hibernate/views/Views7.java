package hibernate.views;



/**
 * Views7 entity. @author MyEclipse Persistence Tools
 */

public class Views7  implements java.io.Serializable {


    // Fields    

     private String sid;
     private String sname;
     private String gender;
     private String major;
     private String class_;
     private String tutor;
     private String subname;
     private Double grade;
     private Double credit;
     private String phone;
     private String email;


    // Constructors

    /** default constructor */
    public Views7() {
    }

	/** minimal constructor */
    public Views7(String sid) {
        this.sid = sid;
    }
    
    /** full constructor */
    public Views7(String sid, String sname, String gender, String major, String class_, String tutor, String subname, Double grade, Double credit, String phone, String email) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.major = major;
        this.class_ = class_;
        this.tutor = tutor;
        this.subname = subname;
        this.grade = grade;
        this.credit = credit;
        this.phone = phone;
        this.email = email;
    }

   
    // Property accessors

    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }

    public String getClass_() {
        return this.class_;
    }
    
    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getTutor() {
        return this.tutor;
    }
    
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getSubname() {
        return this.subname;
    }
    
    public void setSubname(String subname) {
        this.subname = subname;
    }

    public Double getGrade() {
        return this.grade;
    }
    
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getCredit() {
        return this.credit;
    }
    
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}