<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生-查看课题相关信息</title>
		
	</head>

	<body>
	
		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">课题相关信息</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
				</td>
			</tr>
			<tr>
				<td height="405" valign="top">
					<p></p>
					<table width="617" border="0" cellspacing="2" cellpadding="4"
						style="WIDTH: 617px; HEIGHT: 53px">
						<tr class="tableHeading">
							<td width="200">
								<B><FONT COLOR="white">课题各项信息介绍：</FONT>
								</B>
							</td>


						</tr>
						<tr bgcolor="#dcdcdc">
							<td></td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<font color=slategray>指导教师已注册的课题当中包含题目类型，题目性质等信息，其中详细情况如下：</font>
								<P style="COLOR: slategray">
									&nbsp;&nbsp;&nbsp;&nbsp; 题目类型分为：
									<BR>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.设计类
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.软件设计类
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.课题研究类
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.其他类
								<P>
								<P>
								<P style="COLOR: slategray">
									&nbsp;&nbsp;&nbsp;&nbsp;题目性质分为：
									<BR>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.纵向课题
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;2.横向课题
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.自选课题
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.模拟课题
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.其他
								</P>

							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<center>
			<A href="student/main.jsp">返回</A>
		</center>
	</body>
</html>
