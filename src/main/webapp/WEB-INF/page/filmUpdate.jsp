<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影片编辑页面</title>
<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${path }/css/update.css" />
</head>
<body>
	<div class="container">
		<div id="update">
			<form id="saveForm" action="${path}/student/saveStudent" method="post"
				class="form-horizontal" role="form">
				<fieldset>
					<legend>新增影片信息</legend>
					<input type="hidden" value="${film.id }" name="id">
					<div class="form-group">
						<label for="filmCode" class="col-md-3 control-label">影片编号</label>
						<div class="col-md-6">
							<input type="text" name="filmcode" value="${film.filmcode }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="filmName" class="col-md-3 control-label">片名</label>
						<div class="col-md-6">
							<input type="text" name="filmname" value="${film.filmname }" class="form-control">
						</div>
					</div>
					<!--<div class="form-group">
							<label for="filmPic" class="col-md-3 control-label">谍照</label>
							<div class="col-md-6">
								<input type="file" name="file" value="" class="form-control">
							</div>
						</div>-->
					<div class="form-group">
						<label for="years" class="col-md-3 control-label">年代</label>
						<div class="col-md-6">
							<input type="text" name="years" value="${film.years }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="types" class="col-md-3 control-label">类别</label>
						<div class="col-md-6">
							<input type="text" name="type" value="${film.type }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="language" class="col-md-3 control-label">语言</label>
						<div class="col-md-6">
							<input type="text" name="language" value="${film.language }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="caption" class="col-md-3 control-label">字幕</label>
						<div class="col-md-6">
							<input type="text" name="captions" value="${film.captions }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="director" class="col-md-3 control-label">导演</label>
						<div class="col-md-6">
							<input type="text" name="director" value="${film.director }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="actors" class="col-md-3 control-label">演员</label>
						<div class="col-md-6">
							<input type="text" name="actor" value="${film.actor }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="releaseTime" class="col-md-3 control-label">上映时间</label>
						<div class="col-md-6">
							<input type="text" name="showtime" value="${film.showtime }"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="playRoom" class="col-md-3 control-label">播放影厅</label>
						<div class="col-md-6">
							<input type="text" name="playhall" value="${film.playhall }" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div>
							<div class="form-group has-feedback">
								<label for="playTime" class="col-md-3 control-label">播放时间</label>
								<div class="col-md-6">
									<input name="playtime" value="${film.playtime }" type="text"
										class="form-control" id="datetimepicker"> <span
										class="glyphicon glyphicon-time form-control-feedback"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div>
							<div class="form-group has-feedback">
								<label for="remarks" class="col-md-3 control-label">简介</label>
								<div class="col-md-6">
									<textarea name="description" cols="50" rows="3">${film.description }</textarea>
								</div>
							</div>
						</div>
					</div>
					<!--<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">性别</label>
							<div class="col-md-1">
									<input type="radio" value="M" checked class="form-control" name="gender">
							</div>
							<label class="pull-left control-label">男</label>
							
							<div class="col-md-1">
								<input type="radio" value="F" class="form-control" name="gender">
							</div>
							<label class="pull-left control-label">女</label>
						</div>-->

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-warning" onclick="updateHandler()">保存</button>
							<button type="reset" class="btn btn-warning">重置</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	<!--引入js-->
	<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path }/js/moment.js"></script>
	<script type="text/javascript"
		src="${path }/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${path }/js/update.js"></script>
	<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
	<script type="text/javascript">
		function updateHandler() {
			var data = $("#saveForm").serialize();
			$.ajax({
				url : "${path }/film/update",
				data : data,
				type : "post",
				success : function(msg) {
					//判断是否登录成功
					if (msg == "true") {
						layer.alert('保存成功！', {
							icon : 1
						}, function(list) {
							window.location.href = "${path }/film/list";
							layer.close(list);
						});
						//return;
					} else {
						layer.alert('保存失败，请重新操作！', {
							icon : 2
						});
						//return false;
					} 
				}
			});
		}
	</script>
</body>
</html>