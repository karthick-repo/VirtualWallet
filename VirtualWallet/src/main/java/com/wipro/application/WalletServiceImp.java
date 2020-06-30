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
	
	public void verify_details(String cardname, int  amount, String username)
	{
		int acc_balance = ws.account_balance(username);
		System.out.println(acc_balance);
		if (acc_balance >= amount && amount <= 10000) {
			
			System.out.println("Valid");
			finalbalance=finalbalance-amount;
			repo.findById(username).get().setAmount(finalbalance);
			//String transfer=cardsrepo.transfercardname(cardname);//get card balance
			//String ss=cardsrepo.updateamount( amount, cardname,username);
			//System.out.println(ss);
			
			
			
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

}
