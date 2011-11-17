<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>拆分信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="teacher/gradeSplit.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title" colspan="4">
					拆分信息输入页面
				</td>
			</tr>
			<tr>
				<td>
					<s:form action="gradeSplit" namespace="/teacher" method="post">
						<table>
							<tr>
								<td class="textfield_label2">
									学生学号：
								</td>
								<td width="100px">
									<s:textfield theme="simple" cssClass="textfield2"
										id="studentno" name="student.studentno" />
								</td>
								<td class="textfield_label2">
									学生姓名
								</td>
								<td id="name" width="400px">
									<s:textfield theme="simple" cssClass="textfield2"
										name="student.name" value="%{student.name}" size="32"
										readonly="true" />
								</td>
							</tr>
							<tr>
								<td class="textfield_label2">
									输入该学生的预估分数：
								</td>
								<td>
									<s:textfield theme="simple" cssClass="textfield2" id="aver"
										value="%{student.studentScore.grade}" size="32" />
								</td>
								<td style="padding-bottom: 10px">
									<input type="button" value="拆分分数" onclick="split()">
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<TABLE id="tbin" CELLSPACING="2" CELLPADDING="5" BORDER="0"
										width="669" height="211">
										<TR>
											<TD class="tableTop">
												评分人
											</TD>
											<TD class="tableTop">
												评分项目
											</TD>
											<TD class="tableTop">
												项目成绩
											</TD>
											<TD class="tableTop">
												折合系数
											</TD>
											<TD class="tableTop">
												折合后分数
											</TD>
										</TR>
										<tr>
											<td class="tableDetail">
												指导老师
											</td>
											<td class="tableDetail">
												1毕业设计（论文）质量
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part1" cssClass="parts" name="student.studentScore.zd1grade"/>
											</td>
											<td class="tableDetail">
												0.15
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore1"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												指导老师
											</td>
											<td class="tableDetail">
												2绘图与文字表达技巧
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part2" cssClass="parts" name="student.studentScore.zd2grade"/>
											</td>
											<td class="tableDetail">
												0.05
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore2" 
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												指导老师
											</td>
											<td class="tableDetail">
												3独立工作能力
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part3" cssClass="parts" name="student.studentScore.zd3grade"/>
											</td>
											<td class="tableDetail">
												0.05
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore3"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												指导老师
											</td>
											<td class="tableDetail">
												4工作态度
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part4" cssClass="parts" name="student.studentScore.zd4grade"/>
											</td>
											<td class="tableDetail">
												0.05
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore4"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												评阅老师
											</td>
											<td class="tableDetail">
												1毕业设计（论文）水平
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part5" cssClass="parts" name="student.studentScore.py1grade"/>
											</td>
											<td class="tableDetail">
												0.20
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore5"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												评阅老师
											</td>
											<td class="tableDetail">
												2图文质量
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part6" cssClass="parts" name="student.studentScore.py2grade"/>
											</td>
											<td class="tableDetail">
												0.10
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore6"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												答辩小组
											</td>
											<td class="tableDetail">
												1口头汇报
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part7" cssClass="parts" name="student.studentScore.db1grade"/>
											</td>
											<td class="tableDetail">
												0.10
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore7"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td class="tableDetail">
												答辩小组
											</td>
											<td class="tableDetail">
												2回答问题正确性
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="part8" cssClass="parts" name="student.studentScore.db2grade"/>
											</td>
											<td class="tableDetail">
												0.30
											</td>
											<td class="tableDetail">
												<s:textfield theme="simple" id="partscore8"
													 cssClass="partscores" />
											</td>
										</tr>
										<tr>
											<td></td>
											<td>
												总评分
											</td>
											<td></td>
											<td></td>
											<td>
												<s:textfield theme="simple" id="Total"
													name="student.studentScore.grade"></s:textfield>
											</td>
										</tr>
									</TABLE>
								</td>
							</tr>
						</table>
						<s:submit theme="simple" type="image" value="提交" src="images/submit.png" />
					</s:form>
				</td>
			</tr>
		</table>
	</body>
</html>