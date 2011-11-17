package hibernate.tables;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Preview entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.tables.Preview
 * @author MyEclipse Persistence Tools
 */

public class PreviewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PreviewDAO.class);
	// property constants
	public static final String SUBORDER = "suborder";

	protected void initDao() {
		// do nothing
	}

	public void save(Preview transientInstance) {
		log.debug("saving Preview instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Preview persistentInstance) {
		log.debug("deleting Preview instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Preview findById(java.lang.Integer id) {
		log.debug("getting Preview instance with id: " + id);
		try {
			Preview instance = (Preview) getHibernateTemplate().get(
					"hibernate.tables.Preview", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Preview instance) {
		log.debug("finding Preview instance by example");
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
		log.debug("finding Preview instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Preview as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySuborder(Object suborder) {
		return findByProperty(SUBORDER, suborder);
	}

	public List findAll() {
		log.debug("finding all Preview instances");
		try {
			String queryString = "from Preview";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAllOrderByStudentAndSuborder() {
		log.debug("finding all Preview instances");
		try {
			String queryString = "from Preview order by student,suborder asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Preview merge(Preview detachedInstance) {
		log.debug("merging Preview instance");
		try {
			Preview result = (Preview) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Preview instance) {
		log.debug("attaching dirty Preview instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Preview instance) {
		log.debug("attaching clean Preview instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PreviewDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PreviewDAO) ctx.getBean("PreviewDAO");
	}
}