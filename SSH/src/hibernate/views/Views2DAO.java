package hibernate.views;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Views2 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.views.Views2
 * @author MyEclipse Persistence Tools
 */

public class Views2DAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(Views2DAO.class);
	// property constants
	public static final String SNAME = "sname";
	public static final String CREDIT = "credit";
	public static final String TUTOR = "tutor";
	public static final String EXPR = "expr";
	public static final String SUBNAME = "subname";

	protected void initDao() {
		// do nothing
	}

	public void save(Views2 transientInstance) {
		log.debug("saving Views2 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Views2 persistentInstance) {
		log.debug("deleting Views2 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Views2 findById(hibernate.views.Views2Id id) {
		log.debug("getting Views2 instance with id: " + id);
		try {
			Views2 instance = (Views2) getHibernateTemplate().get(
					"hibernate.views.Views2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Views2 instance) {
		log.debug("finding Views2 instance by example");
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
		log.debug("finding Views2 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Views2 as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByTutor(Object tutor) {
		return findByProperty(TUTOR, tutor);
	}

	public List findByExpr(Object expr) {
		return findByProperty(EXPR, expr);
	}

	public List findBySubname(Object subname) {
		return findByProperty(SUBNAME, subname);
	}

	public List findAll() {
		log.debug("finding all Views2 instances");
		try {
			String queryString = "from Views2";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Views2 merge(Views2 detachedInstance) {
		log.debug("merging Views2 instance");
		try {
			Views2 result = (Views2) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Views2 instance) {
		log.debug("attaching dirty Views2 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Views2 instance) {
		log.debug("attaching clean Views2 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Views2DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Views2DAO) ctx.getBean("Views2DAO");
	}
}