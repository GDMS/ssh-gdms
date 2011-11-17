package root.student;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class ThesisUpAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1914204124107107394L;
	@Autowired
	private StudentDAO studentDAO;
	/**
	 * 用于页面提交的Bean类
	 */
	private static final Log log = LogFactory.getLog(ThesisUpAction.class);
	private Student student;

	private File file;
	private String fileContentType;
	private String fileFileName;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	public String execute() throws Exception {
		if (file == null)
			return INPUT;

		int mid = fileFileName.lastIndexOf(".");
		String typeName = fileFileName.substring(mid + 1);
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload/Thesis");
		student = studentDAO.findById(sessionId);
		String fname = student.getStudentno();
		byte[] buffer = new byte[10240000];
		InputStream in = new FileInputStream(file);
		// OutputStream out = new FileOutputStream(new
		// File(path,fname+"."+typeName));
		String fullname = "thesis" + fname + "." + typeName;
		OutputStream out = new FileOutputStream(new File(path + "\\" + "thesis"
				+ fname + "." + typeName));
		int length = in.read(buffer);

		out.write(buffer, 0, length);
		// length = in.read(buffer);

		in.close();
		out.flush();
		out.close();
		student.getStudentMaterialUpload().setThesisup(fullname);
		log.info("论文上传到服务器："+fullname);
		return SUCCESS;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
