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
           function peixunDel(peixunId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/peixunDel.action?peixunId="+peixunId;
               }
           }
           
           function peixunEditPre(peixunId)
           {
               window.location.href="<%=path %>/peixunEditPre.action?peixunId="+peixunId;
           }
           
           function peixunAdd()
           {
                 var url="<%=path %>/admin/peixun/peixunAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/images/tbg.gif">&nbsp;培训计划制定&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="16%">培训课程</td>
					<td width="16%">培训时间</td>
					<td width="16%">培训地点</td>
					<td width="16%">培训内容</td>
					<td width="16%">培训老师</td>
					<td width="16%">操作</td>
		        </tr>	
				<s:iterator value="#request.peixunList" id="peixun">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
							<s:property value="#peixun.kechengName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
							<s:property value="#peixun.peixunShijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.peixunDidian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.peixunNeirong" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.peixunLaoshi" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="peixunDel(<s:property value="#peixun.peixunId"/>)" class="pn-loperator">删除</a>
					    <a href="#" onclick="peixunEditPre(<s:property value="#peixun.peixunId"/>)" class="pn-loperator">编辑</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="peixunAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
