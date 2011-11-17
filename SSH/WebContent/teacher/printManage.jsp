<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-打印管理</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">

	</head>

	<body>
		<script type="text/javascript" src="teacher/printManage.js"></script>
		
		<br>

		<!-- -------------------------------------------------------------- -->


		<FONT SIZE="+1" COLOR="#ff6600">选择需要打印报告的学生：</font>
		<br>
		<br>
		<FONT COLOR="slategray">注意：成绩为0分同学请不要打印。
			打印之前请先填写“选择学生并输入该生的论文成绩和评语”&gt;&gt;<A
			HREF="teacher/gradeInput!query.action">点击进入</A>，否则无法打印该同学的报告。</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>

				<TD width="95" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="265" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					成绩
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					查看评语
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					打印
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="thesises" var="thesis" status="st">
					<tr class="tableDetail">
						<s:if test="student==null">
							<td align="center" class="tableDetail">
								未选择
							</td>
							<td align="center" class="tableDetail">
								未选择
							</td>
						</s:if>
						<s:else>
							<td align="center" class="tableDetail">
								<s:property value="student.studentno" />
							</td>
							<td align="center" class="tableDetail">
								<s:property value="student.name" />
							</td>
						</s:else>

						<td align="center" class="tableDetail">
							<s:property value="name" />
						</td>
						<td align="center" class="tableDetail">
							<s:property value="student.studentScore.grade" />
						</td>

						<td align="center" class="tableDetail">
							<A
								HREF="teacher/printManage!view.action?studentno=${student.studentno}">查看</A>
						</td>
						<td align="center" class="tableDetail">
							<s:if test="student==null">
								<a>打印</a>
							</s:if>
							<s:else>
								<a href="/SSH/Admin/AdminPrint?studentno=${student.studentno}">打印</a>
							</s:else>
						</td>
					</tr>
				</s:iterator>

			</tr>


		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/printManage!adminuse.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="admin/printManage!adminuse.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>
		<!-- -------------------------------------------------------------- -->
		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>

	</body>
</html>