package com.Mybank.EasyFinance.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Mybank.EasyFinance.helpers.TransactionHelper;
import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.Transaction;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.AccountRepository;
import com.Mybank.EasyFinance.repository.TransactionRepository;
import javax.servlet.http.HttpSession;

@RestController
public class SelfTransactionController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("/selfTransactionWithdraw")
    public ModelAndView getWithdraw(javax.servlet.http.HttpSession session) {
		System.out.println("In selfTransactionWithdraw Controller");
		User user = (User)session.getAttribute("user");
        ModelAndView getTransactionPage = new ModelAndView("withdraw");
        
        if(user==null) {
        	getTransactionPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getTransactionPage;       
        }
        
        return getTransactionPage;
    }
	
	@GetMapping("/selfTransactionDeposit")
    public ModelAndView getDeposit(HttpSession session) {
		System.out.println("In selfTransactionDeposit Controller");
		User user = (User)session.getAttribute("user");
        ModelAndView getTransactionPage = new ModelAndView("deposit");
        
        if(user==null) {
        	getTransactionPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getTransactionPage;       
        }
        
        return getTransactionPage;
    }
	
	
	
	@GetMapping("/selfTransactionWithdraw-post")
    public ModelAndView getWithdrawPost(@RequestParam("transactionAmount") BigInteger transactAmount,HttpSession session) {
        ModelAndView getTransactionPage = new ModelAndView("withdraw");
        
        
        System.out.println(transactAmount);
       
        
       //  CHECK FOR EMPTY STRINGS:
        if(transactAmount== null ){
        	getTransactionPage.addObject("message", "Withdraw Amount Cannot Be Empty!");      	
            return getTransactionPage;
        }
        
        // TODO GET LOGGED IN USER:
        User user = (User)session.getAttribute("user");
      //TODO IF PAGE IS REFRESHED
        if(user==null) {
        	getTransactionPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getTransactionPage;       
        }
        
        Account account = user.getAccount();
        BigInteger currAccountBalance=account.getAccountBalance();
        
        //TODO:INSUFFICIENT BALANCE CHECK
        if(currAccountBalance.compareTo(transactAmount)==-1)
        {
        	getTransactionPage.addObject("message", "INSUFFICIENT ACCOUNT BALANCE!");      	
            return getTransactionPage;
        }
        
        //TODO: CHECK IF DEPOSIT AMOUNT IS 0 (ZERO):
        if(transactAmount.equals(BigInteger.ZERO)){
        	getTransactionPage.addObject("message", "Withdraw Amount Cannot be Zero!");      	
            return getTransactionPage;
        }

        
         //TODO: UPDATE BALANCE IN SENDER AND RECIEVER ACCOUNT:
         accountRepository.setAccountBalance(account.getId(), currAccountBalance.subtract(transactAmount));


        // Log Successful Transaction:
         Transaction newLog=TransactionHelper.lognewWithdrwal(account,transactAmount);
         
         transactionRepository.save(newLog);
         
        
        System.out.println("In Withdraw Post Controller");
        getTransactionPage.addObject("message", "Withdraw is Successfull!");     
        return getTransactionPage;
    }
	
	@GetMapping("/selfTransactionDeposit-post")
    public ModelAndView getDepositPost(@RequestParam("transactionAmount") BigInteger transactAmount,HttpSession session) {
        ModelAndView getTransactionPage = new ModelAndView("deposit");
        
       
        
       //  CHECK FOR EMPTY STRINGS:
        if(transactAmount== null ){
        	getTransactionPage.addObject("message", "Withdraw Amount Cannot Be Empty!");      	
            return getTransactionPage;
        }
        
        // TODO GET LOGGED IN USER:
        User user = (User)session.getAttribute("user");
      //TODO IF PAGE IS REFRESHED
        if(user==null) {
        	getTransactionPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getTransactionPage;       
        }
        
        Account account = user.getAccount();
        BigInteger currAccountBalance=account.getAccountBalance();
        
        
        //TODO: CHECK IF DEPOSIT AMOUNT IS 0 (ZERO):
        if(transactAmount.equals(BigInteger.ZERO)){
        	getTransactionPage.addObject("message", "Deposit Amount Cannot be Zero!");      	
            return getTransactionPage;
        }
        
        //GET NEW BALANCE
        BigInteger newBalance= currAccountBalance.add(transactAmount);
        Long acc_Id=account.getId();
        

        System.out.println(account.getId()+" "+currAccountBalance.add(transactAmount));
         //TODO: UPDATE BALANCE IN SENDER AND RECIEVER ACCOUNT:
         accountRepository.setAccountBalance(acc_Id, newBalance);

        
        // Log Successful Transaction:
         Transaction newLog=TransactionHelper.lognewWithdrwal(account,transactAmount);
         System.out.println(newLog);
         transactionRepository.save(newLog);
         
        
        System.out.println("In Withdraw Post Controller");
        getTransactionPage.addObject("message", "Withdraw is Successfull!");     
        return getTransactionPage;
    }
	
	


}
