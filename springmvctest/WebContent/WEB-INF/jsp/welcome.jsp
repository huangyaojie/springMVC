<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 	src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<title>欢迎来到XXXX页面</title>
</head>
<body>
 <div id="errorShow">
     ${message}<br />

</div>

	<div>
	<form name="userForm"  action="login.action" method="post">
	<ul>
			<li><p>登录页面</p></li>
             <li>用户名： <input  type="text"    name="userName" ></li>
             <li>用户密码:  <input  type="text"    name="userPsd" ></li>
             <li>记住账号:  <input  type="checkbox"   name="autoLogin" value="true" checked = "checked" ></li>
             <li><input   type="submit"   value="登录"></li>
             <li><input   type="reset"      value="取消"></li>
		</ul>
	</form>
	</div>
	<c:out value="c:out"></c:out>
	<c:out value="${null}" default="default"></c:out>
	<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
  	<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>


</body>
<script>

</script>
</html>