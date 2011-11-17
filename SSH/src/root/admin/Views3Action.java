package root.admin;

import hibernate.views.Views3;
import hibernate.views.Views3DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views3Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views3Action.class);

	@Autowired
	private List<Views3> views3s;
	private int page;
	private int totalPage;
	
	private Views3 views3;

	@Autowired
	private Views3DAO views3DAO;



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
		views3s = views3DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views3s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views3s.size())
			listEnd = views3s.size();
		views3s = views3s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views3s = views3DAO.findAll();
		return "excel";
	}
	public List<Views3> getViews3s() {
		return views3s;
	}

	public void setViews3s(List<Views3> views3s) {
		this.views3s = views3s;
	}

	public Views3 getViews3() {
		return views3;
	}

	public void setViews3(Views3 views3) {
		this.views3 = views3;
	}

	public Views3DAO getViews3DAO() {
		return views3DAO;
	}

	public void setViews3DAO(Views3DAO views3dao) {
		views3DAO = views3dao;
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
