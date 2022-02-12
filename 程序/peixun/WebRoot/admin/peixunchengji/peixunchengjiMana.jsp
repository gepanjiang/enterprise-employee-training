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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function peixunchengjiDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   var url="<%=path %>/peixunchengjiDel.action?id="+id;
		           var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	               pop.setContent("contentUrl",url);
	               pop.setContent("title","培训成绩");
	               pop.build();
	               pop.show();
               }
           }
           
           function peixunchengjiAdd(peixunId)
           {
                var url="<%=path %>/admin/peixunchengji/peixunchengjiAdd.jsp?peixunId="+peixunId;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","培训成绩");
	            pop.build();
	            pop.show();
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/images/tbg.gif">&nbsp;培训成绩&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">员工</td>
					<td width="25%">成绩</td>
					<td width="25%">操作</td>
		        </tr>	
				<s:iterator value="#request.peixunchengjiList" id="peixunchengji">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixunchengji.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixunchengji.chengji"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="peixunchengjiDel(<s:property value="#peixunchengji.id"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加培新成绩" style="width: 80px;" onclick="peixunchengjiAdd(<s:property value="#request.peixunId"/>)" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
