package com.wipro.application;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface Dao extends CrudRepository<Userdetails, String> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE userdetails a SET a.amount =?1 where  a.username=?2", nativeQuery = true)
	void updateAccountBalance(int amount,String username);
	
	@Query(value = "SELECT amount FROM userdetails u WHERE u.username= ?#{[0]}", nativeQuery = true)
	int getBalance(String username);
	
	@Query(value = "SELECT TCARDS FROM userdetails u WHERE u.username= ?#{[0]}", nativeQuery = true)
	int tCcards(String username);
	
	@Query(value = "SELECT CCARDS FROM userdetails u WHERE u.username= ?#{[0]}", nativeQuery = true)
	int cCards(String username);
	
	@Query(value = "SELECT password FROM userdetails u WHERE u.username= ?#{[0]}", nativeQuery = true)
	String getPassword(String username);
	
	
}
