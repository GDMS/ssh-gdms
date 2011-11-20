<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员-打印管理</title>
<link rel="stylesheet" type="text/css" href="css/master.css">

</head>

<body>
	<script type="text/javascript" src="admin/printManage.js"></script>
	<br>

	<!-- -------------------------------------------------------------- -->


	<FONT SIZE="+1" COLOR="#ff6600">选择需要打印报告的学生：</font>
	<br>
	<br>
	<FONT COLOR=slategray>注意：成绩为0分同学请不要打印。
		如果指导老师没有为学生填写“选择学生并输入该生的论文成绩和评语”中的内容，将无法打印该同学的报告。</font>
	<br>
	<br>
	<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
		<TR>

			<TD width="95" ALIGN="center" class="tableTop">学号</TD>
			<TD width="95" ALIGN="center" class="tableTop">姓名</TD>
			<TD width="300" ALIGN="center" class="tableTop">课题名称</TD>
			<TD width="95" ALIGN="center" class="tableTop">成绩</TD>
			<TD width="95" ALIGN="center" class="tableTop">查看评语</TD>
			<TD width="95" ALIGN="center" class="tableTop">打印</TD>
		</TR>
		<s:iterator value="students" var="student" status="st2">
			<tr class="tableDetail">
				<td align="center" class="tableDetail"><s:property
						value="studentno" /></td>
				<td align="center" class="tableDetail"><s:property value="name" />
				</td>
				<td align="center" class="tableDetail"><s:property
						value="thesis.name" /></td>
				<td align="center" class="tableDetail"><s:property
						value="studentScore.grade" /></td>
				<td align="center" class="tableDetail"><A
					HREF="admin/printManage!view.action?studentNo=${student.studentno}">查看</A>
				</td>
				<td align="center" class="tableDetail"><a
					href="/SSH/Admin/AdminPrint?studentno=${student.studentno}">打印</a>
				</td>
			</tr>
		</s:iterator>
	</TABLE>



	<div>
		第 <span id="page">${page}</span>页，共 <span id="totalPage">${totalPage}</span>页
		<a id="pre" href="admin/printManage!adminuse.action?page=${page-1}">上一页</a>
		， <a id="next" href="admin/printManage!adminuse.action?page=${page+1}">下一页</a>
		转到：第 <input type=text id="pageNo" size=1 value="${page}"> 页 <input
			type=button id="go" value=GO onclick="gotoPage(${totalPage})">
	</div>


	<br>
	<br>
	<a href="download/Sample.doc">论文评分表样张</a>
	<br>
	<br>
	<!-- -------------------------------------------------------------- -->
	<center>
		<A HREF="admin/main.jsp">返回</A>
	</center>


</body>
</html>