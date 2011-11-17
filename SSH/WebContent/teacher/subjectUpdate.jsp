<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
		<title>教师-管理课题信息-修改</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

  
  <body>
   	<table width="841" border="0" cellpadding="0" cellspacing="0">
   	  	<tr> 
		    <td width="378" height="35" valign="top"> <FONT SIZE="+1" COLOR="#ff6600">课题信息修改页面</FONT></td>
		    <td rowspan="3" width="200" align="right" valign="top"> 
		    	<table width="100%" border="0" cellspacing="2" cellpadding="4">
			        <tr class="tableHeading"> 
			          	<td><STRONG><FONT color=#ffffff>提示信息:</FONT></STRONG>&nbsp;</td>
			        </tr>
			        <tr bgcolor="#dcdcdc"> 
			          	<td style="COLOR: slategray">课题名称被修改后，已被分配到该课题的学生的课题名称将被同时修改。	            
			            <hr SIZE="3">
			            <font color="#ff6600"><s:actionerror /></font></td>
			        </tr>
      			</table>
      		</td>
  		</tr>
  		<tr> 
  		<td height="405" valign="top"><p>请输入相关信息：</p>
  		<s:form action="subjectUpdate" namespace="/teacher" method="post">
  		<table align="center">
  		 <tr valign="baseline"> 
			<td class="tableHeading" nowrap align="right" width=100>课题名称：</td>
			<td><s:textfield value="%{thesis_.name}" name="thesis_.name" size="32" /></td>
		</tr>
		<s:hidden name="thesis_.thesisno" >
		</s:hidden>
	
		<tr valign="baseline"> 
			<td class="tableHeading" nowrap align="right">承担方式：</td>
			<td><s:radio name="student.gender" list="%{#{'部分':'部分','独立':'独立'}}" value="%{thesis_.mode}" name="thesis_.mode" /></td>
		</tr>
        
        <tr valign="baseline"> 
			<td class="tableHeading" nowrap align="right">题目类型：</td>
			<td><s:select list="#{'设计类':'设计类','软件设计类':'软件设计类','课题研究类':'课题研究类',4:'其他类'}" value="thesis_.type" name="thesis_.type">				
			</s:select>
			</td>
		</tr>
		
		<tr valign="baseline"> 
			<td class="tableHeading" nowrap align="right">题目性质：</td>
			<td><s:select list="#{'纵向课题':'纵向课题','横向课题':'横向课题','自选课题':'自选课题','模拟课题':'模拟课题','其他':'其他'}"  value="thesis_.property" name="thesis_.property">	
			</s:select>
			</td>
		</tr>
				 
        <tr valign="baseline"> 
			 <td nowrap align="right"></td>
			 <td>
			  <s:submit value="确定" style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid" onfocus="true">
			            		
			  </s:submit>		              	
			  </td>
		</tr>
  		</table>
  		</s:form>
  		</td>
  		</tr>	
   	</table>
   	<center>
			<A HREF="teacher/subResult.action">返回</A>
			
	</center>
  </body>
</html>
