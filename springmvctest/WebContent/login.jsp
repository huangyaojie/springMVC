<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<title>欢迎来到登录页面</title>
</head>
<body>
	<div>
		<ul>
			<li><a href="items/queryItems.action">itemList.jsp</a></li>
             <li><a href="uploader/webUploaderCropper.action">WebUploader演示 - 带裁剪功能</a></li>
             <li>  <button id="btn1">测试多个click事件的执行顺序</button></li>
		</ul>
	</div>

	<p>中文显示是否乱码</p>
	<p>げんこう</p>
</body>
<script>
var groupsName="全体技能组";
var flag=0;
<%-- window.location.href =
	        encodeURI("<%=path%>/
			CustomersServletmethod=service_95518_telephone&provinceCode="+provinceCode+
			"&cityCode="+cityCode+"&startdate="+startdate+"&enddate="+enddate+"&groupsName="
			+groupsName+"&type="+type); --%>
			$("#btn1").click(function(){
				alert("事件1");
			});
			$("#btn1").click(function(){
				if(flag==1){
				alert("事件2");
				}else{
					flag=3;
				}

			});
			$("#btn1").click(function(){
				alert("事件3");
				flag=1;
			});
			$("#btn1").click(function(){
				if(flag==3){
				alert("事件4");
				}
			});
</script>

</html>