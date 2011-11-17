package hibernate.tables;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentScore entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.tables.StudentScore
 * @author MyEclipse Persistence Tools
 */

public class StudentScoreDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(StudentScoreDAO.class);
	// property constants
	public static final String PROGRESS = "progress";
	public static final String QUALITY = "quality";
	public static final String ATTITUDE = "attitude";
	public static final String DUTY = "duty";
	public static final String REMARK = "remark";
	public static final String WARN = "warn";
	public static final String GRADE = "grade";
	public static final String QUESTION1 = "question1";
	public static final String ANSWER1 = "answer1";
	public static final String QUESTION2 = "question2";
	public static final String ANSWER2 = "answer2";
	public static final String QUESTION3 = "question3";
	public static final String ANSWER3 = "answer3";
	public static final String PROJ_DESC = "projDesc";
	public static final String THES_DESC = "thesDesc";
	public static final String ZD1GRADE = "zd1grade";
	public static final String ZD2GRADE = "zd2grade";
	public static final String ZD3GRADE = "zd3grade";
	public static final String ZD4GRADE = "zd4grade";
	public static final String PY1GRADE = "py1grade";
	public static final String PY2GRADE = "py2grade";
	public static final String DB1GRADE = "db1grade";
	public static final String DB2GRADE = "db2grade";
	public static final String ZDPINGYU = "zdpingyu";
	public static final String PYPINGYU = "pypingyu";
	public static final String DBPINGYU = "dbpingyu";

	protected void initDao() {
		// do nothing
	}

	public void save(StudentScore transientInstance) {
		log.debug("saving StudentScore instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentScore persistentInstance) {
		log.debug("deleting StudentScore instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentScore findById(java.lang.String id) {
		log.debug("getting StudentScore instance with id: " + id);
		try {
			StudentScore instance = (StudentScore) getHibernateTemplate().get(
					"hibernate.tables.StudentScore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentScore instance) {
		log.debug("finding StudentScore instance by example");
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
		log.debug("finding StudentScore instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentScore as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProgress(Object progress) {
		return findByProperty(PROGRESS, progress);
	}

	public List findByQuality(Object quality) {
		return findByProperty(QUALITY, quality);
	}

	public List findByAttitude(Object attitude) {
		return findByProperty(ATTITUDE, attitude);
	}

	public List findByDuty(Object duty) {
		return findByProperty(DUTY, duty);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByWarn(Object warn) {
		return findByProperty(WARN, warn);
	}

	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List findByQuestion1(Object question1) {
		return findByProperty(QUESTION1, question1);
	}

	public List findByAnswer1(Object answer1) {
		return findByProperty(ANSWER1, answer1);
	}

	public List findByQuestion2(Object question2) {
		return findByProperty(QUESTION2, question2);
	}

	public List findByAnswer2(Object answer2) {
		return findByProperty(ANSWER2, answer2);
	}

	public List findByQuestion3(Object question3) {
		return findByProperty(QUESTION3, question3);
	}

	public List findByAnswer3(Object answer3) {
		return findByProperty(ANSWER3, answer3);
	}

	public List findByProjDesc(Object projDesc) {
		return findByProperty(PROJ_DESC, projDesc);
	}

	public List findByThesDesc(Object thesDesc) {
		return findByProperty(THES_DESC, thesDesc);
	}

	public List findByZd1grade(Object zd1grade) {
		return findByProperty(ZD1GRADE, zd1grade);
	}

	public List findByZd2grade(Object zd2grade) {
		return findByProperty(ZD2GRADE, zd2grade);
	}

	public List findByZd3grade(Object zd3grade) {
		return findByProperty(ZD3GRADE, zd3grade);
	}

	public List findByZd4grade(Object zd4grade) {
		return findByProperty(ZD4GRADE, zd4grade);
	}

	public List findByPy1grade(Object py1grade) {
		return findByProperty(PY1GRADE, py1grade);
	}

	public List findByPy2grade(Object py2grade) {
		return findByProperty(PY2GRADE, py2grade);
	}

	public List findByDb1grade(Object db1grade) {
		return findByProperty(DB1GRADE, db1grade);
	}

	public List findByDb2grade(Object db2grade) {
		return findByProperty(DB2GRADE, db2grade);
	}

	public List findByZdpingyu(Object zdpingyu) {
		return findByProperty(ZDPINGYU, zdpingyu);
	}

	public List findByPypingyu(Object pypingyu) {
		return findByProperty(PYPINGYU, pypingyu);
	}

	public List findByDbpingyu(Object dbpingyu) {
		return findByProperty(DBPINGYU, dbpingyu);
	}

	public List findAll() {
		log.debug("finding all StudentScore instances");
		try {
			String queryString = "from StudentScore";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllByGradeDesc() {
		log.debug("finding all StudentScore instances by grade desc");
		try {
			String queryString = "from StudentScore order by grade desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentScore merge(StudentScore detachedInstance) {
		log.debug("merging StudentScore instance");
		try {
			StudentScore result = (StudentScore) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentScore instance) {
		log.debug("attaching dirty StudentScore instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentScore instance) {
		log.debug("attaching clean StudentScore instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentScoreDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (StudentScoreDAO) ctx.getBean("StudentScoreDAO");
	}
}