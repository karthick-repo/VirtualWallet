package com.wipro.application;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CardsDao extends CrudRepository<Carddetails, String> {

	@Query(value = "SELECT * FROM Carddetails u WHERE u.userid= ?#{[0]}", nativeQuery = true)
	ArrayList<Carddetails> findUsersbyid(String userid);

	@Query(value = "SELECT amount FROM Carddetails u WHERE u.userid= ?#{[0]}", nativeQuery = true)
	ArrayList<Integer> findbalance(String userid);

	@Query(value = "SELECT cardname FROM Carddetails u WHERE u.userid= ?#{[0]}", nativeQuery = true)
	ArrayList<String> findcardname(String userid);

	@Query(value = "SELECT amount FROM Carddetails u WHERE u.cardname= ?#{[0]}", nativeQuery = true)
	String transfercardname(String cardname);

	@Transactional
	@Modifying
	@Query(value = "UPDATE carddetails a SET a.amount =?1 where a.cardname=?2 AND a.userid=?3", nativeQuery = true)
	void updateamount(int amount, String cardname, String userid);

}
