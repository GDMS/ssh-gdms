﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>教师-输入评语和成绩-选择学生</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
  </head>
  <body>
  	<table width="841" border="0" cellpadding="0" cellspacing="0">
  		<tr> 
		    <td width="378" height="35" valign="top">  <FONT SIZE="+1" COLOR="#ff6600">论文评分页面</FONT></td>
		    <td rowspan="3" width="200" align="right" valign="top"> 
		    	<table width="100%" border="0" cellspacing="2" cellpadding="4">
			        <tr class="tableHeading"> 
			          	<td> <B><FONT COLOR="white">系统提示：</FONT></B> </td>
			        </tr>
			        <tr bgcolor="#dcdcdc"> 
			          	<td><font color=slategray>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT COLOR="#ff6600">对于毕业课题的摘要描述和特点描述</FONT>
			          		内容输入的字数应保持在<FONT COLOR="#ff6600">200个字符</FONT>以内，包括空格以及标点。</font><br>
			          		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=slategray>左边输入框一行可以输入大约<font COLOR="#ff6600">19个汉字</font>。<br></font>
			          		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font COLOR="#ff6600">对于毕业课题的摘要描述：</font>
			          		<font color=slategray>摘要描述主要写毕业论文的摘要部分的梗概，设计论文题目，论文描述对象，论文背景等。<br></font>
			          		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font COLOR="#ff6600">对于毕业课题的特点描述：</font>
			          		<font color=slategray>特点描述主要写毕业论文的特点，使用技术，优点及创新等内容。<br></font>
			          	<hr SIZE="3"><font color="#ff6600"><html:errors/></font></td>
			        </tr>
      			</table>
      		</td>
		</tr>
		<tr> 
    		<td height="405" valign="top"><p>请输入你对该论文的成绩和评语：</p>
	        		<table align="center" >
	        		 <s:form action="gradeInput" method="post" namespace="/teacher">
	        		<tr valign="baseline"> 
	        		
	            		<td class="tableHeading" nowrap align="right" width=100 >课题名称：</td>
	            		<td>${thesis.name}</td>
	          		</tr>
	          		<tr valign="baseline"> 
	            		<td class="tableHeading" nowrap align="right" width=100 >学生学号：</td>
	            		<td><s:textfield  name="student.studentno" readonly="true"/></td>
	          		</tr>
			   		<tr valign="baseline"> 
	            		<td class="tableHeading" nowrap align="right" width=100 >学生姓名：</td>
	            		<td><input value="${thesis.student.name}" readonly="readonly"></td>
	          		</tr>
	          		<tr valign="baseline"> 
            			<td class="tableHeading"  nowrap align="right" valign="top">该毕业设计的成绩：</td>
            			<td><s:textfield id="grade" name="studentScore.grade"  size="24"
										style="WIDTH: 199px; HEIGHT: 22px"/></td>
          			</tr>
          		
          			 <tr valign="baseline">
			            <td class="tableHeading" nowrap align="right" valign=top>对于该毕业设计的摘要描述：</td>
			            <td><s:textarea id="projDesc" name="studentScore.projDesc" style="WIDTH: 242px; HEIGHT: 86px" rows="3" cols="32"/></td>
			        </tr>
			        <tr valign="baseline">
			            <td class="tableHeading" nowrap align="right" valign=top>对于该毕业设计的特点描述：</td>
			            <td><s:textarea id="thesDesc" name="studentScore.thesDesc"  style="WIDTH: 242px; HEIGHT: 86px" rows="3" cols="32"/></td>
			        </tr>
          			<tr valign="baseline"> 
			            <td>
			            	<s:submit value="确定" style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid">
			            	</s:submit>			            
			             </td>  
         			</tr>
         			 </s:form>
        		</table>
    		</td>
		</tr>
 	</table>
 	<center>
		<A HREF="teacher/main.jsp">返回</A>
	</center>
  </body>
</html>