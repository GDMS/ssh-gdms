<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>管理员-新增评语</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								新增评语页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="40px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入要新增的评语内容：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="pyDel" namespace="/admin"
															method="post">
															<table border="0px">
																<tr style="display:none">
																<td class="textfield_label">
																		评语编号:
																	</td>
																<td >
																		<s:textarea name="py.pyno" value="%{py.pyno}" readonly="true"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																	</td>
																</tr>
																<tr>
																	<td>
																		<table class="select">
																			<tr>
																				<td class="select_label">
																					评语等级:
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px; margin-left: -137px;">
																		<s:select list="#{'A':'A','B':'B','C':'C','D':'D'}"
																			name="py.lv" value="%{py.lv}"></s:select>
																	</td>
																</tr>
																
																<tr>
																	<td class="textfield_label">
																		指导评语:
																	</td>
																	<td>
																		<s:textarea name="py.zdpingyu" value="%{py.zdpingyu}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		评阅评语:
																	</td>
																	<td>
																		<s:textarea name="py.pypingyu" value="%{py.pypingyu}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		答辩评语:
																	</td>
																	<td>
																		<s:textarea name="py.dbpingyu" value="%{py.dbpingyu}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
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
								请留意，各项内容输入的字数应保持在150个汉字以内，包括空格以及标点。
								</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>
	</body>
</html>

