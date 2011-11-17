package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hibernate.tables.Student;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7480864347088631930L;
	private Map<String, String> map;
	private List<String> list;
	private List<Student> student;

	@Override
	public String execute() throws Exception {
		map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		student = new ArrayList<Student>();
		Student stu = new Student();
		stu.setStudentno("00011122");
		student.add(stu);
		stu = new Student();
		stu.setStudentno("11122233");
		student.add(stu);
		list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		return SUCCESS;
	}

}
