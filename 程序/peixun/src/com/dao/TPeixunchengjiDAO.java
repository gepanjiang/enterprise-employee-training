//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPeixunchengji;

/**
 * Data access object (DAO) for domain model class TPeixunchengji.
 * 
 * @see com.model.TPeixunchengji
 * @author MyEclipse Persistence Tools
 */

public class TPeixunchengjiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPeixunchengjiDAO.class);

	// property constants
	public static final String PEIXUN_ID = "peixunId";

	public static final String YUANGONG_ID = "yuangongId";

	public static final String CHENGJI = "chengji";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPeixunchengji transientInstance)
	{
		log.debug("saving TPeixunchengji instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPeixunchengji persistentInstance)
	{
		log.debug("deleting TPeixunchengji instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPeixunchengji findById(java.lang.Integer id)
	{
		log.debug("getting TPeixunchengji instance with id: " + id);
		try
		{
			TPeixunchengji instance = (TPeixunchengji) getHibernateTemplate()
					.get("com.model.TPeixunchengji", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPeixunchengji instance)
	{
		log.debug("finding TPeixunchengji instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TPeixunchengji instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TPeixunchengji as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPeixunId(Object peixunId)
	{
		return findByProperty(PEIXUN_ID, peixunId);
	}

	public List findByYuangongId(Object yuangongId)
	{
		return findByProperty(YUANGONG_ID, yuangongId);
	}

	public List findByChengji(Object chengji)
	{
		return findByProperty(CHENGJI, chengji);
	}

	public List findAll()
	{
		log.debug("finding all TPeixunchengji instances");
		try
		{
			String queryString = "from TPeixunchengji";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPeixunchengji merge(TPeixunchengji detachedInstance)
	{
		log.debug("merging TPeixunchengji instance");
		try
		{
			TPeixunchengji result = (TPeixunchengji) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPeixunchengji instance)
	{
		log.debug("attaching dirty TPeixunchengji instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPeixunchengji instance)
	{
		log.debug("attaching clean TPeixunchengji instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TPeixunchengjiDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TPeixunchengjiDAO) ctx.getBean("TPeixunchengjiDAO");
	}
}//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
