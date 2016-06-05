<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/register.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-select.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-datetimepicker.css" />

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Debt</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" method="post" action="#">
					<form:form method="POST" action="createDebt" modelAttribute="debt">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label"> To
								Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:select id="toUsernameSelectPickerId" path="toUsername"
										cssClass="form-control"></form:select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label"> From
								Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:select id="fromUsernameSelectPickerId"
										path="fromUsername" cssClass="form-control"></form:select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label"> Value</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:input path="value" placeholder="Enter Value"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">
								Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:input path="description" placeholder="Enter Description"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label"> Date</label>
							<div class="cols-sm-10">

								<div class='input-group date' id='datetimepicker1'>
									<span class="input-group-addon"> <i
										class="fa fa-calendar fa" aria-hidden="true"></i>
									</span>
									<form:input path="date" placeholder="Select Date"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<input type="submit" name="createDebt" value="Create"
								class="login-button btn btn-primary btn-lg btn-block  ">
						</div>
						<div class="form-group ">
							<input type="submit" name="goToDebts" value="Back"
								class="login-button btn btn-primary btn-lg btn-block login-button">
						</div>
					</form:form>
				</form>
			</div>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/debt.js"></script>

</body>
</html>