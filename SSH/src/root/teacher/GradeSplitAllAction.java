package root.teacher;

import java.util.List;

import hibernate.tables.Py;
import hibernate.tables.PyDAO;
import hibernate.tables.StudentScore;
import hibernate.tables.StudentScoreDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.MathEx;

import com.opensymphony.xwork2.ActionSupport;

public class GradeSplitAllAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentScore studentScore;
	@Autowired
	private StudentScoreDAO studentScoreDAO;
	
	private Integer[] grades;
	
	private String[] studentsno ;
	@Autowired
	private PyDAO pyDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=false)
	public String execute() throws Exception {
		int grade =0 ;
		int zd1grade=0,zd2grade=0,
			zd3grade=0,zd4grade=0,
			py1grade=0,py2grade=0,
			db1grade=0,db2grade=0;
		String studentno ;
		if(grades==null||studentsno==null)
		{
			return SUCCESS;
		}
		int size = 0;
		List<Py> py;
		String Dbpingyu;
		String Pypingyu;
		String Zdpingyu;
		for(int i=0;i<grades.length;i++)
		{
			if(grades[i]!=null&&!studentsno[i].equals(""))
			{
				studentno = studentsno[i];
				grade = grades[i];
				studentScore = studentScoreDAO.findById(studentno);
				if(grade<100&&grade>0)
				{
					zd1grade = (int) (random(1,1.05) * grade) ;
					zd2grade = (int) (random(1,1.05) * grade) ;
					zd3grade = (int) (random(1,1.05) * grade) ;
					zd4grade = (int) (random(1,1.05) * grade) ;
					py1grade = (int) (random(1,1.05) * grade) ;
					py2grade = (int) (random(1,1.05) * grade) ;
					db1grade = (int) (random(1,1.05) * grade) ;
					db2grade = (int) (random(1,1.05) * grade) ;
					studentScore.setGrade(grade);
					studentScore.setZd1grade(zd1grade);
					studentScore.setZd2grade(zd2grade);
					studentScore.setZd3grade(zd3grade);
					studentScore.setZd4grade(zd4grade);
					studentScore.setPy1grade(py1grade);
					studentScore.setPy2grade(py2grade);
					studentScore.setDb1grade(db1grade);
					studentScore.setDb2grade(db2grade);
					if (grade >= 85 && grade <= 100) {
						py = pyDAO.findByLv("A");
						size = py.size();
						Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
						Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
						Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
					} else if (grade >= 75 && grade <= 84) {
						py = pyDAO.findByLv("B");
						size = py.size();
						Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
						Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
						Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
					} else if (grade >= 60 && grade <= 74) {
						py = pyDAO.findByLv("C");
						size = py.size();
						Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
						Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
						Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();
					} else if (grade >= 0 && grade <= 59) {
						py = pyDAO.findByLv("D");
						size = py.size();
						Dbpingyu = py.get(MathEx.randomInt(0, size - 1)).getDbpingyu();
						Pypingyu = py.get(MathEx.randomInt(0, size - 1)).getPypingyu();
						Zdpingyu = py.get(MathEx.randomInt(0, size - 1)).getZdpingyu();

					}
				}
			}
		}
			return SUCCESS;
	}

	public double random(double bound1,double bound2){
		return Math.random() * (bound1 - bound2) + bound2;
	}
	public StudentScore getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(StudentScore studentScore) {
		this.studentScore = studentScore;
	}

	public StudentScoreDAO getStudentScoreDAO() {
		return studentScoreDAO;
	}

	public void setStudentScoreDAO(StudentScoreDAO studentScoreDAO) {
		this.studentScoreDAO = studentScoreDAO;
	}

	public Integer[] getGrades() {
		return grades;
	}

	public void setGrades(Integer[] grades) {
		this.grades = grades;
	}

	public String[] getStudentsno() {
		return studentsno;
	}

	public void setStudentsno(String[] studentsno) {
		this.studentsno = studentsno;
	}

	public void setPyDAO(PyDAO pyDAO) {
		this.pyDAO = pyDAO;
	}

	
}
