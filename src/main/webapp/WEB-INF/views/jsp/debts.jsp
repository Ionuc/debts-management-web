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
		<div class="debts-buttons">
			<div class="left-button">
				<form:form method="POST">
					<div class="form-group ">
						<input type="submit" name="goToCreateDebt" value="Create Debt"
							class="login-button btn btn-primary btn-lg btn-block  ">
					</div>
				</form:form>
			</div>
			<div class="right-button">
				<form:form method="POST">
					<div class="form-group ">
						<input type="submit" name="goToCreateBill" value="Create Bill"
							class="login-button btn btn-primary btn-lg btn-block  ">
					</div>
				</form:form>
			</div>
		</div>

		<div class="debts-table">
			<table id="events-table" data-toggle="table"
				data-url=<spring:url value="allDebts.json"/> data-search="true"
				data-sortable="true" data-show-toggle="true"
				data-show-columns="true" data-pagination="true">
				<thead>
					<tr>
						<th data-sortable="true" data-field="id" data-visible="false">Id</th>
						<th data-sortable="true" data-field="toUsername">To</th>
						<th data-sortable="true" data-field="fromUsername">From</th>
						<th data-sortable="true" data-field="value">Value</th>
						<th data-sortable="true" data-field="description">Description</th>
						<th data-sortable="true" data-field="date">Date</th>
						<th data-field="operate" data-formatter="operateFormatter"
							data-events="operateEvents"></th>
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

	<script type="text/javascript">
		function operateFormatter(value, row, index) {
			var origin = window.location.origin
			var projectName = window.location.pathname.split("/")[1]
			var href = origin + '/' + projectName + '/removeDebt/' + row.id
			return [ '<a class="like" href="' + href +'" title="Pay Debt">',
					'Pay', '</a>' ].join('');
		}
	</script>
</body>
</html>