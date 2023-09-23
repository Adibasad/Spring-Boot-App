package com.Mybank.EasyFinance.models;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//import jakarta.persistence.*;

@Entity
@Table(name  =  "accounts")
public class Account {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "acc_id")
	private Long id;
	
	private String accountNumber;
    private BigInteger accountBalance;
    private String accountName;
    public String status;
    
    @CreationTimestamp
    private LocalDateTime dateTime;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "acc_id")
    private User user;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigInteger getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigInteger accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountName=" + accountName + ", status=" + status + ", dateTime=" + dateTime + ", modifiedAt="
				+ modifiedAt + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
