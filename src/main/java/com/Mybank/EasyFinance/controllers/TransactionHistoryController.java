package com.Mybank.EasyFinance.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.Transaction;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.TransactionRepository;
import javax.servlet.http.HttpSession;

@RestController
public class TransactionHistoryController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("/transHistory")
    public ModelAndView getHistoryPage(HttpSession session) {
		System.out.println("In transHistory Controller");
        ModelAndView getTranHisPage = new ModelAndView("transactionHistory");
        
        User user = (User)session.getAttribute("user");
        //TODO IF PAGE IS REFRESHED
          if(user==null) {
          	getTranHisPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
              return getTranHisPage;       
          }
          
        Account account=user.getAccount();
       
        
        //Fetch the transaction History Details
        ArrayList<Transaction> transactionHistoryArray= transactionRepository.getTransactionHistoryByAccountNumber(account.getAccountNumber());
        System.out.println(transactionHistoryArray);
        
        getTranHisPage.addObject("transactionHistory",transactionHistoryArray);
        
        return getTranHisPage;
    }
	
	

}
