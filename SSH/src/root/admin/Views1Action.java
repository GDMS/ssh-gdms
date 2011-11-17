package root.admin;

import hibernate.views.Views1;
import hibernate.views.Views1DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views1Action.class);

	@Autowired
	private List<Views1> views1s;
	private int page;
	private int totalPage;
	
	private Views1 views1;

	@Autowired
	private Views1DAO views1DAO;



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
		views1s = views1DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views1s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views1s.size())
			listEnd = views1s.size();
		views1s = views1s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views1s = views1DAO.findAll();
		return "excel";
	}

	public List<Views1> getViews1s() {
		return views1s;
	}

	public void setViews1s(List<Views1> views1s) {
		this.views1s = views1s;
	}

	public Views1 getViews1() {
		return views1;
	}

	public void setViews1(Views1 views1) {
		this.views1 = views1;
	}

	public Views1DAO getViews1DAO() {
		return views1DAO;
	}

	public void setViews1DAO(Views1DAO views1dao) {
		views1DAO = views1dao;
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
