package root.student;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class AssignmentUpAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9142429598273375432L;
	
	/**
	 * Log
	 */
	private final Log log = LogFactory.getLog(getClass());
	@Autowired
	private StudentDAO studentDAO;
	/**
	 * 用于页面提交的Bean类
	 */
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
		int mid = fileFileName.lastIndexOf(".");
		String typeName = fileFileName.substring(mid + 1);
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload/RWSReport");
		student = studentDAO.findById(sessionId);
		String fname = student.getStudentno();
		byte[] buffer = new byte[10240000];
		InputStream in = new FileInputStream(file);
		// OutputStream out = new FileOutputStream(new
		// File(path,fname+"."+typeName));
		String fullname = "RWS" + fname + "." + typeName;
		OutputStream out = new FileOutputStream(new File(path + "\\" + "RWS"
				+ fname + "." + typeName));
		int length = in.read(buffer);

		out.write(buffer, 0, length);
		// length = in.read(buffer);

		in.close();
		out.flush();
		out.close();
		student.getStudentMaterialUpload().setRwsup(fullname);
		log.info("任务书上传到服务器："+fullname);
		return SUCCESS;
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}

	/**
	 * @param fileContentType
	 *            the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * @return the fileFileName
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	/**
	 * @param fileFileName
	 *            the fileFileName to set
	 */
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
