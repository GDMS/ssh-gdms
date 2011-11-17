package root;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

import hibernate.tables.Lw;
import hibernate.tables.LwDAO;
import hibernate.tables.News;
import hibernate.tables.NewsDAO;

/**
 * 首页数据库信息显示
 * 
 * @author LICH
 * 
 */
@Transactional(readOnly = false)
public class IndexAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4300675680324875490L;

	@Autowired
	private NewsDAO newsDao;
	@Autowired
	private LwDAO lwDAO;

	private String message;
	private List<Lw> lw;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		News news = newsDao.findById(1);
		message = news.getMsgToAll();
		lw = lwDAO.findAll();

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Lw> getLw() {
		return lw;
	}

	public void setLw(List<Lw> lw) {
		this.lw = lw;
	}

	public void setNewsDao(NewsDAO newsDao) {
		this.newsDao = newsDao;
	}

	public void setLwDAO(LwDAO lwDAO) {
		this.lwDAO = lwDAO;
	}

}
