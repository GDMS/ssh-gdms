package hibernate.tables;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Thesis entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.tables.Thesis
 * @author MyEclipse Persistence Tools
 */

public class ThesisDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ThesisDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String PROPERTY = "property";
	public static final String MODE = "mode";
	public static final String ASSIGNED = "assigned";

	protected void initDao() {
		// do nothing
	}

	public void save(Thesis transientInstance) {
		log.debug("saving Thesis instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Thesis persistentInstance) {
		log.debug("deleting Thesis instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Thesis findById(java.lang.Integer id) {
		log.debug("getting Thesis instance with id: " + id);
		try {
			Thesis instance = (Thesis) getHibernateTemplate().get(
					"hibernate.tables.Thesis", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Thesis instance) {
		log.debug("finding Thesis instance by example");
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
		log.debug("finding Thesis instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Thesis as model where model."
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

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByProperty(Object property) {
		return findByProperty(PROPERTY, property);
	}

	public List findByMode(Object mode) {
		return findByProperty(MODE, mode);
	}

	public List findByAssigned(Object assigned) {
		return findByProperty(ASSIGNED, assigned);
	}

	public List findAll() {
		log.debug("finding all Thesis instances");
		try {
			String queryString = "from Thesis";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAllNotAssigned() {
		log.debug("finding all Thesis instances Not Assigned");
		try {
			String queryString = "from Thesis where assigned is null";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Thesis merge(Thesis detachedInstance) {
		log.debug("merging Thesis instance");
		try {
			Thesis result = (Thesis) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Thesis instance) {
		log.debug("attaching dirty Thesis instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Thesis instance) {
		log.debug("attaching clean Thesis instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ThesisDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ThesisDAO) ctx.getBean("ThesisDAO");
	}
}