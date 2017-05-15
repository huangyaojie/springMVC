<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body>
	<form id="itemForm"  modelAttribute="ItemsCustom" action="${pageContext.request.contextPath }/items/editItemSubmit.action"  method="post">
		<input type="hidden" name="itemId " value="${id}" /> 修改商品信息：
		<table width="100%" border=1>
			<thead>
				<tr class="text-c">
					<th width="20">商品名称</th>
					<th width="20">商品价格</th>
					<th width="20">商品brand</th>
					<th width="150">商品生产日期</th>
					<th width="60">商品简介</th>
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody id="tab">
				<tr>
					<td><input type="text" name="itemName"
						value="${ItemsCustom.itemName}" /></td>
					<td><input type="text" name="itemPrice"
						value="${ItemsCustom.itemPrice}" /></td>
					<td><input type="text" name="itemBrand"
						value="${ItemsCustom.itemBrand}" /></td>
					<td><input type="text" name="itemCreateTime"
						value="<fmt:formatDate value="${ItemsCustom.itemCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
					<td><textarea rows="3" cols="30" name="itemDetail">${ItemsCustom.itemDetail}</textarea></td>
					<td colspan="2" align="center"><input type="submit" value="修改" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>

</html>