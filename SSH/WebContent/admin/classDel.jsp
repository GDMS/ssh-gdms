<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>管理员-删除班级</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								删除班级
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
														请选择要删除的班级名称：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="classnoDel"
															namespace="/admin" method="post"
															onsubmit="return ValidateForm();">
															<table border="0px">
																<tr>
																	<td>
																		<table class="select">
																			<tr>
																				<td class="select_label" style="padding-top: 9px">
																					专业：
																				</td>
																			</tr>
																			<tr>
																				<td class="select_label" style="padding-top: 5px">
																					班级：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td>
																		<s:doubleselect cssClass="select2" name="majorno" list="majors"
																			listKey="majorno" listValue="name"
																			doubleName="classno"
																			doubleList="classname.get(top.majorno)"
																			doubleListKey="classno" doubleListValue="name"></s:doubleselect>
																	</td>
																</tr>
																<tr valign="baseline">
																	<td nowrap align="right">
																		&nbsp;
																		<br>
																	</td>
																	<td>
																		<s:submit theme="simple" type="image" value="提交"
																			src="images/submit.png" />
																		<br>
																	</td>
																</tr>
															</table>
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
								可以删除学院新开的班级。
								</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror />
								</font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/majorReg.jsp">返回</A>
		</center>
	</body>
</html>

