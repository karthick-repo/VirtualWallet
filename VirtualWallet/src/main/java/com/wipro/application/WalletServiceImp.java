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
	
	public void verify_details(String cardname, int  amount, String userid)
	{
		int acc_balance = ws.account_balance(userid);
		System.out.println(acc_balance);
		if (acc_balance >= amount && amount <= 10000) {
			
			System.out.println("Valid");
			finalbalance=finalbalance-amount;
			//String transfer=cardsrepo.transfercardname(cardname);//get card balance
			//String ss=cardsrepo.updateamount( amount, cardname,userid);
			//System.out.println(ss);
			
			
			
		}
		else
		{
			System.out.println("In-Valid");
			
		}
		
	}

	// used cards
	public int cards_avaliable_size(String userid) {
		return cardsrepo.findUsersbyid(userid).size();
	}

	public int account_balance(String userid) {

		int presentcards = cardsrepo.findUsersbyid(userid).size(); // usedcards
		if (presentcards == 0) {
			int mm = repo.findById(userid).get().getAmount();
			return mm;
		} else {
			ArrayList<Integer> find_balance = new ArrayList<Integer>();
			find_balance.addAll(cardsrepo.findbalance(userid));
			balance = 0;

			for (int i = 0; i < cardsrepo.findUsersbyid(userid).size(); i++) {
				int ans = (int) find_balance.get(i);
				balance = balance + ans;
			}
			int mainbalance = (int) repo.findById(userid).get().getAmount();
			 finalbalance = mainbalance - balance;
			balance = 0;
			return finalbalance;
		}
	}

}
