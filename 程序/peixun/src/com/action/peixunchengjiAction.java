//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TPeixunchengjiDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TPeixunchengji;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class peixunchengjiAction extends ActionSupport
{
	private int id;
	private int peixunId;
	private int yuangongId;
	private int chengji;
	 
	private String message;
	private String path;
	
    private TPeixunchengjiDAO peixunchengjiDAO;	
    private TYuangongDAO yuangongDAO;
	
	public String peixunchengjiAdd()
	{
		TPeixunchengji peixunchengji=new TPeixunchengji();
		peixunchengji.setYuangongId(yuangongId);
		peixunchengji.setPeixunId(peixunId);
		peixunchengji.setChengji(chengji);
		peixunchengjiDAO.save(peixunchengji);
		//this.setMessage("�����ɹ�");
		//this.setPath("peixunchengjiMana.action?peixunId="+peixunId);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String peixunchengjiMana()
	{
		List peixunchengjiList=peixunchengjiDAO.getHibernateTemplate().find("from TPeixunchengji where peixunId="+peixunId);
		for(int i=0;i<peixunchengjiList.size();i++)
		{
			TPeixunchengji peixunchengji=(TPeixunchengji)peixunchengjiList.get(i);
			peixunchengji.setYuangongName(yuangongDAO.findById(peixunchengji.getYuangongId()).getYuangongName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunchengjiList", peixunchengjiList);
		request.put("peixunId", peixunId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String peixunchengjiDel()
	{
		TPeixunchengji peixunchengji=peixunchengjiDAO.findById(id);
		peixunchengjiDAO.delete(peixunchengji);
		//this.setMessage("ɾ���ɹ�");
		//this.setPath("peixunchengjiMana.action?peixunId="+peixunchengji.getPeixunId());
		return ActionSupport.SUCCESS;
	}



	public int getChengji()
	{
		return chengji;
	}



	public void setChengji(int chengji)
	{
		this.chengji = chengji;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
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



	public TPeixunchengjiDAO getPeixunchengjiDAO()
	{
		return peixunchengjiDAO;
	}



	public void setPeixunchengjiDAO(TPeixunchengjiDAO peixunchengjiDAO)
	{
		this.peixunchengjiDAO = peixunchengjiDAO;
	}



	public int getPeixunId()
	{
		return peixunId;
	}



	public void setPeixunId(int peixunId)
	{
		this.peixunId = peixunId;
	}



	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}



	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}



	public int getYuangongId()
	{
		return yuangongId;
	}



	public void setYuangongId(int yuangongId)
	{
		this.yuangongId = yuangongId;
	}
	
}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
