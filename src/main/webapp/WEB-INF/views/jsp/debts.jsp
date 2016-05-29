<%@page import="com.im.debtsmanagement.api.User"%>
<%@page
	import="com.im.debtsmanagement.apihelpers.DebtsManagementConstants"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Debts Management</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/home.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/debts.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-table.css" />

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
				<span class="card-title">Welcome <%=((User) request.getSession().getAttribute(DebtsManagementConstants.LOGGED_USER)).getFullName()%></span>

			</div>
		</div>
		<div class="navbar-wrapper">
			<nav class="navbar ">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"></button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="home.html" class="">Home</a></li>
							<li class="active"><a href="profile.html" class="">My
									profile</a></li>
							<li class="active"><a href="debts.html" class="">Debts</a></li>

						</ul>
						<ul class="nav navbar-nav pull-right">
							<li class=""><a href="<spring:url value="/logout.html"/>">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="debts-table">
			<table data-toggle="table" data-url="http://localhost:9000/DebtsManagementWeb/allDebts.json">
				<thead>
					<tr>
						<th data-field="id">Item ID</th>
						<th data-field="toUsername">To</th>
						<th data-field="fromUsername">From</th>
						<th data-field="value">Value</th>
						<th data-field="description">Description</th>
						<th data-field="date">Date</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-table.js"></script>

</body>
</html>