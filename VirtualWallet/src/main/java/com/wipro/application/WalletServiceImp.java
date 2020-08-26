package com.wipro.application;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class WalletServiceImp implements WalletService {

	@Autowired
	CardsDao cardsrepo;

	@Autowired
	Dao repo;
	
	@Autowired
	WalletService ws;

	int balance;
	int finalbalance;
	
	ArrayList al = new ArrayList();
	
	
	// used cards
	public int cardsAvaliableSize(String username) {
		return cardsrepo.findUsersbyid(username).size();
	}

	public int accountBalance(String username) {

		return repo.getBalance(username);
	}
	
	public int validateUserDetails(String username, String password)
	{ 
		
		if (repo.findById(username).isPresent())// if username present in db
		{
			
			al.add(username);
			al.add(repo.getPassword(username));
			al.add(repo.getBalance(username));
			al.add(repo.cCards(username));
			al.add(repo.tCcards(username));
			
			
			if (al.get(0).equals(username) && (al.get(1).equals(password)))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		else
		{
			return 0;
			
		}
		
	}

}