<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%-- 引入JSTL标签库 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<!-- 实现弹出重要通知对话框 -->
		<script type="text/javascript" src="indexnews.js"></script>
		<div id="dialog" title="重要通知">
			<p>
				<s:property value="message" />
			</p>
		</div>
		<!-- 实现弹出重要通知对话框 Finish -->
		<table id="table" align="center" width="735px" border="0px">
			<tr valign="top">
				<td>
					<table border="0px" width="100%">
						<tr>
							<td>
								<font size="2px" color="slategray"> <br> 访问时间为：<%=new Date()%>
									<br/> 建议采用分辨率：1024×768&nbsp;&nbsp;&nbsp;<br/>建议使用浏览器：谷歌(Chrome)浏览器、火狐(FireFox)浏览器 </font>
							</td>
						</tr>
						<tr>
							<td style="background-image: url('images/index.png');"
								width="487px" ; height="354px"; >
								<br>

							</td>
						</tr>
					</table>
					<div id="sidebar">
						<ul>
							<li>
								<h2>
									系统使用手册
								</h2>
								<ul class="book">
									<li>
										<a href="download/student_guide.doc">GDMS学生使用手册</a>
									</li>
									<li>
										<a href="download/teacher_guide.doc">GDMS教师使用手册</a>
									</li>
								</ul>
							</li>

						</ul>
					</div>
					<div id="sidebar">
						<ul>
							<li>
								<h2>
									历届优秀毕业论文赏析
								</h2>
								<ul class="book">
									<li>
										<c:forEach items="${lw}" var="list">
											<a href="upload/YXLW/${list.name}">${list.name}</a>
											<br />
										</c:forEach>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</td>
				<td align="right" width="10%">
					<table style="padding-top: 20px;">
						<tr>
							<td>
								<div class="table_area">
									<div class="table_top">
										相关新闻
									</div>
									<div class="table_bodyarea">
										<marquee direction="up" scrollDelay="100" scrollamount="2"
											onmouseover=this.stop() onmouseout=this.start()>
											<div>
												&nbsp;&gt;&gt;&nbsp;
												<a href="evaluation.jsp">毕业设计评估信息</a>
											</div>
											<div class="">
												<hr SIZE="1">
											</div>
											<div>
												&nbsp;&gt;&gt;&nbsp;
												<a href="anonymous/teacherInfo.action">指导教师联系方式</a>
											</div>
											<hr SIZE="1">
											<div>
												&nbsp;&gt;&gt;&nbsp;
												<a href="indexnews.jsp">管理员通知</a>
											</div>
											<hr SIZE="1">
										</marquee>
									</div>
									<div class="table_bottom"></div>
								</div>
								<br>
								<div class="table_area">
									<div class="table_top">
										相关链接
									</div>
									<div class="table_bodyarea">
										<br>
										<p>
											&nbsp;
											<a HREF="http://www.dhu.edu.cn" target=_blank><img
													src="images/a.jpg" />&nbsp;东华大学主页</a>
										</p>
										<br>
										<p>
											&nbsp;
											<a HREF="http://www3.dhu.edu.cn/computer/index.asp"
												target=_blank><img src="images/b.jpg" />&nbsp;计算机学院主页</a>
										</p>
										<br>
										<p>
											&nbsp;
											<a HREF="http://jw.dhu.edu.cn" target=_blank><img
													src="images/c.jpg" />&nbsp;校教务处</a>
										</p>
										<br>
										<p>
											&nbsp;
											<a HREF="http://www.csdn.net" target=_blank><img
													src="images/d.jpg" />&nbsp;CSDN</a>
										</p>
										<br>
										<p>
											&nbsp;
											<img src="images/e.jpg" />
											&nbsp;毕业设计评分系统
										</p>
										<br>
										<p>
											&nbsp;
											<a HREF="http://www.google.com" target=_blank><img
													src="images/f.jpg" />&nbsp;Google</a>
										</p>
										<br>
									</div>
									<div class="table_bottom"></div>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>