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
	
	public void verify_details(String cardname, int  amount, String username)
	{
		int acc_balance = ws.account_balance(username);
		System.out.println(acc_balance);
		if (acc_balance >= amount && amount <= 10000) {
			
			System.out.println("Valid");
			finalbalance=finalbalance-amount;
			repo.findById(username).get().setAmount(finalbalance);
				
			
		}
		else
		{
			System.out.println("In-Valid");
			
		}
		
	}

	// used cards
	public int cards_avaliable_size(String username) {
		return cardsrepo.findUsersbyid(username).size();
	}

	public int account_balance(String username) {

		return repo.findById(username).get().getAmount();
	}
	public int validate_user_details(Userdetails usrdtls)
	{ 
		 String username = usrdtls.getusername();
		 String password = usrdtls.getPassword();

		if (repo.findById(username).isPresent())// if username present in db
		{
			al.add(repo.findById(username).get().getusername());
			al.add(repo.findById(username).get().getPassword());
			al.add(repo.findById(username).get().getAmount());
			al.add(repo.findById(username).get().getCcard());
			al.add(repo.findById(username).get().getTcards());
			
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
