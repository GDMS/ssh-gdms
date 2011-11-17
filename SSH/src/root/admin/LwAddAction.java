package root.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Lw;
import hibernate.tables.LwDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LwAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 867738920873234380L;
	/**
	 * 用于页面提交的Bean类
	 */
	private static final Log log = LogFactory.getLog(LwAddAction.class);

	private Administrator admin;

	@Autowired
	private AdministratorDAO adminDAO;

	private Lw lw;
	@Autowired
	private LwDAO lwDAO;
	private File file;
	private String fileContentType;
	private String fileFileName;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		if (file == null) {
			addActionError("论文不存在");
			return INPUT;
		}

		lw = new Lw();
		if (!lwDAO.findByName(fileFileName).isEmpty()) {
			addActionError("论文已存在");
			return INPUT;
		}
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload/YXLW");
		byte[] buffer = new byte[10240000];
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(new File(path + "\\"
				+ fileFileName));
		int length = in.read(buffer);
		out.write(buffer, 0, length);
		in.close();
		out.flush();
		out.close();
		lw.setName(fileFileName);
		lwDAO.save(lw);
		log.info("增加优秀论文" + lw);
		return SUCCESS;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public AdministratorDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdministratorDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public Lw getLw() {
		return lw;
	}

	public void setLw(Lw lw) {
		this.lw = lw;
	}

	public LwDAO getLwDAO() {
		return lwDAO;
	}

	public void setLwDAO(LwDAO lwDAO) {
		this.lwDAO = lwDAO;
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
