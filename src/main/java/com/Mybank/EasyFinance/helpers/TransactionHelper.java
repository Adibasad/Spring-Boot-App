package com.Mybank.EasyFinance.helpers;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.Transaction;

@Service
public class TransactionHelper {
	
	public static Transaction lognewTransaction(Account sender,Account reciever,BigInteger amount)
	{
		Transaction newLog=new Transaction();
		newLog.setAccountNameOfReciever(reciever.getAccountName());
		newLog.setAccountNameOfSender(sender.getAccountName());
		newLog.setAccountNumberReciever(reciever.getAccountNumber());
		newLog.setAccountNumberSender(sender.getAccountNumber());
		newLog.setTranferedAmount(amount);
		newLog.setTransactionType("EXTERNAL ");
				
		return newLog;
	}
	
	public static Transaction lognewWithdrwal(Account sender,BigInteger amount)
	{
		Transaction newLog=new Transaction();
		newLog.setAccountNameOfReciever("self*");
		newLog.setAccountNameOfSender(sender.getAccountName());
		newLog.setAccountNumberReciever(sender.getAccountNumber());
		newLog.setAccountNumberSender(sender.getAccountNumber());
		newLog.setTranferedAmount(amount);
		newLog.setTransactionType("INTERNAL-WITHDRAWL");
				
		return newLog;
	}
	
	public static Transaction lognewDeposit(Account sender,BigInteger amount)
	{
		Transaction newLog=new Transaction();
		newLog.setAccountNameOfReciever("self*");
		newLog.setAccountNameOfSender(sender.getAccountName());
		newLog.setAccountNumberReciever(sender.getAccountNumber());
		newLog.setAccountNumberSender(sender.getAccountNumber());
		newLog.setTranferedAmount(amount);
		newLog.setTransactionType("INTERNAL-DEPOSIT");
				
		return newLog;
	}

}
