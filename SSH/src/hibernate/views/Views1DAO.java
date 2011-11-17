package hibernate.views;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Views1 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.views.Views1
 * @author MyEclipse Persistence Tools
 */

public class Views1DAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(Views1DAO.class);

	// property constants
	public static final String SNAME = "sname";
	public static final String GENDER = "gender";
	public static final String CREDIT = "credit";
	public static final String TUTOR = "tutor";
	public static final String MAJOR = "major";
	public static final String CLASS = "class_";
	public static final String ASSIGN = "assign";
	public static final String AUTOASSIGN = "autoassign";
	
	protected void initDao() {
		// do nothing
	}

	public void save(Views1 transientInstance) {
		log.debug("saving Views1 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Views1 persistentInstance) {
		log.debug("deleting Views1 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Views1 findById(java.lang.String id) {
		log.debug("getting Views1 instance with id: " + id);
		try {
			Views1 instance = (Views1) getHibernateTemplate().get(
					"hibernate.views.Views1", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Views1 instance) {
		log.debug("finding Views1 instance by example");
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
		log.debug("finding Views1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Views1 as model where model."
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
	
	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}
	
	public List findByTutor(Object tutor) {
		return findByProperty(TUTOR, tutor);
	}
	
	public List findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}
	
	public List findByClass(Object class_) {
		return findByProperty(CLASS, class_);
	}
	
	public List findByAssign(Object assign) {
		return findByProperty(ASSIGN, assign);
	}
	
	public List findByAutoassign(Object autoassign) {
		return findByProperty(AUTOASSIGN, autoassign);
	}
	
	public List findAll() {
		log.debug("finding all Views1 instances");
		try {
			String queryString = "from Views1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Views1 merge(Views1 detachedInstance) {
		log.debug("merging Views1 instance");
		try {
			Views1 result = (Views1) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Views1 instance) {
		log.debug("attaching dirty Views1 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Views1 instance) {
		log.debug("attaching clean Views1 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Views1DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Views1DAO) ctx.getBean("Views1DAO");
	}
}