
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Insurance Policy Details...</h2>
		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="PlanName">-select-
                            <form:option value="">-select-</form:option>
							<form:options items="${names}"></form:options>
						</form:select>
					<td>Plan Status :</td>
					<td><form:select path="PlanStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}"></form:options>
						</form:select>
					<td>Gender :</td>
					<td><form:select path="Gender">
					        <form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">FeMale</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>start Date:</td>
					<td><form:input type="date" path="startDate"
							class="datepicker" date-date-format="mm/dd/yyyy" /></td>
					<td><form:input type="date" path="endDate"
							class="datepicker" date-date-format="mm/dd/yyyy" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="search"
						class="btn btn-primary" /></td>
				</tr>
				
				<tr>
				<td><a href ="/" class = "btn btn-secondary">Reset</a><td/>
				<tr/>
				
			</table>
		</form:form>
		<hr />
		<table class="table table-striped table=hover">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Name</th>
					<th>gender</th>
					<th>planName</th>
					<th>planStatus</th>
					<th>startDate</th>
					<th> endDate</th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
					    <td>${index.count}<td/>
						<td>${plan.id }</td>
						<td>${plan.name }</td>
						<td>${plan.gender }</td>
						<td>${plan.planName }</td>
						<td>${plan.planStatus }</td>
						<td>${plan.startDate}</td>
						<td>${plan.endDate }</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans}">
						<td colspan="11" style="text-align: center">No Records Found
						</td>
					</c:if>
				</tr>
			</tbody>
		</table>
		<hr />
		Export : <a href="excel" class = "btn-btn-primary">Excel</a>
		 <br></br> 
		         <a href="pdf" class = "btn-btn-primary">Pdf</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>
