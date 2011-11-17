package hibernate.views;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Views4 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.views.Views4
 * @author MyEclipse Persistence Tools
 */

public class Views4DAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(Views4DAO.class);

	// property constants
	public static final String TUTOR = "tutor";
	public static final String PLANNUM = "plannum";
	public static final String SUBNUM = "subnum";
	public static final String ACTUALNUM = "actualnum";
	public static final String DIF = "dif";
	
	protected void initDao() {
		// do nothing
	}

	public void save(Views4 transientInstance) {
		log.debug("saving Views4 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Views4 persistentInstance) {
		log.debug("deleting Views4 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Views4 findById(hibernate.views.Views4 id) {
		log.debug("getting Views4 instance with id: " + id);
		try {
			Views4 instance = (Views4) getHibernateTemplate().get(
					"hibernate.views.Views4", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Views4 instance) {
		log.debug("finding Views4 instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Views4 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Views4 as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByTutor(Object tutor) {
		return findByProperty(TUTOR, tutor);
	}
	
	public List findByPlannum(Object plannum) {
		return findByProperty(PLANNUM, plannum);
	}
	
	public List findBySubnum(Object subnum) {
		return findByProperty(SUBNUM, subnum);
	}
	
	public List findByActualnum(Object actualnum) {
		return findByProperty(ACTUALNUM, actualnum);
	}
	
	public List findByDif(Object dif) {
		return findByProperty(DIF, dif);
	}
	
	public List findAll() {
		log.debug("finding all Views4 instances");
		try {
			String queryString = "from Views4";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Views4 merge(Views4 detachedInstance) {
		log.debug("merging Views4 instance");
		try {
			Views4 result = (Views4) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Views4 instance) {
		log.debug("attaching dirty Views4 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Views4 instance) {
		log.debug("attaching clean Views4 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Views4DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Views4DAO) ctx.getBean("Views4DAO");
	}
}