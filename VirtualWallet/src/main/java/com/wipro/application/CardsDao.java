package com.wipro.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardsDao extends CrudRepository<Carddetails, String> {
	
	
	
	@Query(value="SELECT * FROM Carddetails u WHERE u.userid= ?#{[0]}",nativeQuery=true)
	ArrayList<Carddetails> findUsersbyid(String userid);
	
	
	@Query(value="SELECT amount FROM Carddetails u WHERE u.userid= ?#{[0]}",nativeQuery=true)
	ArrayList<Integer> findbalance(String userid);
	
	
	@Query(value="SELECT cardname FROM Carddetails u WHERE u.userid= ?#{[0]}",nativeQuery=true)
	ArrayList<String> findcardname(String userid);
	
	
	       
}
