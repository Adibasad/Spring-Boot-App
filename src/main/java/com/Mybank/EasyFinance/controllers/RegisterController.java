package com.Mybank.EasyFinance.controllers;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Mybank.EasyFinance.helpers.AccountHelper;
import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.AccountRepository;
import com.Mybank.EasyFinance.repository.UserRepository;

@RestController
public class RegisterController {
	
	   @Autowired
	   private UserRepository userRepository;
	   
	   @Autowired
	   private AccountRepository accountRepository;

	   @GetMapping("/Registration")
	    public ModelAndView getRegistration(){
	        ModelAndView getRegPage = new ModelAndView("Registration");
	        System.out.println("In Registration Controller");
	        return getRegPage;
	    }

	    @PostMapping("/Registration")
	    public ModelAndView register( User userr,BindingResult result,@RequestParam("city") String city,@RequestParam("confirm_password") String confirm_password)
	    {
            
	    	System.out.println("In Reg Post Mapping");
	        ModelAndView registrationPage = new ModelAndView("Registration");
	        
	        
	        //CHECK IF USER ALREADY EXISTS BY EMAIL
	        if(userRepository.getUserEmail(userr.getEmail())!=null)
	        {
	        	registrationPage.addObject("message", "This Email is already registered,Try Logging In!");
	            return registrationPage;
	        }
	        
	        //NEW USER ACCOUNT
	        userr.setUserStatus("ACTIVE");
	        userr.setAddress(userr.getAddress()+","+city);
            
	        //CHECK IF ALL REQUIRED FEILDS ARE NOT NULL
	        String [] str_arr= userr.toString().trim().split(",");
	        
	        if(result.hasErrors() || str_arr.length<11)
	        {
	            registrationPage.addObject("message","All the fields marked '*' are required!!");
	            System.out.println(registrationPage);
	            return registrationPage;
	        }
	        
	        // CHECK FOR PASSWORD MATCH:
	        if(!userr.getUserPassword().equals(confirm_password)){
	            registrationPage.addObject("message", "Confirm password and Password must match!");
	            return registrationPage;
	        }
	        
	        // HASH PASSWORD:
	        String hashed_password = BCrypt.hashpw(userr.getUserPassword(), BCrypt.gensalt());
	        userr.setUserPassword(hashed_password);

	        //CREATE A NEW ACCOUNT:
	        Account newAcc =AccountHelper.createNewAccount(userr);
	        
	        //REGISTER USER
	        userr.setAccount(newAcc);
	        User savedUser = userRepository.save(userr);
	        
//	        System.out.println(savedUser.getId());
//	        System.out.println(newAcc);

	        // RETURN TO LOGIN PAGE
	        registrationPage.addObject("congrats", "Congratulations!!");
	        String successMessage = "Account Registered Successfully, Please Login to Continue!";
	        registrationPage.addObject("success", successMessage);
	        System.out.println(registrationPage);
	        return registrationPage;
	    }
}

