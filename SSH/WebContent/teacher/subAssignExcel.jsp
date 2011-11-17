<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=subAssign.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<TABLE border="1">
			<TR>
				<TD>
					学号
				</TD>
				<TD>
					姓名
				</TD>
				<TD>
					课题名称
				</TD>
				<TD>
					课题类型
				</TD>
				<TD>
					课题性质
				</TD>
				<TD>
					承担方式
				</TD>
				<TD>
					分配形式
				</TD>
			</TR>
			<s:iterator value="thesiss" var="thesis" status="st">
				<tr>
					<s:if test="student==null">
						<td>
							未选择
						</td>
						<td>
							未选择
						</td>
					</s:if>
					<s:else>
						<td>
							<s:property value="student.studentno" />
						</td>
						<td>
							<s:property value="student.name" />
						</td>
					</s:else>

					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="type" />
					</td>
					<td>
						<s:property value="property" />
					</td>
					<td>
						<s:property value="mode" />
					</td>
					<td>
						<s:property value="assigned" />
					</td>
				</tr>
			</s:iterator>
		</TABLE>
	</body>
</html>
