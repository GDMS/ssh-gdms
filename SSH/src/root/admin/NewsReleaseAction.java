package root.admin;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hibernate.tables.Administrator;
import hibernate.tables.AdministratorDAO;
import hibernate.tables.News;
import hibernate.tables.NewsDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class NewsReleaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 679901446865946666L;
	
	/**
	 * Log
	 */
	private final Log log = LogFactory.getLog(getClass());
	@Autowired
	private AdministratorDAO adminDAO;
	private Administrator admin;
	@Autowired
	private NewsDAO newsDAO;
	private News news;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		admin = adminDAO.findById(sessionId);
		news = newsDAO.findById(1);
		return SUCCESS;
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		String MsgToAll = news.getMsgToAll();
		String MsgToStu = news.getMsgToStu();
		String MsgToTea = news.getMsgToTea();

		admin = adminDAO.findById(sessionId);
		news = newsDAO.findById(1);
		if (!MsgToAll.isEmpty()) {
			news.setMsgToAll(MsgToAll);
		}
		if (!MsgToStu.isEmpty()) {
			news.setMsgToStu(MsgToStu);
		}
		if (!MsgToTea.isEmpty()) {
			news.setMsgToTea(MsgToTea);
		}
		return "changesuccess";
	}

	public AdministratorDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdministratorDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
