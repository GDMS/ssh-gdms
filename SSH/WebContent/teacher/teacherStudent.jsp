<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生详细信息</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
  </head>
  
  <body>

  	<table width="841" border="0" cellpadding="0" cellspacing="0">
		<tr> 
		    <td height="405" valign="top"><p>学生详细信息：</p>
        	<s:form action="studentMod" namespace="/student" method="post">
        	<table align="center">
	          	<tr valign="baseline"> 
	            	<td class="tableHeading" nowrap align="right" width=70>姓 名：<br></td>
	            	<td><s:property value="%{student.name}"/><br></td>
	         	</tr>
			    <tr valign="baseline"> 
			            <td class="tableHeading" nowrap align="right">性 别：<br></td>
				        <td>
				        	<s:property value="%{student.gender}"/>			        
				        <br></td>
			        </tr>
					<tr valign="baseline"> 
			            <td class="tableHeading" nowrap align="right">专 业：<br></td>
			             <td>
			             <s:property value="%{student.stuClass.major.name}"/>
						<br></td>
			        </tr>
					<tr valign="baseline"> 
			            <td class="tableHeading" nowrap align="right">班 级：<br></td>
			            <td>
			             <s:property value="%{student.stuClass.name}"/>
			            <br></td>
			        </tr>
					<tr valign="baseline"> 
			            <td class="tableHeading" nowrap align="right">学分绩点：<br></td>
			            <td>
			             <s:property value="%{student.credit}"/>
			            <br></td>
			        </tr>
			        <tr valign="baseline"> 
	            		<td class="tableHeading" nowrap align="right" width=70>联系方式：<br></td>
	            		<td>
	            		<s:property value="%{student.phone}"/>
					<br></td>
	         		</tr>
	         		<tr valign="baseline"> 
	            		<td class="tableHeading" nowrap align="right" width=70>电子邮箱：<br></td>
	            		<td>
	            		<s:property value="%{student.email}"/>
	            		<br></td>
	         		</tr>
			</table>
			</s:form>
    		</td>
		</tr>
 	</table>

 	<center>
		<A HREF="teacher/subAssign.action">返回</A>
	</center>
  	
  	
  	
  </body>
</html>

