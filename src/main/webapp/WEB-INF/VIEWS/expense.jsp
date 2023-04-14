<%@page import="com.accountmanager.entities.ExpenseCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

h1 {
	text-align: center;
	margin-top: 50px;
}

form {
	margin: auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
	width: 50%;
}

label {
	display: inline-block;
	margin-bottom: 10px;
	font-weight: bold;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

button[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

button[type=submit]:hover {
	background-color: #45a049;
}

.container {
	padding: 16px;
}

.row::after {
	content: "";
	clear: both;
	display: table;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>
	<h2 class="text-center mb-4">Add Expense</h2>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				
				<form action="addexpense" method="post">
					<div class="form-group">
						<label for="date">Date:</label> <input type="date"
							class="form-control" id="date" name="date" required>
					</div>
					<div class="form-group">
						<label for="category">Category:</label> <select
							class="form-control" id="category" name="category" required>
							<option value="" disabled selected>Select Category</option>
							<%
							List<ExpenseCategory> categories = (List<ExpenseCategory>) request.getAttribute("categories");
							for (ExpenseCategory category : categories) {
							%>
							<option value="<%=category.getId()%>"><%=category.getName()%></option>
							<%
							}
							%>

						</select>
					</div>
					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" id="name" name="name" required>
					</div>
					<div class="form-group">
						<label for="description">Description:</label>
						<textarea class="form-control" id="description" name="description"
							rows="3"></textarea>
					</div>
					<div class="form-group">
						<label for="amount">Amount:</label> <input type="number"
							class="form-control" id="amount" name="amount" required>
					</div>
					<div class="form-group">
						<label for="mode">Mode:</label> <select class="form-control"
							id="mode" name="mode" required>
							<option value="" disabled selected>Select Mode</option>
							<option value="Cash">Cash</option>
							<option value="Online">Online</option>
						</select>
					</div>
					<div class="form-group">
						<label for="transactionId">Transaction ID/Invoice No.:</label> <input
							type="text" class="form-control" id="transactionId"
							name="transactionId">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Add
						Expense</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
