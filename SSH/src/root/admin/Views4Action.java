package root.admin;

import hibernate.views.Views4;
import hibernate.views.Views4DAO;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class Views4Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736736766025498199L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(Views4Action.class);

	@Autowired
	private List<Views4> views4s;
	private int page;
	private int totalPage;
	
	private Views4 views4;

	@Autowired
	private Views4DAO views4DAO;



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
		views4s = views4DAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = views4s.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= views4s.size())
			listEnd = views4s.size();
		views4s = views4s.subList(listStart, listEnd);
		return SUCCESS;
	}
	public String Excel(){
		views4s = views4DAO.findAll();
		return "excel";
	}
	public List<Views4> getViews4s() {
		return views4s;
	}

	public void setViews4s(List<Views4> views4s) {
		this.views4s = views4s;
	}

	public Views4 getViews4() {
		return views4;
	}

	public void setViews4(Views4 views4) {
		this.views4 = views4;
	}

	public Views4DAO getViews4DAO() {
		return views4DAO;
	}

	public void setViews4DAO(Views4DAO views4dao) {
		views4DAO = views4dao;
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
