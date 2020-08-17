package com.wipro.application;

import java.util.ArrayList;

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
	public int cards_avaliable_size(String username) {
		return cardsrepo.findUsersbyid(username).size();
	}

	public int account_balance(String username) {

		return repo.findById(username).get().getAmount();
	}
	public int validate_user_details(String username, String password)
	{ 
		
		if (repo.findById(username).isPresent())// if username present in db
		{
			
			al.add(repo.findById(username).get().getusername());
			al.add(repo.findById(username).get().getPassword());
			al.add(repo.findById(username).get().getAmount());
			al.add(repo.findById(username).get().getCcard());
			al.add(repo.findById(username).get().getTcards());
			
			
			System.out.println(al.get(0)+"=="+al.get(1));
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
