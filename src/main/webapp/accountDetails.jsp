<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="/css/accDetail.css" rel="stylesheet"></link>
<title>Account Detail</title>
</head>
<body>
            <!-- Navigation -->
  <nav class="navbar navbar-expand-lg d-flex align-item-center justify-content-between">
     
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <h3>EasyFinance</h3>
    
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</a>
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
            
            
   <!--  -->
  <main role="main" class="container">
      <div class="jumbotron">
       <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
                    style="width: 185px;" alt="logo">
        <h1>Account Details</h1>
        
        <p class="font-weight-bold name">Name: <span> ${user.firstName}  ${user.lastName}</span></p> 
        <p class="font-weight-bold name">Account Number: <span> ${account.accountNumber} </span></p>
        <p class="font-weight-bold name">Email: <span> ${user.email}</span></p>
        <p class="font-weight-bold name">Phone No.: <span>${user.phoneNumber}</span></p>
        <p class="font-weight-bold name">Status: <span>${user.userStatus}</span></p>
        
        <p class="font-weight-bold name">Account Balance: <span> ${account.accountBalance}  Rupees </span></p>
     
        </div>
       
     
    </main>

 

</body>
</html>