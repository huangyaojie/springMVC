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
<title>欢迎来到首页面</title>
</head>
<body>

	<div>
		<ul>
			<li><a href="items/queryItems.action">itemList.jsp</a></li>
             <li><a href="uploader/webUploaderCropper.action">WebUploader演示 - 带裁剪功能</a></li>
             <li>  <button id="btn1">测试多个click事件的执行顺序</button></li>
             <li><a href="json/toJsonTest.action">jsonTest.jsp</a></li>
              <li>  <input type="text" id="btn3"></li>
            <li>  <p>ssm test section </p></li>
               <li>  <p><a href="test/testimage.action">测试img里面的参数绑定 </p></li>

		</ul>
	</div>
	<p>中文显示是否乱码</p>
	<p>げんこう</p>
    <p><button id="btn5" type="button">测试文件 上传 </button></p>
	
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
			function m1(){
				alert("单击事件");
			}
			function m2(){
				alert("双击事件");
			};
			//定义setTimeout执行方法
			var TimeFn = null;
			$('#btn3').click(function () {
				// 取消上次延时未执行的方法
				clearTimeout(TimeFn);
				//执行延时
				TimeFn = setTimeout(function(){
					//do function在此处写单击事件要执行的代码
					m1();
					},3000);
				});
			$('#btn3').dblclick(function () {
						// 取消上次延时未执行的方法
						clearTimeout(TimeFn);
						//双击事件的执行代码
						m2();
						});
			$("#btn5").click(function(){
				window.location.href = "${pageContext.request.contextPath}/file/fileup";
			 });
</script>

</html>