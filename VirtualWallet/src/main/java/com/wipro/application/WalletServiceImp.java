package com.wipro.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.application.CardsDao;
import com.wipro.application.Dao;

import java.util.ArrayList;


@Service
public abstract class WalletServiceImp implements WalletService{
	
	@Autowired
	CardsDao cardsrepo;
	
	@Autowired
	Dao repo;
	
	int balance;
	int rs;
	
	//used cards
	public int  cards_used_size( String userid)
	{
		return cardsrepo.findUsersbyid(userid).size();
	}
	
	public int account_balance(String userid)
	{
		
		int presentcards = cardsrepo.findUsersbyid(userid).size();  //usedcards
		System.out.println(presentcards);
		if(presentcards==0)
		 {
			 return repo.findById(userid).get().getAmount();
		 }
		else
		{
		ArrayList<Integer> find_balance=new ArrayList<Integer>();
		find_balance.addAll(cardsrepo.findbalance(userid));
		balance=0;
		
		 for(int i=0;i<cardsrepo.findUsersbyid(userid).size();i++)
		 {
			 int ans=(int) find_balance.get(i);
			 balance=balance+ans;
		 }
		 int mainbalance=(int) repo.findById(userid).get().getAmount();
		int  finalbalance=mainbalance-balance;
		 balance=0;
		return finalbalance;
		}
	}
	

}
