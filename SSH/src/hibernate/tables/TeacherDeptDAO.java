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
 * TeacherDept entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.tables.TeacherDept
 * @author MyEclipse Persistence Tools
 */

public class TeacherDeptDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherDeptDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(TeacherDept transientInstance) {
		log.debug("saving TeacherDept instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherDept persistentInstance) {
		log.debug("deleting TeacherDept instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherDept findById(java.lang.Integer id) {
		log.debug("getting TeacherDept instance with id: " + id);
		try {
			TeacherDept instance = (TeacherDept) getHibernateTemplate().get(
					"hibernate.tables.TeacherDept", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeacherDept instance) {
		log.debug("finding TeacherDept instance by example");
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
		log.debug("finding TeacherDept instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TeacherDept as model where model."
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
		log.debug("finding all TeacherDept instances");
		try {
			String queryString = "from TeacherDept";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeacherDept merge(TeacherDept detachedInstance) {
		log.debug("merging TeacherDept instance");
		try {
			TeacherDept result = (TeacherDept) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherDept instance) {
		log.debug("attaching dirty TeacherDept instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherDept instance) {
		log.debug("attaching clean TeacherDept instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherDeptDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherDeptDAO) ctx.getBean("TeacherDeptDAO");
	}
}