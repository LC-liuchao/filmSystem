<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登陆</title>
<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${path }/css/loginView.css" />
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<!--登陆begin-->
	<div id="login" class="container">
		<form id="loginForm"
			action="${pageContext.servletContext.contextPath }/user/login"
			class="form-horizontal" role="form" method="post">
			<fieldset>
				<legend>管理员登陆</legend>
				<div class="form-group has-feedback">
					<label for="firstname" class="col-md-2 control-label">用户名</label>
					<div class="col-md-5">
						<span class="glyphicon glyphicon-user form-control-feedback">
						</span> <input type="text" name="username" class="form-control"
							id="firstname" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group has-feedback">
					<label for="lastname" class="col-md-2 control-label">密码</label>
					<div class="col-md-5">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<input type="password" name="password" class="form-control"
							id="lastname" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox" name="cookie">请记住我
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="test1" class="btn btn-info" type="button"
							class="btn btn-default" onclick="loginHandler()">登录</button>
					</div>
				</div>
			</fieldset>
		</form>

		<%-- <input type="hidden" value="${hint }"> --%>
	</div>
	<!--登陆end-->
</body>
<script type="text/javascript"
	src="${path }/js/jquery-validator/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${path }/js/jquery-validator/messages_cn.js"></script>
<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
<script type="text/javascript">
	function loginHandler() {
		var data = $("#loginForm").serialize();
		$.ajax({
			url : "${path }/user/loginHandler",
			data : data,
			type : "post",
			success : function(msg) {
				//判断是否登录成功
				if (msg == "101") {
					layer.alert('登录成功！', {
						icon : 1
					}, function(list) {
						window.location.href = "${path }/film/list";
						layer.close(list);
					});
					return;
				} else if (msg == "102") {
					layer.alert('用户名或密码错误，请重新登录！', {
						icon : 2
					});
					return false;
				} else {
					layer.alert(msg);
					return false;
				}
			}
		});
	}
</script>
</html>
