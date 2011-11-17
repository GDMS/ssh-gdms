package root.admin;

import hibernate.views.Views2;
import hibernate.views.Views2DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views2Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views2Action.class);

	@Autowired
	private List<Views2> views2s;
	private int page;
	private int totalPage;
	
	private Views2 views2;

	@Autowired
	private Views2DAO views2DAO;



	/**
	 * 实现用户登录
	 */
	@Override
	@Transactional(readOnly = false)
	public String execute() throws Exception {	
		return SUCCESS;
	}

	public String query() throws Exception {
		// 获得session
		String sessionType;
		String sessionId;
		Map<String, Object> session = ActionContext.getContext().getSession();
		sessionId = (String) session.get("sessionId");
		sessionType = (String) session.get("sessionType");
		if ((sessionType == null || sessionId == null) && sessionType != "3") {
			addActionError("用户不存在！");
			return ERROR;
		}
		views2s = views2DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views2s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views2s.size())
			listEnd = views2s.size();
		views2s = views2s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views2s = views2DAO.findAll();
		return "excel";
	}

	public List<Views2> getViews2s() {
		return views2s;
	}

	public void setViews2s(List<Views2> views2s) {
		this.views2s = views2s;
	}

	public Views2 getViews2() {
		return views2;
	}

	public void setViews2(Views2 views2) {
		this.views2 = views2;
	}

	public Views2DAO getViews2DAO() {
		return views2DAO;
	}

	public void setViews2DAO(Views2DAO views2dao) {
		views2DAO = views2dao;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
