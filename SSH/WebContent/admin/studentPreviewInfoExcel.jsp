<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=studentPreviewInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    
    <title>studentPreviewInfoExcel.jsp</title>

  </head>
  <body>
   <TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="95" ALIGN="center">
					studentno
				</TD>
				<TD width="95" ALIGN="center">
					studentname
				</TD>
				<TD width="95" ALIGN="center">
					suborder
				</TD>
				<TD width="300" ALIGN="center">
					preview_thesis
				</TD>
				<TD width="95" ALIGN="center">
					tutor
				</TD>
				
			</TR>
			<s:iterator value="previews" var="preview" status="st2">
				<tr >
					<td  align="center">
						<s:property value="student.studentno" />
					</td>
					<td  align="center">
						<s:property value="student.name" />
					</td>
					<td  align="center">
						<s:property value="suborder" />
					</td>
					<td  align="center">
						<s:property value="thesis.name" />
					</td>
					<td  align="center">
						<s:property value="thesis.teacher.name" />
					</td>
					</tr>
			</s:iterator>
		</TABLE>
  </body>
</html>
