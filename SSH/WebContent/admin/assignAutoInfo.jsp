<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-自动分配</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/assignauto.js"></script>
		<br>

		<FONT SIZE="+1" COLOR="#ff6600">所有学生的课题分配信息：<s:actionerror />
			<s:actionmessage /> </font>
		<br>

		<br>
		<FONT COLOR="slategray">注意：显示按课题名称排序。若课题名称及指导老师为空，表示该学生未被分配；若只有课题名称为空，表示该学生已有导师但课题未被分配。</font>
		<a href="admin/assignAuto!Excel.action?printable=true">点此导出Excel</a>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="65" ALIGN="center" class="tableTop">
					序号
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="320" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					分配形式
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学分绩点
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学生预选信息
				</TD>
			</TR>

			<s:iterator value="students" var="student" status="st">
				<tr class="tableDetail">
					<td class="tableDetail" align="center">
						<s:property value="%{#st.count+(page-1)*10}" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="studentno" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.teacher.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.assigned" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="credit" />
					</td>
					<td class="tableDetail" align="center">
						<a href="admin/studentPreviewInfo!query.action">查看</a>
					</td>
				</tr>
			</s:iterator>


			<tr valign="baseline">
				<td>
					<INPUT type="button" value="开始自动分配"
						style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
						onclick="assignAuto()">
				</td>
				<td>
					<INPUT type="button" value="撤销自动分配"
						style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
						onclick="assignClean()">
				</td>
				<td>
					<INPUT type="button" value="确认自动分配"
						style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
						onclick="assignConfirm()">
				</td>
			</tr>

			<tr>
				<td colspan="4">
					<select id="assignSelect" name="assignMethod">
						<option value="1" selected="selected">
							绩点参与运算
						</option>
						<option value="2" disabled="disabled">
							纯随机（不推荐使用）
						</option>
					</select>
				</td>
			</tr>

		</TABLE>
		<script type="text/javascript">
		
		</script>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/assignAuto!query.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="admin/assignAuto!query.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>
		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>
	</body>
</html>

