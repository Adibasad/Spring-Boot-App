<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="/js/History.js" type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link href="/css/tran-hist.css" rel="stylesheet"></link>
<title>Transaction History</title>
</head>
<body>

	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg d-flex align-item-center justify-content-between">

		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<h3>EasyFinance</h3>

			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">Home
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Balance</a></li>
				<li class="nav-item"><a class="nav-link " href="#">Transaction
						History</a></li>
				<li class="nav-item"><a class="nav-link " href="/logout">Sign Out</a></li>
			</ul>

		</div>
	</nav>
	<!-- End Of Navigation -->


	<!--  -->
	<main role="main" class="container">
		<div class="jumbotron">
			<h1>Transaction History</h1>

			<span id="listOfList" style="display: none">${requestScope.}</span>

			<!--Table starts  -->
			<table class="table">
				<thead>
					<tr class="table-active">
						<th>Transaction ID</th>
						<th>Transaction Type</th>
						<th>Sender</th>
						<th>Receiver</th>
						<th>Amount</th>
						<th>Created at</th>
					</tr>
				</thead>


				<tbody>
					<!-- {foreach $requestScope.transactionHistory as $transactionHistory} -->
					<tr class="table-light" id="content">
						<th>10</th>

					</tr>
					<!--{/foreach } -->

				</tbody>
			</table>


		</div>
	</main>


	<!-- {foreach $colors as $color}
{$color}<br>

{/foreach} -->
	<script type="text/javascript">
		/*  let a=requestScope.get("transactionHistory");
		 */

		let arr = document.getElementById("listOfList");

		let table = document.getElementById("content");
		table.innerHTML = "<th>" + arr.toString + "</th>";
		table.innerHTML = span.outerHTML;
	</script>



</body>
</html>