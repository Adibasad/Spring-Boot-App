package com.Mybank.EasyFinance.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mybank.EasyFinance.models.User;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
      
	@Query(value = "SELECT email FROM user_details WHERE email = :email", nativeQuery = true)	
	public String getUserEmail(@Param("email") String email);
	
	@Query(value = "SELECT user_password FROM user_details WHERE email = :userEmail", nativeQuery = true)	
	public String getUserPassword(@Param("userEmail") String userEmail);
	
	@Query(value = "SELECT * FROM user_details WHERE email = :email", nativeQuery = true)
    User getUserDetails(@Param("email")String email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_details SET first_name= :new_first_name, last_name= :new_last_name WHERE id = :id", nativeQuery = true)	
	public void updateUserNameById(@Param("id") Long id, @Param("new_first_name") String new_first_name,
			@Param("new_last_name") String new_last_name);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_details SET email= :new_email WHERE id = :id", nativeQuery = true)	
	public void updateEmailById(@Param("id") Long id, @Param("new_email") String new_email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_details SET phone_number= :new_number WHERE id = :id", nativeQuery = true)	
	public void updatePhoneNumberById(@Param("id") Long id, @Param("new_number") String new_number);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_details SET user_password= :new_password WHERE id = :id", nativeQuery = true)	
	public void updatePasswordById(@Param("id") Long id, @Param("new_password") String new_password);
	
}
