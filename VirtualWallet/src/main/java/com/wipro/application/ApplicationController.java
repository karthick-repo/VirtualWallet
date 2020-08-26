package com.wipro.application;

import static com.wipro.application.Constants.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {


	@Autowired
	Dao repo;
	@Autowired
	CardsDao cardsrepo;
	@Autowired
	WalletService ws;

	public String username;
	int balance;
	int rs;
	int check = 0;
	ArrayList al = new ArrayList();
	ArrayList al2 = new ArrayList();
	ModelAndView mv = new ModelAndView();

	@GetMapping("login")
	public String login() {
		return LOGIN;
	}

	@RequestMapping("topupcard")
	public ModelAndView topupcard() {
		ModelAndView topup = new ModelAndView();
		ArrayList<String> usercards = cardsrepo.findcardname(username);

		topup.addObject("allcards", usercards);
		topup.addObject("key", ws.cardsAvaliableSize(username));
		topup.setViewName("topupcard.jsp");

		return topup;
	}

	@RequestMapping("topupvalidate")
	public ModelAndView topupsuccess(Carddetails cd) {
		ModelAndView topupsuccess = new ModelAndView();

		// inputs entered by user
		int amount = cd.getAmount();
		String cardname = cd.getCardname();
		int cardBalance = cardsrepo.findbalanceofcard(cardname, username);

		if ((amount >= 100 && amount <= 10000) && (cardBalance + amount <= 10000)) {
			int current_balance = ws.accountBalance(username);
			repo.updateAccountBalance(current_balance - amount, username);

			amount = cardBalance + amount;
			cardsrepo.updateamount(amount, cardname, username);
			cardBalance = cardsrepo.findbalanceofcard(cardname, username);

			topupsuccess.setViewName("topupsuccess.jsp");
			topupsuccess.addObject("Card_Name", cardname);
			topupsuccess.addObject("Card_Number", cardsrepo.findcardnumber(cardname, username));
			topupsuccess.addObject("cardBalance", cardBalance);
			return topupsuccess;
		} else {
			ModelAndView topuperror = new ModelAndView();

			topuperror.setViewName("virtual_card_error.jsp");
			topuperror.addObject("msg", MAXIMUM_AMOUNT_REACHED);

			return topuperror;
		}

	}

	@GetMapping("view_cards")
	public ModelAndView viewcards() {
		ModelAndView viewcards = new ModelAndView();
		if (cardsrepo.findUsersbyid(username).isEmpty()) {
			viewcards.addObject("currentcards", ws.cardsAvaliableSize(username));
			viewcards.addObject("totalsize", 0);
			viewcards.setViewName("view_cards.jsp");
			return viewcards;
		} else {
             
			ArrayList<String>userscardnumber=cardsrepo.usedcardnumber(username);
			ArrayList<String>userscardname=cardsrepo.usedcardsname(username);
			ArrayList<String>usersamount=cardsrepo.usedcardsamount(username);
			ArrayList<String>usersdate=cardsrepo.usedcardsdate(username);
			
			
			viewcards.addObject("allcards",userscardnumber);
			viewcards.addObject("userscardname",userscardname);
			viewcards.addObject("usersamount",usersamount);
			viewcards.addObject("usersdate",usersdate);
			
			viewcards.addObject("totalsize", ws.cardsAvaliableSize(username));
			viewcards.addObject("currentcards", ws.cardsAvaliableSize(username));
			
			viewcards.setViewName("view_cards.jsp");
			return viewcards;
		}
	}

	@RequestMapping("create_card")
	public ModelAndView newcard() {
		ModelAndView newcard = new ModelAndView();

		long first14 = (long) (Math.random() * 10000000000000000L);
		long cardnumber = 52000L + first14;

		newcard.addObject("cardnumber", cardnumber);
		newcard.addObject("username", username);
		newcard.addObject("date", "01-01-2050");
		newcard.setViewName("create_card.jsp");
		return newcard;

	}

	@RequestMapping(value="/create_card_success")
	public ModelAndView createcards(Carddetails carddetail) {
		ModelAndView successmessage = new ModelAndView();
		int amount = carddetail.getAmount();
		int acc_current_balance = ws.accountBalance(username);
		if (carddetail.getAmount() <= 10000) {
			repo.updateAccountBalance(acc_current_balance - amount, username);
			cardsrepo.save(carddetail);
			successmessage.setViewName("create_card_success.jsp");
			successmessage.addObject("date", "01-01-2050");
			successmessage.addObject("cardname", carddetail.getCardname());
			successmessage.addObject("cardnumber", carddetail.getCardnumber());
			successmessage.addObject("cardBalance", carddetail.getAmount());

			return successmessage;
		} else {
			ModelAndView errormessage = new ModelAndView();

			errormessage.addObject("msg", MAXIMUM_AMOUNT_REACHED);
			errormessage.setViewName("virtual_card_error.jsp");

			return errormessage;

		}
	}

	@RequestMapping("dashboard")
	public ModelAndView validate(Userdetails usrdtls) {
         //intially check=0, if already validated details check=1
		
		if (check == 1) {
			mv.addObject("amount", ws.accountBalance(username));
			mv.addObject("tcards", 3 - ws.cardsAvaliableSize(username));
			mv.setViewName("dashboard.jsp");
			return mv;
		} else {
			username = usrdtls.getusername();
			String password=usrdtls.getPassword();
			check = ws.validateUserDetails(username,password);
			if (check == 1) {
				mv.addObject("amount", ws.accountBalance(username));
				mv.addObject("tcards", 3 - ws.cardsAvaliableSize(username));
				mv.setViewName("dashboard.jsp");
				return mv;

			} else {
				ModelAndView er = new ModelAndView();
				String message = "Invalid credentials";
				er.addObject("error", message);
				er.setViewName(LOGIN);
				return er;

			}
		}
	}

	@GetMapping("logout")
	public String logout() {
		return LOGIN;
	}
}
