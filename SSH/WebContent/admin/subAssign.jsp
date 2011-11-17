<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生课题分配信息-分配</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">管理员分配课题页面</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<STRONG><FONT color=#ffffff>提示信息：</FONT> </STRONG>&nbsp;
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								<font color=slategray>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以为学生分配任意导师的课题，但此课题必须未被分配，即一人一题。<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生的预选信息供参考，最后一栏课题分配情况表示该课题是否已经被分配给学生，不特指分配给该学生。<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分配成功后将把该生的分配标志记录为管理员分配。</font>
								<hr SIZE="3">
								<font color="ff6600"> <s:actionerror /> </font>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<s:form action="assignSubject" namespace="/admin" method="post">
						<table align="center">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									学生学号：
								</td>
								<td>
									<s:textfield size="32" value="%{student.studentno}" name="studentno"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									学生姓名：
								</td>
								<td>
									<s:textfield size="32" value="%{student.name}" readonly="true" />
								</td>
							</tr>
							
							<tr valign="middle">
							<s:doubleselect label="指导老师" labelSeparator="课程名称" name="teacherno" list="teacher" listKey="teacherno" listValue="name" 
								doubleName="thesisno" doubleList="map.get(top.teacherno)"
									doubleListKey="thesisno" doubleListValue="name"></s:doubleselect>

							</tr>
							<tr valign="baseline">
								<td>
									<s:submit value="确定"
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; 
		            BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
									</s:submit>
								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>

			<tr>
				<td valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">该生的预选课题信息：</font>
					<center>
						<table CELLSPACING="2" CELLPADDING="5" BORDER="0">
							<TR>
								<TD width="95" ALIGN="center" class="tableHeading">
									志愿顺序
								</TD>
								<TD width="300" ALIGN="center" class="tableHeading">
									预选课题名称
								</TD>
								<TD width="115" ALIGN="center" class="tableHeading">
									指导老师
								</TD>
								<TD width="115" ALIGN="center" class="tableHeading">
									课题分配情况
								</TD>
							</TR>

							<s:iterator value="previews" var="preview" status="st">
								<tr bgcolor="#dcdcdc">
									<td align="center">
										<s:property value="suborder" />
									</td>
									<td align="center">
										<s:property value="thesis.name" />
									</td>
									<td align="center">
										<s:property value="thesis.teacher.name" />
									</td>
									<td align="center">
										<s:property value="thesis.assigned" />
									</td>
								</tr>
							</s:iterator>
						</TABLE>
		</center>
		</td>
		</tr>
		</table>
		
		<center>
			<br>
			<A HREF="admin/subAssignInfo.action">返回</A>
		</center>
	</body>
</html>


