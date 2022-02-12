//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


import com.dao.TYuangongDAO;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrganizationService;

public class yuangongAction extends ActionSupport
{
	private int yuangongId;
	private String yuangongOne2;
	private String yuangongOne3;
	private String yuangongName;
	private String yuangongSex;
	private int yuangongAge;
	private String yuangongXueli;
	private String yuangongZhiwei;
	private String yuangongAddress;
	private String yuangongTel;
	private String yuangongEmail;
	private int yuangongOrgId;
	
	private TYuangongDAO yuangongDAO;
	private OrganizationService organizationService;
	private String message;
	private String path;
	
	
    private String filename;
    
    private String yuangongAgeSta;
    private String yuangongAgeEnd;
	
	public String yuangongAdd()
	{
		TYuangong yuangong=new TYuangong();
		yuangong.setYuangongOne2(yuangongOne2);
		yuangong.setYuangongOne3(yuangongOne3);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongOrgName(organizationService.findById(yuangongOrgId).getOrgName());
		yuangong.setYuangongOne1("yuangong");
		yuangongDAO.save(yuangong);
		this.setMessage("�����ɹ�");
		this.setPath("yuangongMana.action");
		return "succeed";
	}
	
	
	public String yuangongMana()
	{
		String sql="from TYuangong where yuangongOne1='yuangong'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String yuangongSearch()
	{
		StringBuffer sql=new StringBuffer("from TYuangong where yuangongOne1='yuangong' and yuangongName like '%"+yuangongName.trim()+"%'"+" and yuangongXueli like '%"+yuangongXueli.trim()+"%'");
		if(yuangongAgeSta!=null && !yuangongAgeSta.equals(""))
		{
			sql.append(" and yuangongAge>'"+yuangongAgeSta+"'");
		}
		if(yuangongAgeEnd!=null && !yuangongAgeEnd.equals(""))
		{
			sql.append(" and yuangongAge<'"+yuangongAgeEnd+"'");
		}
		
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	public String yuangongAll()
	{
		String sql="from TYuangong where yuangongOne1='yuangong'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yuangongDel()
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		yuangongDAO.delete(yuangong);
		this.setMessage("�����ɹ�");
		this.setPath("yuangongMana.action");
		return "succeed";
	}
	
	
	public String yuangongEditPre()
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangong", yuangong);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yuangongEdit()
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongOrgName(organizationService.findById(yuangongOrgId).getOrgName());
		yuangong.setYuangongOne1("yuangong");
		yuangongDAO.getHibernateTemplate().update(yuangong);
		this.setMessage("�����ɹ�");
		this.setPath("yuangongMana.action");
		return "succeed";
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
	
	public OrganizationService getOrganizationService()
	{
		return organizationService;
	}


	public void setOrganizationService(OrganizationService organizationService)
	{
		this.organizationService = organizationService;
	}


	public String getFilename()
	{
		return filename;
	}


	public void setFilename(String filename)
	{
		this.filename = filename;
	}




	public String getYuangongOne2()
	{
		return yuangongOne2;
	}


	public void setYuangongOne2(String yuangongOne2)
	{
		this.yuangongOne2 = yuangongOne2;
	}


	public String getYuangongOne3()
	{
		return yuangongOne3;
	}


	public String getYuangongAgeEnd()
	{
		return yuangongAgeEnd;
	}


	public void setYuangongAgeEnd(String yuangongAgeEnd)
	{
		this.yuangongAgeEnd = yuangongAgeEnd;
	}


	public String getYuangongAgeSta()
	{
		return yuangongAgeSta;
	}


	public void setYuangongAgeSta(String yuangongAgeSta)
	{
		this.yuangongAgeSta = yuangongAgeSta;
	}


	public void setYuangongOne3(String yuangongOne3)
	{
		this.yuangongOne3 = yuangongOne3;
	}



	public void setPath(String path)
	{
		this.path = path;
	}
	public String getYuangongAddress()
	{
		return yuangongAddress;
	}
	public void setYuangongAddress(String yuangongAddress)
	{
		this.yuangongAddress = yuangongAddress;
	}

	public int getYuangongAge()
	{
		return yuangongAge;
	}


	public void setYuangongAge(int yuangongAge)
	{
		this.yuangongAge = yuangongAge;
	}


	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}
	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}
	public String getYuangongEmail()
	{
		return yuangongEmail;
	}
	public void setYuangongEmail(String yuangongEmail)
	{
		this.yuangongEmail = yuangongEmail;
	}
	public int getYuangongId()
	{
		return yuangongId;
	}
	public void setYuangongId(int yuangongId)
	{
		this.yuangongId = yuangongId;
	}
	public String getYuangongName()
	{
		return yuangongName;
	}
	public void setYuangongName(String yuangongName)
	{
		this.yuangongName = yuangongName;
	}
	public int getYuangongOrgId()
	{
		return yuangongOrgId;
	}
	public void setYuangongOrgId(int yuangongOrgId)
	{
		this.yuangongOrgId = yuangongOrgId;
	}
	public String getYuangongSex()
	{
		return yuangongSex;
	}
	public void setYuangongSex(String yuangongSex)
	{
		this.yuangongSex = yuangongSex;
	}
	public String getYuangongTel()
	{
		return yuangongTel;
	}
	public void setYuangongTel(String yuangongTel)
	{
		this.yuangongTel = yuangongTel;
	}
	public String getYuangongXueli()
	{
		return yuangongXueli;
	}
	
	public void setYuangongXueli(String yuangongXueli)
	{
		this.yuangongXueli = yuangongXueli;
	}
	public String getYuangongZhiwei()
	{
		return yuangongZhiwei;
	}
	public void setYuangongZhiwei(String yuangongZhiwei)
	{
		this.yuangongZhiwei = yuangongZhiwei;
	}
	
}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
