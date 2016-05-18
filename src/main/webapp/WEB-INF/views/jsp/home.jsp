<%@page import="com.im.debtsmanagement.api.User"%>
<%@page import="com.im.debtsmanagement.apihelpers.DebtsManagementConstants"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Debts Management</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/home.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
</head>

<body>

	<div class="navbar-wrapper">
		<div class="card hovercard">
			<div class="card-background">
				<img class="card-bkimg" alt=""
					src="http://lorempixel.com/100/100/people/9/">
			</div>
			<div class="useravatar">
				<img alt="" src="http://lorempixel.com/100/100/people/9/">
			</div>
			<div class="card-info">
				<span class="card-title"><%=((User)request.getSession().getAttribute(DebtsManagementConstants.LOGGED_USER)).getFullName()%></span>

			</div>
		</div>
		<div class="navbar-wrapper">
			<nav class="navbar ">
				<div class="container">
					<div class="navbar-header">
						
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#" class="">Home</a></li>
							<li class=" dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Departments <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li class=" dropdown"><a href="#" class="dropdown-toggle "
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">View Departments</a></li>
									<li><a href="#">Add New</a></li>
								</ul></li>
							<li><a href="#">Add New</a></li>
							<li class=" dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Managers <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">View Managers</a></li>
									<li><a href="#">Add New</a></li>
								</ul></li>
							<li class=" dropdown"><a href="#"
								class="dropdown-toggle active" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Staff
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">View Staff</a></li>
									<li><a href="#">Add New</a></li>
									<li><a href="#">Bulk Upload</a></li>
								</ul></li>
							<li class=" down"><a href="#" class="dropdown-toggle active"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">HR <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Change Time Entry</a></li>
									<li><a href="#">Report</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<li class=" dropdown"><a href="#"
								class="dropdown-toggle active" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Signed
									in as <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Change Password</a></li>
									<li><a href="#">My Profile</a></li>
								</ul></li>
							<li class=""><a href="#">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>
</html>