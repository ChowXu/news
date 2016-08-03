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
<title>Cumt &mdash; ä»»å¡å</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<!-- Themify Icons -->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Owl Carousel -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Superfish -->
<link rel="stylesheet" href="css/superfish.css">
<!-- Easy Responsive Tabs -->
<link rel="stylesheet" href="css/easy-responsive-tabs.css">
<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Theme Style -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
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

			<!-- START #fh5co-logo            -------------------------            logo-->
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
					<li class="fh5co-special"><botton>
						<a href="Login.html">登录/注册</a></botton></li>
				</ul>
			</nav>
			<!-- </div> -->

		</div>
	</header>


	<div id="fh5co-hero">
		<a href="#fh5co-main"
			class="smoothscroll fh5co-arrow to-animate hero-animate-4"><i
			class="ti-angle-down"></i></a>
		<!-- End fh5co-arrow -->
		<div class="container">
			<div class="col-md-8 col-md-offset-2">
				<div class="fh5co-hero-wrap">
					<div class="fh5co-hero-intro">
						<h1 class="to-animate hero-animate-1">拼车区</h1>
						<h2 class="to-animate hero-animate-2"></h2>
						<p class="to-animate hero-animate-3">
							<a href="ReleaseActivity.html" class="btn btn-outline btn-lg"></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<form class="bs-example bs-example-form" role="form">

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

			<tbody id="body">
			//
				<s:iterator value="#session.activity_list" var="act">
					<tr>
					<td><s:property value="#act.name" /></td>
					<td><s:property value="#act.tele" /></td>
					<td><S:property value="#act.description" /></td>
					</tr>


				</s:iterator>
			</tbody>
			

		</table>
		
	</div>
	
	


	<div style="height:300px"></div>
	<s:debug></s:debug>
	<!--[if IE]>
			
		<![endif]-->
	<!-- jQuery -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.js"></script>
	<!-- Owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Easy Responsive Tabs -->
	<script src="js/easyResponsiveTabs.js"></script>
	<!-- FastClick for Mobile/Tablets -->
	<script src="js/fastclick.js"></script>

	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	


	<script src="js/main.js"></script>





</body>

</html>