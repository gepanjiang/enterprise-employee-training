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
import com.model.TKecheng;
import com.opensymphony.xwork2.ActionSupport;

public class kechengAction extends ActionSupport
{
	private int kechengId;
	private String kechengName;
	private String kechengMiaoshu;
	
	private String message;
	private String path;
	
	private TKechengDAO kechengDAO;
	
	
	public String kechengMana()
	{
		String sql="from TKecheng where del='no'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}
	
	public String kechengAdd()
	{
		TKecheng kecheng=new TKecheng();
		kecheng.setKechengName(kechengName);
		kecheng.setKechengMiaoshu(kechengMiaoshu);
		kecheng.setDel("no");
		kechengDAO.save(kecheng);
		this.setMessage("�����ɹ�");
		this.setPath("kechengMana.action");
		return "succeed";
	}
	
	public String kechengDel()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		kecheng.setDel("yes");
		kechengDAO.attachDirty(kecheng);
		this.setMessage("�����ɹ�");
		this.setPath("kechengMana.action");
		return "succeed";
	}
	
	
	public String kechengEditPre()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kecheng", kecheng);
		return ActionSupport.SUCCESS;
	}
	
	
	public String kechengEdit()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		kecheng.setKechengName(kechengName);
		kecheng.setKechengMiaoshu(kechengMiaoshu);
		kecheng.setDel("no");
		kechengDAO.attachDirty(kecheng);
		this.setMessage("�����ɹ�");
		this.setPath("kechengMana.action");
		return "succeed";
	}
	
	
	public String kechengSearch()
	{
		String sql="from TKecheng where del='no' and kechengName like '%"+kechengName.trim()+"%'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}
	



	public TKechengDAO getKechengDAO()
	{
		return kechengDAO;
	}



	public void setKechengDAO(TKechengDAO kechengDAO)
	{
		this.kechengDAO = kechengDAO;
	}



	public int getKechengId()
	{
		return kechengId;
	}



	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}



	public String getKechengMiaoshu()
	{
		return kechengMiaoshu;
	}



	public void setKechengMiaoshu(String kechengMiaoshu)
	{
		this.kechengMiaoshu = kechengMiaoshu;
	}



	public String getKechengName()
	{
		return kechengName;
	}



	public void setKechengName(String kechengName)
	{
		this.kechengName = kechengName;
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



	public void setPath(String path)
	{
		this.path = path;
	}
	
	



}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
