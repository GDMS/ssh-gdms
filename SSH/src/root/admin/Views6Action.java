package root.admin;

import hibernate.views.Views6;
import hibernate.views.Views6DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views6Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views6Action.class);

	@Autowired
	private List<Views6> views6s;
	private int page;
	private int totalPage;
	
	private Views6 views6;

	@Autowired
	private Views6DAO views6DAO;



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
		views6s = views6DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views6s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views6s.size())
			listEnd = views6s.size();
		views6s = views6s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views6s = views6DAO.findAll();
		return "excel";
	}
	public List<Views6> getViews6s() {
		return views6s;
	}

	public void setViews6s(List<Views6> views6s) {
		this.views6s = views6s;
	}

	public Views6 getViews6() {
		return views6;
	}

	public void setViews6(Views6 views6) {
		this.views6 = views6;
	}

	public Views6DAO getViews6DAO() {
		return views6DAO;
	}

	public void setViews6DAO(Views6DAO views6dao) {
		views6DAO = views6dao;
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
