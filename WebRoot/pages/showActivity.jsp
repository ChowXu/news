<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Assignment_CUMT</title>
<meta name="viewport" content="">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="FREEHTML5.CO" />


<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">


<!-- Superfish -->
<link rel="stylesheet" href="css/superfish.css">

<!-- Theme Style -->
<link rel="stylesheet" href="css/style.css">


<!-- FOR IE9 below -->
<!--[if lt IE 9]>
   <script src="js/respond.min.js"></script>
   <![endif]-->



</head>

<body>

	<!-- START #fh5co-header -->
	<header id="fh5co-header-section" role="header" class="">
		<div class="container">

			<!-- <div id="fh5co-menu-logo"> -->

			<!-- START #fh5co- logo-->
			<h1 id="fh5co-logo" class="pull-left">
				<a href="HomePage.html"><img src="images/logo.png"
					alt="CUMTASSIGNMENT"></a>
			</h1>

			<!-- START #fh5co-menu-wrap -->
			<nav id="fh5co-menu-wrap" role="navigation">

				<ul class="sf-menu" id="fh5co-primary-menu">
					<li class="active"><a href="index.html">首页</a></li>
					<li><a href="ReleaseActivity.html">任务区</a></li>
					<li><a href="ReleaseCarpool.html">拼车区</a></li>
					<li><a href="#">宣传推广及自助区</a></li>
					<li><a href="#">帮助</a></li>
					<li class="fh5co-special"><botton> <a
							href="Login.html">登录/注册</a></botton></li>
				</ul>
			</nav>
			<!-- </div> -->

		</div>
	</header>


	<div id="fh5co-hero">

		<!-- End fh5co-arrow -->
		<div class="container">
			<div class="col-md-8 col-md-offset-2">
				<div class="fh5co-hero-wrap">
					<div class="fh5co-hero-intro"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">


		<div class="col-lg-6">
			<div class="input-group">
				<input type="text" name="activity" class="form-control"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button">Search</button>
				</span>
			</div>

			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
	</form>
	</div>
	<div class="container">

		<table class="table table-hover" id="table">

			<thead>
				<tr>
					<th>活动</th>
					<th>描述</th>
					<th>电话</th>
				</tr>
			</thead>
			<br />



			<s:iterator value="#session.activity_list" var="act">
				<tr>
					<td><s:property value="#act.name" /></td>
					<td><s:property value="#act.description" /></td>
					<td><s:property value="#act.tele" /></td>
				</tr>
			</s:iterator>

		</table>

	</div>

	<div style="height:300px"></div>
	<s:debug></s:debug>
	<!--[if IE]>
			
		<![endif]-->
	

</body>

</html>