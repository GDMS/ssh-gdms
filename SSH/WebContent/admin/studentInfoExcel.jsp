<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=studentInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    
    <title>studentInfoExcel.jsp</title>
  </head>
  <body>
   <TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="115" ALIGN="center" >
					学号
				</TD>
				<TD width="115" ALIGN="center" >
					姓名
				</TD>
				<TD width="115" ALIGN="center" >
					密码
				</TD>
				<TD width="95" ALIGN="center" >
					性别
				</TD>
				<TD width="135" ALIGN="center" >
					专业
				</TD>
				<TD width="115" ALIGN="center" >
					班级
				</TD>
				<TD width="115" ALIGN="center" >
					学分绩点
				</TD>
				<TD width="115" ALIGN="center" >
					联系方式
				</TD>
				<TD width="115" ALIGN="center" >
					Email
				</TD>
			</TR>
				<s:iterator value="students" var="student" status="st2">
				<tr >
					<td align="center">
						<s:property value="studentno" />
					</td>
					<td align="center">
						<s:property value="name" />
					</td>
					<td align="center">
						<s:property value="password" />
					</td>
					<td align="center">
						<s:property value="gender" />
					</td>
					<td align="center">
						<s:property value="stuClass.major.name" />
					</td>
					<td align="center">
						<s:property value="stuClass.name" />
					</td>
					<td align="center">
						<s:property value="credit" />
					</td>
					<td align="center">
						<s:property value="phone" />
					</td>
					<td align="center">
						<s:property value="email" />
					</td>
					</tr>
			</s:iterator>
		</TABLE>
  </body>
</html>
