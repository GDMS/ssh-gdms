<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员操作</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td>
					<div height="60px" valign="middle" align="left"
						style="color: #ff8800; font-size: 23; padding-top: 10px;">
						<b>管理员操作选择页面</b>
					</div>
					<div id="thirdcol">
						<div id="mainmenu">
							<ul>
								<li>
									<a href="admin/newsRelease!query.action"> 信息发布 </a>
								</li>
								<li>
									<a href="admin/teacherReg!query.action"> 注册新教师 </a>
								</li>
								<li>
									<a href="admin/majorReg.action"> 新增专业班级 </a>
								</li>
								<li>
									<a href="admin/pyManage.action"> 管理评语 </a>
								</li>
								<!--
								<li>
									<a href="admin/studentPercent!query.action"> 设置预选学生比例 </a>
								</li>
								-->
								<!--
								<li>
									<a href="admin/dbOperate.jsp"> 数据库操作 </a>
								</li>
								-->
								<li>
									<a href="admin/lwManage.jsp"> 论文管理 </a>
								</li>
								<li>
									<a href="admin/viewSelect.jsp"> 查看视图 </a>
								</li>
								<li>
									<a href="admin/studentInfo!query.action"> 管理学生信息 </a>
								</li>
								<li>
									<a href="admin/teacherInfo!query.action"> 管理教师信息 </a>
								</li>
								<li>
									<a href="admin/subInfoManage!query.action"> 管理课题信息 </a>
								</li>
								<li>
									<a href="admin/studentPreviewInfo!query.action"> 管理学生预选信息 </a>
								</li>
								<li>
									<a href="admin/subAssignInfo.action"> 管理学生课题分配信息 </a>
								</li>
								<li>
									<a href="admin/subAssignedInfo.action"> 管理已分配信息 </a>
								</li>
								<li>
									<a href="admin/assignAuto!query.action"> 自动分配 </a>
								</li>
								<li>
									<a href="admin/printManage!adminuse.action"> 打印管理 </a>
								</li>
								<li>
									<a href="admin/adminPropertyQuery.action"> 后台属性管理 </a>
								</li>
								<li>
									<a href="admin/adminPassword!adminquery.action"> 管理员修改密码 </a>
								</li>
								<li>
									<a href="logout.action"> 管理员注销 </a>
								</li>
							</ul>
						</div>
					</div>
				</td>
				<td width="15%">
					<div class="table_area">
						<div class="table_top">
							帮助信息:
						</div>
						<div class="table_bodyarea_help">
							<a href="teacher/main.jsp#"> GDMS管理员使用手册 </a>
						</div>
						<div class="table_bottom"></div>
					</div>
					<br />
					<div class="table_area">
						<div class="table_top">
							提示信息
						</div>
						<div class="table_bodyarea_help">
						</div>
						<div class="table_bottom"></div>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
