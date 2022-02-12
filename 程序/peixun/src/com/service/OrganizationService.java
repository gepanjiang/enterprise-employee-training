//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.service;

import java.util.List;

import com.dao.TOrganizationDAO;
import com.model.TOrganization;



public class OrganizationService
{
	private TOrganizationDAO organizationDAO;

	public TOrganizationDAO getOrganizationDAO()
	{
		return organizationDAO;
	}

	public void setOrganizationDAO(TOrganizationDAO organizationDAO)
	{
		this.organizationDAO = organizationDAO;
	}
	
	
	public void save(TOrganization transientInstance)
	{
		organizationDAO.save(transientInstance);
	}

	public String delete(Integer depId)
	{
		//organizationDAO.delete(transientInstance);
		TOrganization organization=organizationDAO.findById(depId);
		System.out.println(organization.getOrgName());
		System.out.println(organization.getChildOrganization());
		if(organization.getChildOrganization().size()>0)
		{
			return "haveChildOrganization";
		}
		
		String hql="delete from TOrganization o where o.orgId=?";
		organizationDAO.getHibernateTemplate().bulkUpdate(hql,depId);
		return "successDel";
	}
	
	public List findAll()
	{
		return organizationDAO.findAll();
	}
	
	public TOrganization findById(java.lang.Integer id)
	{
		return organizationDAO.findById(id);
	}

}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
