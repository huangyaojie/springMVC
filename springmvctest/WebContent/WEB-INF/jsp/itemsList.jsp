<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<div id="showDiv"></div>
	<form  name="itemsForm"  action="${pageContext.request.contextPath}/items/queryItemByCond.action"  method="post">
	 查询条件：
	<table width="100%" border=1>
		<tr>
		<td><input type="submit" value="条件查询" /></td>
		<td><input id="showButton" type="button" value="动画效果" /></td>
		</tr>
	</table>
	<div>
	<input id="delete_items" type="button" value="删除" />
    <input id="update_items" type="button" value="批量更新" />
	</div>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<td>选择</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList }" var="item">
			<tr>
				<td><input type="checkbox" name="delete_id"  value="${item.itemId}"></td>
				<td>${item.itemName}</td>
				<td>${item.itemPrice}</td>
				<td><fmt:formatDate value="${item.itemCreateTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${item.itemDetail }</td>
				<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.itemId}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
<script>
	function showMessage(msg, delay) {
		$("#showDiv").html(msg);
		$("#showDiv").fadeIn();
		setTimeout(function() {
			$("#showDiv").fadeOut();
		}, Number(delay));
	}
	$("#showButton").click(function() {
		showMessage("修改完毕", 2000);
	});
	/* $("deleteButton")
			.click(
					function() {
						window.location.href = "{pageContext.request.contextPath}/items/deleteIds.action";
					}); */
	 $("#delete_items").click(function(){
		 document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";
		 document.itemsForm.submit();
	 });
	 $("#update_items").click(function(){
		 document.itemsForm.action="${pageContext.request.contextPath}/items/queryItemsToBatchUpdate.action";
		 document.itemsForm.submit();
		 });
</script>

</html>