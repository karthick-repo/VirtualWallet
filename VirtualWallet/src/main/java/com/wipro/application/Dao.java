package com.wipro.application;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface Dao extends CrudRepository<Userdetails, String> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE userdetails a SET a.amount =?1 where  a.userid=?2", nativeQuery = true)
	void update_account_balance(int amount,String userid);

}
