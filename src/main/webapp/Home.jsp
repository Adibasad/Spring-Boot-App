<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="/css/home.css" rel="stylesheet"></link>
<title>EasyFinance-Home</title>
</head>
<body>
<!-- Main Page Header -->

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
        <a class="nav-link" href="#">Transaction History</a>
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
        <h1>EasyFinance Bank</h1>
        <p class="lead">Your bank at your finger-tips.Made easy by EasyFinance bank.</p>
        <p>Welcome!${user.firstName}  ${user.lastName}</p>
        <form action="#" class="butt">
        <div><a class="btn btn-lg btn-primary" href="accountDetails.jsp" role="button">Account Details »</a></div>
        <div><button type="submit" formaction="/transaction" class="btn btn-lg btn-primary">Transfer Money »</button></div>
        <div><button type="submit" formaction="/selfTransactionWithdraw" class="btn btn-lg btn-primary">Withdraw Money »</button></div>
        <div><button type="submit" formaction="/selfTransactionDeposit" class="btn btn-lg btn-primary">Deposit Money »</button></div>
        <!-- <div ><a class="btn btn-lg btn-primary" href="transHistory" role="button">View Transaction History »</a></div>
          -->
       <div><button type="submit" formaction="/update" class="btn btn-lg btn-primary">Update Account Details »</button></div>
     
        </form>
       
      </div>
    </main>

           
    
</body>
</html>