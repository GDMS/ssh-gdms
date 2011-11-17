<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生操作</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td>
					<div height="60px" valign="middle" align="left"
						style="color: #ff8800; font-size: 23; padding-top: 10px;">
						<b>学生操作选择页面</b>
					</div>
					<div id="thirdcol">
						<div id="mainmenu">
							<ul>
								<li>
									<a href="student/studentMod!query.action">修改个人信息</a>
								</li>
								<li>
									<a href="student/subChoose!query.action">选择课题 </a>
								</li>
								<li>
									<a href="student/subResult.action">管理预选课题</a>
								</li>
								<li>
									<a href="student/subAssign.action">查看课题分配结果</a>
								</li>
								<li>
									<a href="student/subAssign!query.action">更改课题名称</a>
								</li>
								<li>
									<a href="student/kt-reportUp.jsp">开题报告提交</a>
								</li>
								<li>
									<a href="student/assignmentUp.jsp">任务书提交</a>
								</li>
								<li>
									<a href="student/translateUp.jsp">翻译资料提交</a>
								</li>
								<li>
									<a href="student/midternCheck!query.action">中期自检</a>
								</li>
								<li>
									<a href="student/thesisUp.jsp">论文提交</a>
								</li>
								<li>
									<a href="student/qaInput!query.action">答辩信息输入</a>
								</li>
								<li>
									<a href="student/studentPassword!studentquery.action"> 学生修改密码 </a>
								</li>
								<li>
									<a href="logout.action">学生注销</a>
								</li>
							</ul>
						</div>
					</div>
				</td>
				<td width="15%">
					<div class="table_area">
						<div class="table_top">
							帮助信息
						</div>
						<div class="table_bodyarea_help">
							<a href="student/subInfo.jsp">课题相关信息</a>
							<hr SIZE="3">
							<a href="student/adminNews.jsp">管理员通知</a>
							<hr SIZE="3">
							<a href="student/main.jsp#"> 毕业论文模版下载 </a>
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
