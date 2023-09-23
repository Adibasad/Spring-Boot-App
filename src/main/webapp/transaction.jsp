<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="/css/transaction.css" rel="stylesheet"></link>
<title>Make Transaction</title>
</head>
<body>
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg d-flex align-item-center justify-content-between">
     
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <h3>EasyFinance</h3>
    
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Balance</a>
      </li>
            <li class="nav-item">
        <a class="nav-link " href="#">Transaction History</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="/logout">Sign Out</a>
      </li>
    </ul>
    
    </div>
  </nav>
            <!-- End Of Navigation -->
  <main role="main" class="container">
      <div class="jumbotron">          
        <form action="#" >
                   
                   <h1>Transfer Money</h1>
                   
                   <div class="bg-danger text-light font-weight-bold ">DO NOT REFRESH THE PAGE!!</div>
                   
                <div class="form-group row">
					<label for="staticEmail" class="col-sm-2 col-form-label h3">Account Name</label>
					<div class="col-sm-10">
						<input type="text" name="accountName" class="form-control"  placeholder="Enter The Account Name Of Recipient">
					</div>
					
				</div>   
                   
                   
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-2 col-form-label h3">Account Number</label>
					<div class="col-sm-10">
						<input type="text" name="accountNumber" class="form-control"  placeholder="Enter The Account Number Of Recipient">
					</div>
					
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-2 col-form-label h3">Amount</label>
					<div class="col-sm-10">
						<input type="number" name="transactionAmount" class="form-control"  placeholder="Amount">
					</div>
				</div>
				
				<!--ERROR MESSAGE  -->
				<div class="text-danger font-weight-bold bg-light">${requestScope.message}</div>
				
				 <button type="submit" formaction="/transaction" class="btn btn-outline-danger">Pay</button>

                  

       </form>
       
        </div>
    </main>

</body>
</html>