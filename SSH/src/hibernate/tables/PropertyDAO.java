package hibernate.tables;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Property entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.tables.Property
 * @author MyEclipse Persistence Tools
 */

public class PropertyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PropertyDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String KEY_ID = "keyId";
	public static final String VALUE_B = "valueB";
	public static final String VALUE = "value";

	protected void initDao() {
		// do nothing
	}

	public void save(Property transientInstance) {
		log.debug("saving Property instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Property persistentInstance) {
		log.debug("deleting Property instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Property findById(java.lang.Integer id) {
		log.debug("getting Property instance with id: " + id);
		try {
			Property instance = (Property) getHibernateTemplate().get(
					"hibernate.tables.Property", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Property instance) {
		log.debug("finding Property instance by example");
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
		log.debug("finding Property instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Property as model where model."
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

	public List findByKeyId(Object keyId) {
		return findByProperty(KEY_ID, keyId);
	}

	public List findByValueB(Object valueB) {
		return findByProperty(VALUE_B, valueB);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all Property instances");
		try {
			String queryString = "from Property";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Property merge(Property detachedInstance) {
		log.debug("merging Property instance");
		try {
			Property result = (Property) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Property instance) {
		log.debug("attaching dirty Property instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Property instance) {
		log.debug("attaching clean Property instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PropertyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PropertyDAO) ctx.getBean("PropertyDAO");
	}

	@SuppressWarnings("unchecked")
	public Property findByKey(String key) {
		List<Property> l = findByProperty(KEY_ID, key);
		if (l.size() == 1)
			return (Property) l.get(0);
		else {
			log.warn("Property表出现多个相同Key：" + key);
			return null;
		}
	}
}