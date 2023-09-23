package com.Mybank.EasyFinance.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Mybank.EasyFinance.models.Account;
import com.Mybank.EasyFinance.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

//	@Query(value = "SELECT * FROM transaction", nativeQuery = true)	
//	public ArrayList<ArrayList<String>> getTransactionHistory();
	
	@Query(value = "SELECT * FROM transaction WHERE account_number_reciever = :accountNumber OR account_number_sender=:accountNumber", nativeQuery = true)
    public ArrayList<Transaction> getTransactionHistoryByAccountNumber (@Param("accountNumber")String accountNumber);
	
	
	
}
