<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=subResult.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<TABLE border="1">
			<TR>
				<TD >
					课题名称
				</TD>
				<TD >
					题目类型
				</TD>
				<TD >
					题目性质
				</TD>
				<TD >
					承担方式
				</TD>
				<TD >
					已被预选次数
				</TD>
			</TR>
			<s:iterator value="thesiss" var="thesis" status="st">
				<tr>
					<td >
						<s:property value="name" />
					</td>
					<td >
						<s:property value="type" />
					</td>
					<td >
						<s:property value="property" />
					</td>
					<td >
						<s:property value="mode" />
					</td>
					<td >
						<s:property value="%{num[#st.index]}" />
					</td>
				</tr>
			</s:iterator>
		</TABLE>
	</body>
</html>
