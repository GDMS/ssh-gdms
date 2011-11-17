package interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import root.student.StudentModAction;
import util.SecurityEx;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 实现学生权限过滤，并且将sessionId直接注入Action.
 * 
 * @author LICH
 * 
 */
public class SecurityInterceptor implements Interceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4503257197614921406L;
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(SecurityInterceptor.class);

	public static final String STUDENT = "1";
	public static final String TEACHER = "2";
	public static final String ADMIN = "3";

	private String type;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation inv) throws Exception {
		log.trace("StudentSecurityInterceptor:开始检查权限");
		// Get Action Context
		ActionContext ctx = inv.getInvocationContext();
		// Get Session Map
		Map<String, Object> session = ctx.getSession();

		String sessionType = (String) session.get("sessionType");
		String sessionId = (String) session.get("sessionId");

		if (sessionType == null || sessionId == null)
			return Action.LOGIN;
		if ((sessionType.isEmpty() || sessionId.isEmpty())
				|| !sessionType.equals(type))
			return Action.LOGIN;

		byte[] sessionDigest = (byte[]) session.get("sessionDigest");
		boolean good = SecurityEx.checkHash(sessionId, sessionDigest,
				SecurityEx.SHA1);
		if (!good)
			return Action.LOGIN;

		log.trace("StudentSecurityInterceptor:注入sessionID到Action");
		ValueStack valueStack = ctx.getValueStack();
		valueStack.setValue("sessionId", sessionId, false);
		valueStack.setValue("sessionType", sessionType, false);

		return inv.invoke();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
