<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=subInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>

    <title>subInfoExcel.jsp</title>
  </head>
  
  <body>
   <TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="300" ALIGN="center" >
					课题名称
				</TD>
				<TD width="95" ALIGN="center" >
					指导老师
				</TD>
				<TD width="95" ALIGN="center" >
					题目类型
				</TD>
				<TD width="95" ALIGN="center" >
					题目性质
				</TD>
				<TD width="95" ALIGN="center" >
					承担方式
				</TD>
				<TD width="95" ALIGN="center" >
					分配情况
				</TD>
				<TD width="95" ALIGN="center" >
					已被预选次数
				</TD>
			</TR>
				<s:iterator value="thesises" var="thesis" status="st2">
				<tr >
					<td align="center">
						<s:property value="name" />
					</td>
					<td align="center">
						<s:property value="teacher.name" />
					</td>
					<td align="center">
						<s:property value="type" />
					</td>
					<td align="center">
						<s:property value="property" />
					</td>
					<td align="center">
						<s:property value="mode" />
					</td>
					<td align="center">
					<s:if test="assigned!=null">
					<s:property value="assigned" />
					</s:if>
					<s:else>未分配
					</s:else>
					</td>
					<td align="center">
						<s:property value="%{num[#st2.index]}" />
					</td>
					</tr>
			</s:iterator>
		</TABLE>
  </body>
</html>
