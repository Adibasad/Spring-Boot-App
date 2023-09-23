package com.Mybank.EasyFinance.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Mybank.EasyFinance.helpers.TransactionHelper;
import com.Mybank.EasyFinance.models.*;
import com.Mybank.EasyFinance.repository.*;

import javax.servlet.http.HttpSession;

@RestController
public class TransactionController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	
	@GetMapping("/transaction")
    public ModelAndView getTransaction() {
        ModelAndView getTransactionPage = new ModelAndView("transaction");
        System.out.println("In Transaction Controller");
        return getTransactionPage;
    }
	
	@PostMapping("/transaction")
    public ModelAndView getTransactionPost(@RequestParam("accountName") String accountName,@RequestParam("accountNumber") String accountNumber,
    		                   @RequestParam("transactionAmount") BigInteger transactAmount,HttpSession session) {
        ModelAndView getTransactionPage = new ModelAndView("transaction");
        
        
        int accNum=Integer.parseInt(accountNumber);
        System.out.println(accountName+" "+accountNumber+" "+transactAmount);
       
        
     //  CHECK FOR EMPTY STRINGS:
        if(transactAmount== null | accountName.isEmpty() || accountNumber.isEmpty() ){
        	getTransactionPage.addObject("message", "Deposit Amount or Account Depositing to Cannot Be Empty!");      	
            return getTransactionPage;
        }
        
        
        
        // TODO GET LOGGED IN USER:
        User user = (User)session.getAttribute("user");
      //TODO IF PAGE IS REFRESHED
        if(user==null) {
        	getTransactionPage.addObject("message", "SESSION IS EXPIRED!Please Login again.");      	
            return getTransactionPage;       
        }
        
        Account accountSender = user.getAccount();
        
        
     // TODO GET THE USER AMOUNT IS BEING CREDITED TO:
        Long accountIdReciever = (Long)accountRepository.getAccountIdByAccountNumber(accountNumber);
        Account accountReciever= accountRepository.getAccount(accountIdReciever);
        
      //TODO CHECK IF SENDER AND RECIEVER ARE NOT THE SAME ACCOUNT
        if(accountIdReciever==accountSender.getId())
        {
        	getTransactionPage.addObject("message", "SENDER ACCOUNT AND RECIEVER ACCOUNT MUST BE DIFFRENTs");      	
            return getTransactionPage;
        }
        
        
        System.out.println(accountSender);
        System.out.println(accountReciever);
        
        //CHECK IF ACCOUNT NUMBER AND NAME MATCH
        if(accNum!=accountRepository.getAccountNumberByAccountName(accountName))
        {
        	getTransactionPage.addObject("message", "Account Name OR Account Number is Incorrect!");      	
            return getTransactionPage;
        }
        
     // TODO: GET CURRENT ACCOUNT BALANCE:
        BigInteger currAccountBalanceOfSender=accountSender.getAccountBalance();
        BigInteger currAccountBalanceOfReciever=accountReciever.getAccountBalance();
        
        //TODO:INSUFFICIENT BALANCE CHECK
        if(currAccountBalanceOfSender.compareTo(transactAmount)==-1)
        {
        	getTransactionPage.addObject("message", "INSUFFICIENT ACCOUNT BALANCE!");      	
            return getTransactionPage;
        }
        
//        //TODO: CHECK IF DEPOSIT AMOUNT IS 0 (ZERO):
        if(transactAmount.equals(BigInteger.ZERO)){
        	getTransactionPage.addObject("message", "Deposit Amount Cannot be Zero!");      	
            return getTransactionPage;
        }

        
         //TODO: UPDATE BALANCE IN SENDER AND RECIEVER ACCOUNT:
         accountRepository.setAccountBalance(accountSender.getId(), currAccountBalanceOfSender.subtract(transactAmount));
         accountRepository.setAccountBalance(accountIdReciever, currAccountBalanceOfReciever.add(transactAmount));


        // Log Successful Transaction:
         Transaction newLog=TransactionHelper.lognewTransaction(accountSender, accountReciever ,transactAmount);
         transactionRepository.save(newLog);
         
        
        System.out.println("In Transaction Post Controller");
        getTransactionPage.addObject("message", "Transaction is Successfull!");     
        return getTransactionPage;
    }
	
	

}
