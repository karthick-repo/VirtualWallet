package com.wipro.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardsDao extends CrudRepository<Carddetails, String> {
	
	
	
	/*String us="'walletuser2'";
	String sql="SELECT * FROM Carddetails u WHERE u.userid = "+us;
	
	@Query( value = sql, nativeQuery = true)*/
	
	@Query(value="SELECT * FROM Carddetails u WHERE u.userid= ?#{[0]}",nativeQuery=true)
	ArrayList<String> findUsersbyid(String userid);
	
	
	       
}
