<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
           function yuangongDel(yuangongId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/yuangongDel.action?yuangongId="+yuangongId;
               }
           }
           
           function yuangongAdd()
           {
                 var url="<%=path %>/admin/yuangong/yuangongAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           
           function yuangongEditPre(yuangongId)
           {
               window.location.href="<%=path %>/yuangongEditPre.action?yuangongId="+yuangongId;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <form action="<%=path %>/yuangongSearch.action" method="post" name="form1">
					    姓名:<input type="text" name="yuangongName"/>
					    年龄：<input type="text" size="6" name="yuangongAgeSta" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					        ---
					        <input type="text" size="6" name="yuangongAgeEnd" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					    学历:<input type="text" name="yuangongXueli"/>
					    
					    <input type="submit" value="搜索" style="width: 80px;"/>
					</form>
			    </td>
			  </tr>
		    </table>
			
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/images/tbg.gif">&nbsp;员工维护&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="8%">姓名</td>
					<td width="5%">性别</td>
					<td width="5%">年龄</td>
					<td width="5%">学历</td>
					<td width="8%">职位</td>
					<td width="10%">住址</td>
					<td width="12%">tel</td>
					<td width="12%">email</td>
					<td width="8%">部门</td>
					<td width="13%">操作</td>
		        </tr>	
				<s:iterator value="#request.yuangongList" id="yuangong">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuangong.yuangongSex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongAge"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongXueli"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuangong.yuangongZhiwei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongAddress"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongTel"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <s:property value="#yuangong.yuangongEmail"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongOrgName"/><!-- 部门 -->
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="yuangongDel(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">删除</a>
						<a href="#" onclick="yuangongEditPre(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">编辑</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加员工" style="width: 80px;" onclick="yuangongAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
