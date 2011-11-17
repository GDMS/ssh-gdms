<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理后台属性</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>
	<body>
		<script type="text/javascript" src="admin/studentInfo.js"></script>
		<br>
		<!-- -------------------------------------------------------------- -->
		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">后台属性：</font>
				</td>
				<td>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<s:form action="adminProperty" namespace="/admin" method="post"
			theme="simple">
			<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
				<TR>
					<TD width="115" ALIGN="center" class="tableTop">
						作用
					</TD>
					<TD width="115" ALIGN="center" class="tableTop"
						style="display: none;">
						键
					</TD>
					<TD width="115" ALIGN="center" class="tableTop">
						数值
					</TD>
				</TR>
				<tr bgcolor="#dcdcdc">
					<s:iterator value="properties" id="list" status="st">
						<tr class="tableDetail">
							<td align="center">
								<s:property value="properties[#st.index].name" />
							</td>
							<td align="center" style="display: none;">
								<s:textfield name="%{'properties['+#st.index+'].key'}"
									readonly="true" />
							</td>
							<td align="center">
								<s:if test="valueB!=null">
									<s:select name="%{'properties['+#st.index+'].valueB'}"
										list="%{#{'true':'是','false':'否'}}" value="valueB" />
								</s:if>
								<s:elseif test="valueD!=null">
									<s:textfield name="%{'properties['+#st.index+'].valueD'}" />
								</s:elseif>
								<s:else>
									<s:textfield name="%{'properties['+#st.index+'].value'}" />
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</tr>
			</TABLE>
			<s:submit value="更新" />
		</s:form>
		<!-- -------------------------------------------------------------- -->
		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>
	</body>
</html>