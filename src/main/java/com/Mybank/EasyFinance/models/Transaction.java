/**
 * 
 */
package com.Mybank.EasyFinance.models;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

//import jakarta.persistence.*;

/**
 * @author ADIBA SADAF
 *
 */
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    private String accountNumberSender;
    private String accountNumberReciever;
    private String transactionType;
    private BigInteger tranferedAmount;
    private String accountNameOfSender;
    private String accountNameOfReciever;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumberSender() {
		return accountNumberSender;
	}

	public void setAccountNumberSender(String accountNumberSender) {
		this.accountNumberSender = accountNumberSender;
	}

	public String getAccountNumberReciever() {
		return accountNumberReciever;
	}

	public void setAccountNumberReciever(String accountNumberReciever) {
		this.accountNumberReciever = accountNumberReciever;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigInteger getTranferedAmount() {
		return tranferedAmount;
	}

	public void setTranferedAmount(BigInteger tranferedAmount) {
		this.tranferedAmount = tranferedAmount;
	}

	public String getAccountNameOfSender() {
		return accountNameOfSender;
	}

	public void setAccountNameOfSender(String accountNameOfSender) {
		this.accountNameOfSender = accountNameOfSender;
	}

	public String getAccountNameOfReciever() {
		return accountNameOfReciever;
	}

	public void setAccountNameOfReciever(String accountNameOfReciever) {
		this.accountNameOfReciever = accountNameOfReciever;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumberSender=" + accountNumberSender
				+ ", accountNumberReciever=" + accountNumberReciever + ", transactionType=" + transactionType
				+ ", tranferedAmount=" + tranferedAmount + ", accountNameOfSender=" + accountNameOfSender
				+ ", accountNameOfReciever=" + accountNameOfReciever + ", createdAt=" + createdAt + "]";
	}
}

	
