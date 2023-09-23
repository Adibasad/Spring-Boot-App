<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="/css/details.css" rel="stylesheet"></link>
<title>Update User Details</title>
</head>
<body>

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
      
            <h1>Update Your Details</h1>
            
           <div class="bg-danger text-light font-weight-bold ">DO NOT REFRESH THE PAGE!!</div>
             <form action="/update">     
                <div class="form-group row">
                
                    <div class="col-sm-4">
						<label for="staticEmail" class=" col-form-label h3">New Account Name</label>
					</div>
					
					<div class="col-sm-4">
						<input type="text" name="accountName" class="form-control"  placeholder="Enter The Account Name Of Recipient">
						
					</div>
					
					<div class="col-sm-4">
					<button type="submit" formaction="/update" class="btn btn-success">Update</button>
					</div>
						
				</div>   
				
				 <div class="form-group row">
                
                    <div class="col-sm-4">
						<label for="staticEmail" class=" col-form-label h3">New Email</label>
					</div>
					
					<div class="col-sm-4">
						<input type="email" name="email" class="form-control"  placeholder="Enter New Email">
						
					</div>
					
					<div class="col-sm-4">
					<button type="submit" formaction="/updateDetails" class="btn btn-success">Update</button>
					</div>
						
				</div>
				
				 <div class="form-group row">
                
                    <div class="col-sm-4">
						<label for="staticEmail" class=" col-form-label h3">New Phone Number</label>
					</div>
					
					<div class="col-sm-4">
						<input type="text" min="10" max="10" name="phoneNumber" class="form-control"  placeholder="Enter New Phone Number">
						
					</div>
					
					<div class="col-sm-4">
					<button type="submit" formaction="/update" class="btn btn-success">Update</button>
					</div>
						
				</div>
				
				<h3>Update Password</h3>
				
				
				
				 <div class="form-group row">
                
                    <div class="col-sm-4">
						<label for="staticEmail" class=" col-form-label h3">Old Password</label>
					</div>
					
					<div class="col-sm-4">
						<input type="text" name="oldPassword" class="form-control"  placeholder="Enter New Phone Number">
						
					</div>
					
				</div>
				
				 <div class="form-group row">
                
                    <div class="col-sm-4">
						<label for="staticEmail" class=" col-form-label h3">New Password</label>
					</div>
					
					<div class="col-sm-4">
						<input type="text" name="newPassword" class="form-control"  placeholder="Enter New Phone Number">
						
					</div>
					
					<div class="col-sm-4">
					<button type="submit" formaction="/update" class="btn btn-success">Update</button>
					</div>
						
				</div>
                   
                
				
				<!--ERROR MESSAGE  -->
				<div class="text-danger font-weight-bold bg-light">${requestScope.message}</div>
		 </form> 
     
        </div>
       
     
    </main>

</body>
</html>