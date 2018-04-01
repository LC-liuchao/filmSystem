<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影片列表页</title>
<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
</head>
<body>
	<!--导航开始-->
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#example-navbar-collapse">
						<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">天悦电影城后台管理系统</a>
				</div>
				<div class="collapse navbar-collapse" id="example-navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="text-success">${username }</span></a></li>
						<!-- <li><a href="#"><span class="badge pull-right">"+count+"</span>在线人数</a></li>
							<li><a href="#"><span class="badge pull-right">"+totalCount+"</span>总访问量</a></li> -->
						<li><a href="${path }/user/login">安全退出</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!--导航结束-->
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">影片信息</a></li>
			<li><a href="#"><fmt:formatDate value="${date }"
						pattern="yyyy年" /></a></li>
			<li class="active"><fmt:formatDate value="${date }"
					pattern="MM月" /></li>
		</ol>
	</div>

	<!--查询开始-->
	<div class="container">
		<div>
			<form action="${path }/film/list"
				class="bs-example bs-example-form" role="form">
				<div class="row">
					<div class="col-md-3">
						<div class="input-group">
							<!-- <input type="hidden" id="filmname" name="film.filmname"> -->
							<input type="text" id="filmname" name="film.filmname"
								value="${filmVo.film.filmname }" placeholder="影片名称进行模糊查询"
								class="form-control"> <span class="input-group-btn">
								<input class="btn btn-default" type="button" onclick="queryPage()" value="查询">
							</span>
						</div>
					</div>
					<div class="col-md-4">
						<button class="btn btn-danger" type="button" onclick="delStu()">删除影片</button>
						<a href="${path }/film/preAdd" class="btn btn-info">添加影片</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--查询结束-->


	<!--列表主体开始-->
	<div id="filmData"></div>
	<!--列表主体结束-->


	<!-- 加载页面底部 -->
	<div class="container">
		<div class="row">
			<div class="row text-center">
				<div class="col-md-12">
					<span class="text-info">天智教育&reg; |&nbsp;</span> <span
						class="text-info">天悦在线电影后台系统 |&nbsp;</span> <span
						class="text-info">2002－2020 </span>
				</div>
			</div>
		</div>
	</div>
	<!-- 页面底部结束 -->
	<script type="text/javascript">
		function checkAll() {
			var flag = $("#ids").prop("checked");
			if (flag) {
				$(".hby").prop("checked", true);
			} else {
				$(".hby").prop("checked", false);
			}
		}
		function delStu() {
			layer.confirm('您确定要删除吗？', {
				btn : [ '是的', '不了' ]
			//按钮
			}, function() {
				var ids = "";
				for (var i = 0; i < $(".hby:checked").length; i++) {
					ids += $(".hby:checked:eq(" + i + ")").val() + ",";//s = "1,2,3"
				}
				ids = ids.substr(0, ids.length - 1);
				$.ajax({
					url : "${path }/film/delete",
					data : {
						"ids" : ids
					},
					type : "post",
					success : function(msg) {
						//判断是否删除成功
						if (msg == "true") {
							layer.msg('删除成功！', {
								icon : 1
							}, function() {
								window.location.href = "${path }/film/list";
								layer.close();
							});
							return;
						} else if (msg == "false") {
							layer.alert('删除失败，请重新删除！', {
								time : 2000,
							}, {
								icon : 2
							}, function(list) {
								window.location.href = "${path }/film/list";
								layer.close(list);
								return
							});
						}
					}
				});
			});
		}
		
		
		//加载数据(实现异步刷新)
		$(function(){
			$("#filmData").load("${path }/film/getFilmData");
		});
		
		function queryPage(page){
			var index = layer.load(1, {shade: false});
			$("#filmData").load("${path }/film/getFilmData",buildQuery(page),function(){
				layer.closeAll();
			});
		}
		
		function buildQuery(page){
			var query = {};
			query.page = typeof(page) == "undefined"?1:page;
			query.filmName = $("#filmname").val();
			return query;
		}
		
	</script>
</body>
</html>