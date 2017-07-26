<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品批量更新列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<div id="showDiv"></div>
	<form name="itemsForm"
		action="${pageContext.request.contextPath}/items/itemsListBatchUpdateSubmit.action"
		method="post">
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>选择</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
			</tr>
			<c:forEach items="${itemsList}" var="item" varStatus="s">
				<tr>
					<td><input type="checkbox" name="itemsList[${s.index}].itemId"
						value="${item.itemId}"></td>
					<td><input name="itemsList[${s.index}].itemName"
						value="${item.itemName}"></td>
					<td><input name="itemsList[${s.index}].itemPrice"
						value="${item.itemPrice}"></td>
					<td><input name="itemsList[${s.index}].itemCreateTime"
						value="<fmt:formatDate value="${item.itemCreateTime}"  pattern="yyyy-MM-dd HH:mm:ss" />"></td>
					<td><input name="itemsList[${s.index}].itemDetail"
						value="${item.itemDetail}"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="批量修改商品提交">
	</form>
</body>
<script>
</script>
</html>