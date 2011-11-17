package root.admin;

import hibernate.views.Views7;
import hibernate.views.Views7DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views7Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views7Action.class);

	@Autowired
	private List<Views7> views7s;
	private int page;
	private int totalPage;
	
	private Views7 views7;

	@Autowired
	private Views7DAO views7DAO;



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
		views7s = views7DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views7s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views7s.size())
			listEnd = views7s.size();
		views7s = views7s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views7s = views7DAO.findAll();
		return "excel";
	}
	public List<Views7> getViews7s() {
		return views7s;
	}

	public void setViews7s(List<Views7> views7s) {
		this.views7s = views7s;
	}

	public Views7 getViews7() {
		return views7;
	}

	public void setViews7(Views7 views7) {
		this.views7 = views7;
	}

	public Views7DAO getViews7DAO() {
		return views7DAO;
	}

	public void setViews7DAO(Views7DAO views7dao) {
		views7DAO = views7dao;
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
