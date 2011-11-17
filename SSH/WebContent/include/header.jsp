<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String pathHeader = request.getContextPath();
	String basePathHeader = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathHeader + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePathHeader%>">
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="4">
  <tr>
    <td width="235" rowspan="2" bgcolor="#353465"><IMG height=49 alt=Logo src="images/logo.jpg" width=235></td>
    <td width="100%" bgcolor="#353465"><div align="right"><font color="#ffffff"><b>The Graduate Design 
        Management System of DHU</b></font> 
        
        <!-- <object type="application/x-shockwave-flash" data="images/audio2.swf" id="audioplayer1" height="15" width="190">
	<param name="allowScriptAccess" value="sameDomain" />
	<param name="movie" value="images/audio2.swf" />
	<param name="FlashVars" value="playerID=1&soundFile=include/Beautiful thing.mp3&autoStart=no" />
	<param name="quality" value="high" />
	<param name="menu" value="false" />
	<param name="wmode" value="transparent" />
	</object>
	--> 
      </div></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="1" cellpadding="2">
        <tr>
          <td align="center" width="20%" bgcolor="#333366"><A href="index.jsp"><IMG height=25 src="images/7.jpg" width=120 border=0 name=Image6></A></td>
          <td align="center" width="20%" bgcolor="#333366"><A href="SLogin.jsp"><IMG height=25 src="images/1.jpg" width=120 border=0 name=Image3></A></td>
          <td align="center" width="20%" bgcolor="#353465"><A href="TLogin.jsp"><IMG height=25 src="images/3.jpg" width=120 border=0 name=Image4></A></td>
          <td align="center" width="20%" bgcolor="#333366"><A href="about.jsp"><IMG height=25 src="images/5.jpg" width=120 border=0 name=Image5></A></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>