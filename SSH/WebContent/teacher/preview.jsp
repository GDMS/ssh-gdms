<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-查看学生预选情况并选择分配</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="teacher/preview.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					已提交给您的学生预选信息：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">注意：这是所有选了您的课题的学生的预选信息，若录取老师一栏为空，表示该生还未被任何老师录取，您可以选择分配。
						<br>您可以自由选择的学生人数为<FONT COLOR="#ff6600">${teacher.maxassign}</font>人，在自动分配结束之后将会取消此限制。</font>
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:if test="%{previews.isEmpty()}">	
				课题已经分配完
		</s:if>
					<s:else>
						<TABLE>
							<TR>
								<TD class="tableTop">
									学号
								</TD>
								<TD class="tableTop">
									姓名
								</TD>
								<TD class="tableTop">
									预选课题
								</TD>
								<TD class="tableTop">
									志愿顺序
								</TD>
								<TD class="tableTop">
									性别
								</TD>
								<TD class="tableTop">
									专业
								</TD>
								<TD class="tableTop">
									班级
								</TD>
								<TD class="tableTop">
									学分绩点
								</TD>
								<TD class="tableTop">
									录取老师
								</TD>
								<TD class="tableTop">
									选择分配
								</TD>
							</TR>
							<s:iterator value="previews" var="preview" status="st2">
								<tr>
									<td class="tableDetail">
										<s:property value="student.studentno" />
									</td>
									<td class="tableDetail">
										<s:property value="student.name" />
									</td>
									<td class="tableDetail">
										<s:property value="thesis.name" />
									</td>
									<td class="tableDetail">
										<s:property value="suborder" />
									</td>
									<td class="tableDetail">
										<s:property value="student.gender" />
									</td>
									<td class="tableDetail">
										<s:property value="student.stuClass.major.name" />
									</td>
									<td class="tableDetail">
										<s:property value="student.stuClass.name" />
									</td>
									<td class="tableDetail">
										<s:property value="student.credit" />
									</td>
									<td class="tableDetail">
										<s:if test="thesis.student!=null">
											<s:if
												test="thesis.student.studentno.equals(student.studentno)">
												<s:property value="student.thesis.teacher.name" />
											</s:if>
										</s:if>
										<s:elseif test="student.thesis==null">
										</s:elseif>
										<s:else>
											<s:property value="student.thesis.teacher.name" />
										</s:else>
									</td>
									<td class="tableDetail">
										<s:if test="thesis.student!=null">
											该课题已被分配
										</s:if>
										<s:elseif test="student.thesis==null">
											<a
												href="teacher/preview!select.action?studentNo=${student.studentno}&thesisNo=${thesis.thesisno}">选择</a>
										</s:elseif>
										<s:else>
											该生其他志愿被录取
										</s:else>
									</td>
							</s:iterator>
						</table>
					</s:else>
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="font-size: 13px; color: slategray;">
						第
						<span id="page">${page}</span>页，共
						<span id="totalPage">${totalPage}</span>页
						<a id="pre" href="teacher/preview.action?page=${page-1}">上一页</a> ，
						<a id="next" href="teacher/preview.action?page=${page+1}">下一页</a>
						转到：第
						<input type=text id="pageNo" size=1 value="${page}">
						页
						<input type=button id="go" value=GO
							onclick="gotoPage(${totalPage})">
					</div>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>

	</body>
</html>