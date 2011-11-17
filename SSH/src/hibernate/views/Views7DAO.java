package hibernate.views;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Views7 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.views.Views7
 * @author MyEclipse Persistence Tools
 */

public class Views7DAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(Views7DAO.class);
	// property constants

	public static final String SNAME = "sname";
	public static final String GENDER = "gender";
	public static final String MAJOR = "major";
	public static final String CLASS = "class_";
	public static final String TUTOR = "tutor";
	public static final String SUBNAME = "subname";
	public static final String GRADE = "grade";
	public static final String CREDIT = "credit";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";

	protected void initDao() {
		// do nothing
	}

	public void save(Views7 transientInstance) {
		log.debug("saving Views7 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Views7 persistentInstance) {
		log.debug("deleting Views7 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Views7 findById(hibernate.views.Views7 id) {
		log.debug("getting Views7 instance with id: " + id);
		try {
			Views7 instance = (Views7) getHibernateTemplate().get(
					"hibernate.views.Views7", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Views7 instance) {
		log.debug("finding Views7 instance by example");
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
		log.debug("finding Views7 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Views7 as model where model."
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
	
	public List findByClass(Object class_) {
		return findByProperty(CLASS, class_);
	}
	
	public List findByTutor(Object tutor) {
		return findByProperty(TUTOR, tutor);
	}

	public List findBySubname(Object subname) {
		return findByProperty(SUBNAME, subname);
	}
	
	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}	
	
	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}
	
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}
	
	public List findAll() {
		log.debug("finding all Views7 instances");
		try {
			String queryString = "from Views7";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Views7 merge(Views7 detachedInstance) {
		log.debug("merging Views7 instance");
		try {
			Views7 result = (Views7) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Views7 instance) {
		log.debug("attaching dirty Views7 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Views7 instance) {
		log.debug("attaching clean Views7 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Views7DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Views7DAO) ctx.getBean("Views7DAO");
	}
}