package root;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2634423494601939954L;

	/**
	 * 移除所有Session
	 */
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
}
