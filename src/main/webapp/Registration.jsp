<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/reg.css">
<title>Registration</title>
</head>
<body>

<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h4 class="alert-heading">Welcome!</h4>
                        <p>You are 30 seconds away from creating your own account!</p>
                        
                        <!-- Display Message --> 
                       <div class="alert alert-success text-center border border-success">
                       <h4>${requestScope.congrats}</h4>
                       <b>${requestScope.success}</b>
                       </div>
                          
                        <!-- End Of Display Message -->
                        <form action="/Registration" >
                        <input formaction="/" type="submit" name="" value="Login"/>
                                          
                        <br/>
                        
                    </div>
                    <div class="col-md-9 register-right">
                        
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">EasyFinance Bank Registration Form</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="firstName" placeholder="First Name *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="lastName" placeholder="Last Name *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="userPassword" placeholder="Password *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="confirm_password"  placeholder="Confirm Password *" value="" />
          
                                        </div>
                                        
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" placeholder="Your Email *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="phoneNumber" class="form-control" placeholder="Your Phone *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="30" name="address" class="form-control" placeholder="Your Address *" value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="text" minlength="5" maxlength="10" name="city" class="form-control" placeholder="Your City *" value="" />
                                        </div>
                                       
                                        
                                        <input type="submit" formaction="/Registration" class="btnRegister" value="Register"/>   
                                    </div>
                                    
                                     <div class="text-danger font-weight-bold">${requestScope.message}</div>
                                    </form>
                                </div>
                                
                            </div>
                    </div>
                </div>

            </div>
</body>
</html>