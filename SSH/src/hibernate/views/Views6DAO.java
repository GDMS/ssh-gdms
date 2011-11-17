package hibernate.views;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Views6 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.views.Views6
 * @author MyEclipse Persistence Tools
 */

public class Views6DAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(Views6DAO.class);
	// property constants
	public static final String SNAME = "sname";
	public static final String GENDER = "gender";
	public static final String MAJOR = "major";
	public static final String CLASS_ = "class_";
	public static final String CREDIT = "credit";
	public static final String PRETUTOR = "pretutor";
	public static final String SUBNAME = "subname";
	public static final String TUTOR = "tutor";

	protected void initDao() {
		// do nothing
	}

	public void save(Views6 transientInstance) {
		log.debug("saving Views6 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Views6 persistentInstance) {
		log.debug("deleting Views6 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Views6 findById(hibernate.views.Views6Id id) {
		log.debug("getting Views6 instance with id: " + id);
		try {
			Views6 instance = (Views6) getHibernateTemplate().get(
					"hibernate.views.Views6", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Views6 instance) {
		log.debug("finding Views6 instance by example");
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
		log.debug("finding Views6 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Views6 as model where model."
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

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}

	public List findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByPretutor(Object pretutor) {
		return findByProperty(PRETUTOR, pretutor);
	}

	public List findBySubname(Object subname) {
		return findByProperty(SUBNAME, subname);
	}

	public List findByTutor(Object tutor) {
		return findByProperty(TUTOR, tutor);
	}

	public List findAll() {
		log.debug("finding all Views6 instances");
		try {
			String queryString = "from Views6";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Views6 merge(Views6 detachedInstance) {
		log.debug("merging Views6 instance");
		try {
			Views6 result = (Views6) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Views6 instance) {
		log.debug("attaching dirty Views6 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Views6 instance) {
		log.debug("attaching clean Views6 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Views6DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Views6DAO) ctx.getBean("Views6DAO");
	}
}