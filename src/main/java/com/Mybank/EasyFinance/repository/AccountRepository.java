package com.Mybank.EasyFinance.repository;

import java.math.BigInteger;

//import org.springframework.data.jdbc.repository.query.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Mybank.EasyFinance.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query(value = "SELECT account_number FROM accounts WHERE account_name = :accountName", nativeQuery = true)	
	public int getAccountNumberByAccountName(@Param("accountName") String accountName);
	
	@Query(value = "SELECT acc_Id FROM accounts WHERE account_number = :accountNumber", nativeQuery = true)	
	public Long getAccountIdByAccountNumber(@Param("accountNumber") String accountNumber);
	
	@Query(value = "SELECT * FROM accounts WHERE acc_Id = :acc_Id", nativeQuery = true)	
	public Account getAccount(@Param("acc_Id") Long acc_Id);
	
	@Query(value = "SELECT accountBalance FROM accounts WHERE acc_Id = :acc_Id", nativeQuery = true)	
	public BigInteger getAccountBalance(@Param("acc_Id") Long acc_Id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE accounts SET account_balance= :new_balance WHERE acc_Id = :acc_Id", nativeQuery = true)	
	public void setAccountBalance(@Param("acc_Id") Long acc_Id, @Param("new_balance") BigInteger new_balance );
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE accounts SET account_name= :new_name WHERE acc_Id = :acc_Id", nativeQuery = true)	
	public void updateAccountNameById(@Param("acc_Id") Long acc_Id, @Param("new_name") String new_name );
	 
}
