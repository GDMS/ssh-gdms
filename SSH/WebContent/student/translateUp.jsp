<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生-翻译资料提交</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								翻译资料提交页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="100px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请提交你的翻译资料：
													</td>
												</tr>
												<tr>
													<td id="box">
														<table>
															<tr>
																<td>
																	<s:form theme="simple" action="translateUp"
																		namespace="/student" method="post"
																		enctype="multipart/form-data">
																		<s:file theme="xhtml" name="file" label="翻译资料" />
																		<s:submit theme="xhtml" type="image" value="提交"
																			src="images/submit.png" />
																	</s:form>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td></td>
				<td id="cue" align="right">
					<table style="padding-top: 10px">
						<tr>
							<td class="tableHeading">
								系统提示:
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td class="tableInfo">
								请提交Word类型的文件。
								<br>
								&nbsp;且文件小于10M。
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="student/main.jsp">返回</A>
		</center>



	</body>
</html>

