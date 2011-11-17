package root.admin;

import hibernate.views.Views5;
import hibernate.views.Views5DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views5Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views5Action.class);

	@Autowired
	private List<Views5> views5s;
	private int page;
	private int totalPage;
	
	private Views5 views5;

	@Autowired
	private Views5DAO views5DAO;



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
		views5s = views5DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views5s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views5s.size())
			listEnd = views5s.size();
		views5s = views5s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views5s = views5DAO.findAll();
		return "excel";
	}
	public List<Views5> getViews5s() {
		return views5s;
	}

	public void setViews5s(List<Views5> views5s) {
		this.views5s = views5s;
	}

	public Views5 getViews5() {
		return views5;
	}

	public void setViews5(Views5 views5) {
		this.views5 = views5;
	}

	public Views5DAO getViews5DAO() {
		return views5DAO;
	}

	public void setViews5DAO(Views5DAO views5dao) {
		views5DAO = views5dao;
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
