package com.wipro.application;

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
	
	
	// used cards
	public int cardsAvaliableSize(String username) {
		return cardsrepo.findUsersbyid(username).size();
	}

	public int accountBalance(String username) {

		return repo.getBalance(username);
	}
	
	public int validateUserDetails(String username, String password) {

		if (repo.findById(username).isPresent())// if username present in db
		{

			if (repo.getPassword(username).equals(password)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;

		}
		
	}

}