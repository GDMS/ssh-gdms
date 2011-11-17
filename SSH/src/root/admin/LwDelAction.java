package root.admin;

import java.util.List;
import java.util.Map;

import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.Lw;
import hibernate.tables.LwDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.FileManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class LwDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7744035966231057426L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(LwDelAction.class);

	private List<Lw> lws;
	private int lwno;
	@Autowired
	private LwDAO lwDAO;
	@Autowired
	private FileManager fileManager;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		lws = lwDAO.findAll();
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		
			Lw lw = lwDAO.findById(lwno);
			// 删除上传文件夹下的多余文件

			if (!fileManager.deleteFile(lw.getName(), FileManager.YXLW)) {
				addActionError("删除失败");
				return ERROR;
			}
			log.info("删除优秀论文" + lw);
			lwDAO.delete(lw);
		
		return SUCCESS;
	}

	public LwDAO getLwDAO() {
		return lwDAO;
	}

	public void setLwDAO(LwDAO lwDAO) {
		this.lwDAO = lwDAO;
	}

	public List<Lw> getLws() {
		return lws;
	}

	public void setLws(List<Lw> lws) {
		this.lws = lws;
	}

	public int getLwno() {
		return lwno;
	}

	public void setLwno(int lwno) {
		this.lwno = lwno;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
