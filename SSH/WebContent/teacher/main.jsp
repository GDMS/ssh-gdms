<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>教师操作</title>
<link rel="stylesheet" type="text/css" href="css/headrow.css">
<script type="text/javascript" src="teacher/teachernews.js"></script>
</head>

<body>
	<!-- 实现弹出重要通知对话框 -->
	<div id="dialog" align="center" style="visibility: hidden">
		<font color="red"><s:actionmessage id="actionmessage" /></font>
	</div>
	<!-- 实现弹出重要通知对话框 Finish -->
	<table align="center" width="740px" border="0px">
		<tr valign="top">
			<td>
				<div height="60px" valign="middle" align="left"
					style="color: #ff8800; font-size: 23; padding-top: 10px;">
					<b>教师操作选择页面</b>
				</div>
				<div id="thirdcol">
					<div id="mainmenu">
						<ul>
							<li><a href="teacher/teacherMod!query.action">修改个人信息</a></li>
							<li><a href="teacher/subReg!query.action">注册新的课题</a></li>
							<li><a href="teacher/subResult.action">管理您的课题信息</a></li>
							<li><a href="teacher/subAssign.action">管理您的课题分配信息</a></li>
							<li><a href="teacher/preview.action">查看学生预选情况并选择分配</a></li>
							<li><a href="teacher/subReassign.action">为您指导的学生重新分配课题</a></li>
							<li><a href="teacher/subnameMod.action">为您指导的学生更改课题名称</a></li>
							<li><a href="teacher/fileManage.action">文档管理</a></li>
							<li><a href="teacher/teaMidternCheck.action">中期检查</a></li>
							<li><a href="teacher/gradeInput!query.action">
									选择学生并输入该学生的论文成绩和评语 </a></li>
							<li><a href="teacher/gradeSplit!query.action"> 分数拆分 </a></li>
							<li><a href="teacher/printManage.action"> 打印管理 </a></li>
							<li><a href="teacher/teacherPassword!teacherquery.action">
									教师修改密码 </a></li>
							<li><a href="logout.action"> 教师注销 </a></li>
						</ul>
					</div>
				</div>
			</td>
			<td width="15%">
				<div class="table_area">
					<div class="table_top">帮助信息</div>
					<div class="table_bodyarea_help">
						<a href="teacher/help.jsp"> 系统操作帮助信息 </a>
						<hr SIZE="3">
						<a href="teacher/adminNews.jsp"> 管理员通知 </a>
					</div>
					<div class="table_bottom"></div>
				</div> <br />
				<div class="table_area">
					<div class="table_top">提示信息</div>
					<div class="table_bodyarea_help"></div>
					<div class="table_bottom"></div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
