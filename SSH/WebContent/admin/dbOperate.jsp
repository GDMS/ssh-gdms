<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员-数据库操作</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
  </head>
  
  <body>


  	<table width="841" border="0" cellpadding="0" cellspacing="0">
  		<tr> 
		    <td width="378" height="35" valign="top">  <FONT SIZE="+1" COLOR="#ff6600">管理员操作数据库</FONT></td>
		    <td rowspan="3" width="200" align="right" valign="top"> 
		    	<table width="100%" border="0" cellspacing="2" cellpadding="4">
			        <tr class="tableHeading"> 
			          	<td> <B><FONT COLOR="white">系统提示：</FONT></B> </td>
			        </tr>
			        <tr bgcolor="#dcdcdc"> 
			          	<td><font color=slategray>请选择需要的操作。</font>
			          	<hr SIZE="3"><font color="#ff6600"><s:actionerror /></font></td>
			        </tr>
      			</table>
      		</td>	
		</tr>
		<tr> 
    		<td height="405" valign="top"><p>请选择需要的操作：</p>
      			<table width="463" border="0" cellspacing="2" cellpadding="4" style="WIDTH: 463px; HEIGHT: 150px">
        			<tr class="tableHeading"> 
						<td width="150"><B><FONT COLOR="white">请选择：</FONT></B></td>
          				<td></td>  
        			</tr>
        			<tr bgcolor="#dcdcdc"> 
        				<td></td>
        				<td>
          					<A onclick="BackupvalidateForm()">备份数据库</A>  
				          	<hr SIZE="3">
				          	<A onclick="RestorevalidateForm()">还原数据库</A>  
				          	<hr SIZE="3">
				          	<A href="admin/dbManage.jsp">数据库管理</A>    
				          	<hr SIZE="3"/>
            			</td>
        			</tr>
      			</table>
    		</td>
		</tr>
 	</table>
 	<center>
		<A HREF="admin/main.jsp">返回</A>
	</center>

  </body>
</html>
