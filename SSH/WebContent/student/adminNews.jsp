<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生-查看管理员通知</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
  </head>
  
  <body>
	<!-- html code here below -->
  	<table width="941" border="0" cellpadding="0" cellspacing="0">
		<tr> 
		    <td width="378" height="35" valign="top"><FONT SIZE="+1" COLOR="#ff6600">学生查看管理员通知页面</FONT></td>
		    <td width="300"></td>
		    <td rowspan="3" width="200" align="right" valign="top"> </td>
  		</tr>
  		<tr> 
    		<td height="405" valign="top"><p></p>
				<table width="463" border="0" cellspacing="2" cellpadding="4" style="WIDTH: 463px;">
					<tr class="tableHeading"> 
						<td width="150"><B><FONT COLOR="white">请留意：</FONT></B></td>
        			</tr>
        			<tr bgcolor="#dcdcdc"> 
						<td>&nbsp; </td>
		          		<td>
		           		<b><font color=slategray>各位同学：</font></b><br>&nbsp;&nbsp;&nbsp;
		          		<textarea style="WIDTH: 282px; HEIGHT: 86px" rows=3 cols=32 readonly="readonly">msgToStu</textarea>
		           		</td>
        			</tr>
     			</table>
    		</td>
		</tr>
	</table>

	<center>
	<a HREF="student/main.jsp">返回</a>
	</center>
  	
  </body>
</html>