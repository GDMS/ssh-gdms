package hibernate.tables;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Major
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate.tables.Major
 * @author MyEclipse Persistence Tools
 */

public class MajorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MajorDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Major transientInstance) {
		log.debug("saving Major instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Major persistentInstance) {
		log.debug("deleting Major instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Major findById(java.lang.Integer id) {
		log.debug("getting Major instance with id: " + id);
		try {
			Major instance = (Major) getHibernateTemplate().get(
					"hibernate.tables.Major", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Major instance) {
		log.debug("finding Major instance by example");
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
		log.debug("finding Major instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Major as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Major instances");
		try {
			String queryString = "from Major";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Major merge(Major detachedInstance) {
		log.debug("merging Major instance");
		try {
			Major result = (Major) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Major instance) {
		log.debug("attaching dirty Major instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Major instance) {
		log.debug("attaching clean Major instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MajorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MajorDAO) ctx.getBean("MajorDAO");
	}
}