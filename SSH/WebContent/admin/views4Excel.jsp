<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view4.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
	<table CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<tr>
				<td width="115" ALIGN="center" class="tableHeading">
					教师
				</td>
				<td width="135" ALIGN="center" class="tableHeading">
					计划人数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					课题数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					实际人数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					差额
				</td>

			</tr>

		
				<s:iterator value="views4s" var="all" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="tutor" />
						</td>
						<td align="center">
							<s:property value="plannum" />
						</td>
						<td align="center">
							<s:property value="subnum" />
						</td>
						<td align="center">
							<s:property value="actualnum" />
						</td>
						<td align="center">
							<s:property value="dif" />
						</td>
					</tr>
				</s:iterator>
			
		</TABLE>
	</body>
</html>
