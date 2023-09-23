package com.Mybank.EasyFinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.AccountRepository;
import com.Mybank.EasyFinance.repository.UserRepository;

@RestController
public class UpdateAccountDetailsController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/update")
    public ModelAndView getUpdate(HttpSession session) {
		System.out.println("In Update Controller");
		User user = (User)session.getAttribute("user");
		System.out.println(user);
        ModelAndView getUpdatePage = new ModelAndView("updateDetails");
        
        if(user==null) {
        	getUpdatePage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getUpdatePage;       
        }
        
        return getUpdatePage;
    }
	
	@PostMapping("/update")
    public ModelAndView postUpdate(HttpSession session,@RequestParam("accountName") String newName,@RequestParam("email") String newEmail,
    		       @RequestParam("phoneNumber") String newNumber,@RequestParam("oldPassword") String oldPassword,
    		       @RequestParam("newPassword") String newPassword) {
		System.out.println("In Update-post Controller");
		User user = (User)session.getAttribute("user");
        ModelAndView getUpdatePage = new ModelAndView("updateDetails");
        
        if(user==null) {
        	getUpdatePage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getUpdatePage;       
        }
        
        System.out.println(newEmail+" "+newName+" "+newPassword);
        
        Account account=user.getAccount();
        
        //TODO UPDATE NAME
        if(!newName.isEmpty()) {
        	
        	//update in user
        	String name[]=newName.trim().split(" ");
        	System.out.println(Arrays.toString(name));
        	String first_name=name[0];
        	String last_name=name[1];
        	userRepository.updateUserNameById(user.getId(), first_name, last_name);	
        	
        	//Update in account
        	accountRepository.updateAccountNameById(user.getId(), newName);
        }
        
      //TODO UPDATE NAME
        if(!newEmail.isEmpty()) {
        	userRepository.updateEmailById(user.getId(), newEmail);
        }
        
      //TODO UPDATE NAME
        if(!newNumber.isEmpty()) {
        	userRepository.updatePhoneNumberById(user.getId(), newNumber);
        }
        
        System.out.println(newPassword);
      //TODO UPDATE  PASSSWORD
        if(!newPassword.isEmpty()) {
        	
            // Get Password In Database:
            String getPasswordInDatabase = userRepository.getUserPassword(user.getEmail());

            // Validate Password and email:
            if(oldPassword==null || !BCrypt.checkpw(oldPassword, getPasswordInDatabase)){
            	getUpdatePage.addObject("message", "Old Password is INCORRECT!");
                return getUpdatePage;
            }
            
            // End Of Validate Password.
        	
         // HASH NEW PASSWORD:
	        String hashed_password = BCrypt.hashpw(newPassword, BCrypt.gensalt());
	        userRepository.updatePasswordById(user.getId(), hashed_password);
        }
        
        getUpdatePage.addObject("message", "UPDATE SUCCESSFULL!");
        return getUpdatePage;
    }

}
