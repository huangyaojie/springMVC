<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/css/webuploader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/examples/cropper/cropper.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/examples/cropper/style.css" />
</head>
<body>
	<div id="wrapper">
		<div class="uploader-container">
			<div id="filePicker">选择文件</div>
		</div>

		<!-- Croper container -->
		<div class="cropper-wraper webuploader-element-invisible">
			<div class="img-container">
				<img src="" alt="" />
			</div>
			<div class="upload-btn">上传所选区域</div>
			<div class="img-preview"></div>
		</div>

	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/examples/cropper/jquery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/dist/webuploader.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/examples/cropper/cropper.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/webuploader/webuploader-0.1.5/examples/cropper/uploader.js"></script>
</body>
</html>