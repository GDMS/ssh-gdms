<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=teacherInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    
    <title>teacherInfoExcel.jsp</title>
  </head>
  <body>
    <TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="95" ALIGN="center" >
					教师姓名
				</TD>
				<TD width="135" ALIGN="center" >
					密码
				</TD>
				<TD width="135" ALIGN="center" >
					所属系别
				</TD>
				<TD width="95" ALIGN="center">
					可指导学生数
				</TD>
				<TD width="95" ALIGN="center" >
					已指导学生数
				</TD>
				<TD width="115" ALIGN="center" >
					电话号码
				</TD>
				<TD width="215" ALIGN="center" >
					E-mail
				</TD>
			</TR>
				<s:iterator value="teachers" var="teacher" status="st2">
				<tr >
					<td align="center">
						<s:property value="name" />
					</td>
					<td align="center">
						<s:property value="password" />
					</td>
					<td align="center">
						<s:property value="teacherDept.name" />
					</td>
					<td align="center">
						<s:property value="subnum" />
					</td>
					<td align="center">
						<s:property value="%{num[#st2.index]}" />
						
					</td>
					<td align="center">
						<s:property value="tel" />
					</td>
					<td align="center">
						<s:property value="mail" />
					</td>
					</tr>
			</s:iterator>
		</TABLE>
  </body>
</html>
