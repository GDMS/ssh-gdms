<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-文档管理</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					学生提交文档情况：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<TABLE>
						<TR>
							<TD class="tableTop">
								学号
							</TD>
							<TD class="tableTop">
								姓名
							</TD>
							<TD class="tableTop">
								课题名称
							</TD>
							<TD class="tableTop">
								开题报告
							</TD>
							<TD class="tableTop">
								任务书
							</TD>
							<TD class="tableTop">
								外文翻译
							</TD>
							<TD class="tableTop">
								毕业论文
							</TD>
						</TR>
						<s:iterator value="thesises" var="thesis" status="st">
							<tr>
								<s:if test="student==null">
									<td class="tableDetail">
										无
									</td>
									<td class="tableDetail">
										无
									</td>
									<td class="tableDetail">
										<s:property value="name" />
									</td>
									<td class="tableDetail">
										无
									</td>
									<td class="tableDetail">
										无
									</td>
									<td class="tableDetail">
										无
									</td>
									<td class="tableDetail">
										无
									</td>
								</s:if>
								<s:else>
									<td class="tableDetail">
										<s:property value="student.studentno" />
									</td>
									<td class="tableDetail">
										<s:property value="student.name" />
									</td>
									<td class="tableDetail">
										<s:property value="name" />
									</td>
									<s:if test="student.studentMaterialUpload.ktup==null">
										<td class="tableDetail">
											未上传
										</td>
									</s:if>
									<s:else>
										<td class="tableDetail">
											<a href="upload/KTReport/${student.studentMaterialUpload.ktup}">download</a>
										</td>
									</s:else>

									<s:if test="student.studentMaterialUpload.rwsup==null">
										<td class="tableDetail">
											未上传
										</td>
									</s:if>

									<s:else>
										<td class="tableDetail">
											<a
												href="upload/RWSReport/${student.studentMaterialUpload.rwsup}">download</a>
										</td>
									</s:else>

									<s:if test="student.studentMaterialUpload.transup==null">
										<td class="tableDetail">
											未上传
										</td>
									</s:if>
									<s:else>
										<td class="tableDetail">
											<a
												href="upload/Translation/${student.studentMaterialUpload.transup}">download</a>
										</td>
									</s:else>

									<s:if test="student.studentMaterialUpload.thesisup==null">
										<td class="tableDetail">
											未上传
										</td>
									</s:if>
									<s:else>
										<td class="tableDetail">
											<a
												href="upload/Thesis/${student.studentMaterialUpload.thesisup}">download</a>
										</td>
									</s:else>
								</s:else>
							</tr>
						</s:iterator>
					</TABLE>
					<br>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>
	</body>
</html>