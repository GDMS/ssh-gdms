package root.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hibernate.tables.Student;
import hibernate.tables.StudentDAO;
import hibernate.tables.Thesis;
import hibernate.tables.ThesisDAO;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Transactional(readOnly = true)
public class SubInfoManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4899342407279031907L;
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SubInfoManageAction.class);
	@Autowired
	private List<Thesis> thesises;
	private int page;
	private int totalPage;

	@Autowired
	private ThesisDAO thesisDAO;

	private Thesis thesis;

	private int thesisno;

	private List<Integer> num;

	/**
	 * 通过自定义SecurityInterceptor拦截器获取
	 */
	private String sessionId;

	@Transactional(readOnly = true)
	public String query() {
		thesises = thesisDAO.findAll();
		if (page == 0)
			page = 1;
		totalPage = thesises.size() / 10 + 1;
		// 每页显示10条
		int listStart = (page - 1) * 10;
		int listEnd = page * 10;// which is exclusive
		if (listEnd >= thesises.size())
			listEnd = thesises.size();
		thesises = thesises.subList(listStart, listEnd);

		Iterator<Thesis> it = thesises.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
		return "querysuccess";
	}

	@Transactional(readOnly = false)
	@Override
	public String execute() throws Exception {
		thesis = thesisDAO.findById(thesisno);
		if (thesis.getStudent() != null) {
			thesis.getStudent().setAssign(null);
			thesis.getStudent().setAutoassign(null);
		}
		log.info("删除课题："+ReflectionToStringBuilder.toString(thesis));
		thesisDAO.delete(thesis);
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String delete() {
		thesis = thesisDAO.findById(thesisno);
		return "deletequery";
	}

	public String Excel() {
		thesises = thesisDAO.findAll();
		Iterator<Thesis> it = thesises.iterator();
		num = new ArrayList<Integer>();
		while (it.hasNext()) {
			Thesis thesis_ = it.next();
			num.add(thesis_.getPreviews().size());
		}
		return "excel";
	}

	public List<Integer> getNum() {
		return num;
	}

	public void setNum(List<Integer> num) {
		this.num = num;
	}

	public List<Thesis> getThesises() {
		return thesises;
	}

	public void setThesises(List<Thesis> thesises) {
		this.thesises = thesises;
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

	public ThesisDAO getThesisDAO() {
		return thesisDAO;
	}

	public void setThesisDAO(ThesisDAO thesisDAO) {
		this.thesisDAO = thesisDAO;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public int getThesisno() {
		return thesisno;
	}

	public void setThesisno(int thesisno) {
		this.thesisno = thesisno;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
