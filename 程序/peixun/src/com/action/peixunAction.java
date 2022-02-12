//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKechengDAO;
import com.dao.TPeixunDAO;
import com.model.TKecheng;
import com.model.TPeixun;
import com.opensymphony.xwork2.ActionSupport;

public class peixunAction extends ActionSupport
{
	private int peixunId;
	private String peixunShijian;
	private String peixunDidian;
	private String peixunNeirong;
	private String peixunLaoshi;
	
	private int kechengId;
	
	private String message;
	private String path;
	
	private TPeixunDAO peixunDAO;
	private TKechengDAO kechengDAO;
	
	public String peixunAdd()
	{
		TPeixun peixun=new TPeixun();
		peixun.setKechengId(kechengId);
		peixun.setPeixunShijian(peixunShijian);
		peixun.setPeixunDidian(peixunDidian);
		peixun.setPeixunNeirong(peixunNeirong);
		peixun.setPeixunLaoshi(peixunLaoshi);
		peixun.setDel("no");
		peixunDAO.save(peixun);
		this.setMessage("�����ɹ�");
		this.setPath("peixunMana.action");
		return "succeed";
	}
	
	public String peixunDel()
	{
		TPeixun peixun=peixunDAO.findById(peixunId);
		peixun.setDel("yes");
		peixunDAO.attachDirty(peixun);
		this.setMessage("�����ɹ�");
		this.setPath("peixunMana.action");
		return "succeed";
	}
	
	
	public String peixunMana()
	{
		String sql="from TPeixun where del='no' order by peixunId desc";
		List peixunList=peixunDAO.getHibernateTemplate().find(sql);
		
		for(int i=0;i<peixunList.size();i++)
		{
			TPeixun peixun=(TPeixun)peixunList.get(i);
			peixun.setKechengName(kechengDAO.findById(peixun.getKechengId()).getKechengName());
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunList", peixunList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String peixunAll()
	{
		String sql="from TPeixun where del='no' order by peixunId desc";
		List peixunList=peixunDAO.getHibernateTemplate().find(sql);
		
		for(int i=0;i<peixunList.size();i++)
		{
			TPeixun peixun=(TPeixun)peixunList.get(i);
			peixun.setKechengName(kechengDAO.findById(peixun.getKechengId()).getKechengName());
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunList", peixunList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String peixunEditPre()
	{
		TPeixun peixun=peixunDAO.findById(peixunId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixun", peixun);
		return ActionSupport.SUCCESS;
	}
	
	public String peixunEdit()
	{
		TPeixun peixun=peixunDAO.findById(peixunId);
		peixun.setKechengId(kechengId);
		peixun.setPeixunShijian(peixunShijian);
		peixun.setPeixunDidian(peixunDidian);
		peixun.setPeixunNeirong(peixunNeirong);
		peixun.setPeixunLaoshi(peixunLaoshi);
		peixun.setDel("no");
		peixunDAO.attachDirty(peixun);
		this.setMessage("�����ɹ�");
		this.setPath("peixunMana.action");
		return "succeed";
	}
	
	
	public String peixunSearch()
	{
		String sql="from TPeixun where del='no' and peixunNeirong like '%"+peixunNeirong.trim()+"%'";
		List peixunList=peixunDAO.getHibernateTemplate().find(sql);
		
		for(int i=0;i<peixunList.size();i++)
		{
			TPeixun peixun=(TPeixun)peixunList.get(i);
			peixun.setKechengName(kechengDAO.findById(peixun.getKechengId()).getKechengName());
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunList", peixunList);
		return ActionSupport.SUCCESS;
	}

	public int getKechengId()
	{
		return kechengId;
	}

	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}



	public String getPeixunLaoshi()
	{
		return peixunLaoshi;
	}


	public void setPeixunLaoshi(String peixunLaoshi)
	{
		this.peixunLaoshi = peixunLaoshi;
	}


	public void setPath(String path)
	{
		this.path = path;
	}

	public TPeixunDAO getPeixunDAO()
	{
		return peixunDAO;
	}
	

	public TKechengDAO getKechengDAO()
	{
		return kechengDAO;
	}

	public void setKechengDAO(TKechengDAO kechengDAO)
	{
		this.kechengDAO = kechengDAO;
	}

	public void setPeixunDAO(TPeixunDAO peixunDAO)
	{
		this.peixunDAO = peixunDAO;
	}

	public String getPeixunDidian()
	{
		return peixunDidian;
	}

	public void setPeixunDidian(String peixunDidian)
	{
		this.peixunDidian = peixunDidian;
	}

	public int getPeixunId()
	{
		return peixunId;
	}

	public void setPeixunId(int peixunId)
	{
		this.peixunId = peixunId;
	}

	public String getPeixunNeirong()
	{
		return peixunNeirong;
	}

	public void setPeixunNeirong(String peixunNeirong)
	{
		this.peixunNeirong = peixunNeirong;
	}

	public String getPeixunShijian()
	{
		return peixunShijian;
	}

	public void setPeixunShijian(String peixunShijian)
	{
		this.peixunShijian = peixunShijian;
	}

}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
