package root.admin;

import java.util.Iterator;
import java.util.List;

import hibernate.tables.Preview;
import hibernate.tables.PreviewDAO;
import hibernate.tables.Student;
import hibernate.tables.Thesis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AssignAutoEnhancedAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6847535539204052816L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory
			.getLog(AssignAutoEnhancedAction.class);

	@Autowired
	PreviewDAO previewDAO;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Override
	public String execute() throws Exception {
		firstAssign();
		secondAssign();
		thridAssign();

		return SUCCESS;
	}

	protected boolean firstAssign() {
		@SuppressWarnings("unchecked")
		List<Preview> previews = previewDAO.findAll();
		Iterator<Preview> it = previews.iterator();

		Thesis previewThesis = null;
		Student previewStudent = null;
		// Student oldPreviewStudent = null;
		String assignedState = null;
		while (it.hasNext()) {
			Preview preview_ = it.next();
			previewThesis = preview_.getThesis();
			previewStudent = preview_.getStudent();
			assignedState = previewThesis.getAssigned();

			// 判断学生是否相同
			// if (oldPreviewStudent ==
			// previewStudent&&!assignedState.isEmpty())
			// continue;

			if (assignedState.isEmpty()) {
				previewThesis.setAssigned("Y");
				previewStudent.setThesis(previewThesis);
				previewStudent.setAssign("Y");
				previewStudent.setAutoassign("Auto");
			}

			// oldPreviewStudent = previewStudent;
		}
		return true;
	}

	protected boolean secondAssign() {
		@SuppressWarnings("unchecked")
		List<Preview> previews = previewDAO.findAll();
		Iterator<Preview> it = previews.iterator();

		Thesis previewThesis = null;
		Student previewStudent = null;
		// Student oldPreviewStudent = null;
		String assignedState = null;
		while (it.hasNext()) {
			Preview preview_ = it.next();
			previewThesis = preview_.getThesis();
			previewStudent = preview_.getStudent();
			assignedState = previewThesis.getAssigned();

			// 判断学生是否相同
			// if (oldPreviewStudent ==
			// previewStudent&&!assignedState.isEmpty())
			// continue;

			if (assignedState.isEmpty()) {
				previewThesis.setAssigned("Y");
				previewStudent.setThesis(previewThesis);
				previewStudent.setAssign("Y");
				previewStudent.setAutoassign("Auto");
			}

			// oldPreviewStudent = previewStudent;
		}
		return true;
	}

	protected boolean thridAssign() {
		@SuppressWarnings("unchecked")
		List<Preview> previews = previewDAO.findAll();
		Iterator<Preview> it = previews.iterator();

		Thesis previewThesis = null;
		Student previewStudent = null;
		// Student oldPreviewStudent = null;
		String assignedState = null;
		while (it.hasNext()) {
			Preview preview_ = it.next();
			previewThesis = preview_.getThesis();
			previewStudent = preview_.getStudent();
			assignedState = previewThesis.getAssigned();

			// 判断学生是否相同
			// if (oldPreviewStudent ==
			// previewStudent&&!assignedState.isEmpty())
			// continue;

			if (assignedState.isEmpty()) {
				previewThesis.setAssigned("Y");
				previewStudent.setThesis(previewThesis);
				previewStudent.setAssign("Y");
				previewStudent.setAutoassign("Auto");
			}

			// oldPreviewStudent = previewStudent;
		}
		return true;
	}

	public void setPreviewDAO(PreviewDAO previewDAO) {
		this.previewDAO = previewDAO;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
