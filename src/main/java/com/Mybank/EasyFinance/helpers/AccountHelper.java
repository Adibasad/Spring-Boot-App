package com.Mybank.EasyFinance.helpers;

import java.math.BigInteger;
import java.util.Random;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.Transaction;
import com.Mybank.EasyFinance.models.User;
import com.Mybank.EasyFinance.repository.UserRepository;


/**
 * @author ADIBA SADAF
 *
 */
public class AccountHelper{

	public static String generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 1000;
        accountNumber = bound * random.nextInt(bound);
        return Integer.toString(accountNumber);
    }
	
	public static Account createNewAccount(User user)
    {
    	Account newAcc= new Account();
//    	User temp_user=userRep.
//    	newAcc.setId(userRep.getBy);
    	newAcc.setAccountNumber(generateAccountNumber());
    	newAcc.setAccountBalance(BigInteger.ZERO);;
    	newAcc.setAccountName(user.getFirstName()+" "+user.getLastName());
    	newAcc.setStatus(user.userStatus);
    	return newAcc;	
    }
	
	
	
}
