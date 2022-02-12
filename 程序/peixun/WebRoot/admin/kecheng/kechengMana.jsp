<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function kechengDel(kechengId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/kechengDel.action?kechengId="+kechengId;
               }
           }
           
           function kechengEditPre(kechengId)
           {
                   window.location.href="<%=path %>/kechengEditPre.action?kechengId="+kechengId;
           }
           
           function kechengAdd()
           {
                 var url="<%=path %>/admin/kecheng/kechengAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <form action="<%=path %>/kechengSearch.action" name="f" method="post">
			          课程名称:<input type="text" name="kechengName" size="20"/>
			          <input type="submit" value="查询"/>
			      </form>
			    </td>
			  </tr>
		    </table>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/images/tbg.gif">&nbsp;培训课程&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="20%">课程名称</td>
					<td width="30%">课程描述</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.kechengList" id="kecheng" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#kecheng.kechengName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#kecheng.kechengMiaoshu" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="kechengDel(<s:property value="#kecheng.kechengId"/>)" class="pn-loperator">删除</a>
					    <a href="#" onclick="kechengEditPre(<s:property value="#kecheng.kechengId"/>)" class="pn-loperator">编辑</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kechengAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
