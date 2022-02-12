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
import com.model.TAdmin;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class adminAction extends ActionSupport
{
	private int userId;
	private String userName;
	private String userPw;
	 
	private String message;
	private String path;
	
	private int index=1;

	private TAdminDAO adminDAO;
	
	
	public String adminAdd()
	{
		TAdmin admin=new TAdmin();
		admin.setUserName(userName);
		admin.setUserPw(userPw);
		adminDAO.save(admin);
		this.setMessage("�����ɹ�");
		this.setPath("adminManage.action");
		return "succeed";
	}
	
	
	
	public String adminManage()
	{
		List adminList=adminDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("adminList", adminList);
		return ActionSupport.SUCCESS;
	}
	
	public String adminManageFenye()
	{
		List adminList=adminDAO.findAll();
		int pageSize=3;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, adminList.size());
		List adminListFenye = adminList.subList(fromIndex, toIndex);
		

        Pagination p = new Pagination();//���� ��ҳ����
        p.setIndex(index);//����ҳ��
        p.setPageSize(pageSize);
        p.setTotle(adminList.size());//�����ܹ�������
        p.setData(adminListFenye);//��������
        p.setPath("adminManageFenye.action?");//��ת��·��

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String adminDel()
	{
		adminDAO.delete(adminDAO.findById(userId));
		this.setMessage("ɾ���ɹ�");
		this.setPath("adminManage.action");
		return "succeed";
	}
	
	

	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public int getIndex()
	{
		return index;
	}



	public void setIndex(int index)
	{
		this.index = index;
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

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	 
}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:1811--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
