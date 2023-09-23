package com.Mybank.EasyFinance.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.UserRepository;



@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
    //login
    public ModelAndView getLogin(){
        ModelAndView getLoginPage = new ModelAndView("login");
        getLoginPage.addObject("PageTitle", "EasyFinance-Login");
        System.out.println(getLoginPage);
        System.out.println("In Login Controller");
        return getLoginPage;
    }
 
 
	//POST LOGIN
    @PostMapping("/")
    public ModelAndView get(@RequestParam("email") String email,@RequestParam("password") String password,javax.servlet.http.HttpSession session){
        ModelAndView getLoginPage = new ModelAndView("login");
  
//        getHomePage.addObject("PageTitle", "Home");
     System.out.println(email+" "+password);
     //VALIDATE INPUT FIELDS / FORM DATA:
        if(email.isEmpty() || email == null || password.isEmpty() || password == null){
            getLoginPage.addObject("error", "Username or Password Cannot be Empty");
            return getLoginPage;
        }

        //CHECK IF EMAIL EXISTS:
        String getEmailInDatabase = userRepository.getUserEmail(email);
        
        

        if(getEmailInDatabase != null ){
        	
            // Get Password In Database:
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);

            // Validate Password and email:
            if(!BCrypt.checkpw(password, getPasswordInDatabase)){
                getLoginPage.addObject("error", "Incorrect Username or Password");
                return getLoginPage;
            }
            // End Of Validate Password.
            
        }
        //If Email Not Found
        else{
        	getLoginPage.addObject("error", "Incorrect Username or Password!!");
            return getLoginPage;
        }
        
        ModelAndView getHomePage = new ModelAndView("Home");
        
     // PROCEED TO LOG THE USER IN:
        User user = userRepository.getUserDetails(getEmailInDatabase);
        Account account=user.getAccount();
//        System.out.println(user.getAccount());

        // Set Session Attributes:
        session.setAttribute("user", user);
        session.setAttribute("account", account);
//        System.out.println("In Login-Post Controller");
//        System.out.println(user.getEmail());
        return getHomePage;
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/";
    }

}
