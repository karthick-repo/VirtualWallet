package com.wipro.application;

import static com.wipro.application.Constants.MAXIMUM_AMOUNT_REACHED;
import static com.wipro.application.Constants.MAXIMUM_CARD_LIMIT;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public int totalcards = 3;
	public int currentcards;
	int balance;
	int rs;
	int check=0;
	public int avaliablecards = totalcards - currentcards;
	ArrayList al = new ArrayList();
	ArrayList al2 = new ArrayList();
	ModelAndView mv = new ModelAndView();
	ArrayList<Integer> find_balance = new ArrayList<Integer>();

	/*@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		int cardsused = cardsrepo.findUsersbyid(username).size();
		mv.addObject("amount", ws.account_balance(username));
		mv.addObject("tcards", MAXIMUM_CARD_LIMIT - cardsused);
		mv.setViewName("dashboard.jsp");

		return mv;
	}*/

	@RequestMapping("login")
	public String login() {
		return "login.jsp";
	}

	@RequestMapping("topupcard")
	public ModelAndView topupcard() {
		ModelAndView topup = new ModelAndView();
		ArrayList<String> usercards = cardsrepo.findcardname(username);

		topup.addObject("allcards", usercards);
		topup.addObject("key", ws.cards_avaliable_size(username));
		topup.setViewName("topupcard.jsp");

		return topup;
	}

	@RequestMapping("topupvalidate")
	public ModelAndView topupsuccess(Carddetails cd) {
		ModelAndView topupsuccess = new ModelAndView();

		// inputs entered by user
		int amount = cd.getAmount();
		String cardname = cd.getCardname();
		int card_balance = cardsrepo.findbalanceofcard(cardname, username);
		
		if((amount>=100&&amount<=1000)&&(card_balance+amount<=10000))
		{
			int current_balance = ws.account_balance(username);
			repo.update_account_balance(current_balance - amount, username);

			
			amount = card_balance + amount;
			cardsrepo.updateamount(amount, cardname, username);
			card_balance = cardsrepo.findbalanceofcard(cardname, username);

			topupsuccess.setViewName("topupsuccess.jsp");
			topupsuccess.addObject("Card_Name", cardname);
			topupsuccess.addObject("Card_Number", cardsrepo.findcardnumber(cardname, username));
			topupsuccess.addObject("Card_Balance", card_balance);
			return topupsuccess;
		}
		else
		{
			ModelAndView topuperror = new ModelAndView();
			
			topuperror.setViewName("virtual_card_error.jsp");
			topuperror.addObject("msg", MAXIMUM_AMOUNT_REACHED);
			
			return topuperror;
		}

		

	}

	@RequestMapping("view_cards")
	public ModelAndView viewcards() {
		ModelAndView viewcards = new ModelAndView();
		if(cardsrepo.findUsersbyid(username).isEmpty())
        {
			viewcards.addObject("currentcards",ws.cards_avaliable_size(username));
			viewcards.setViewName("view_cards.jsp");
			return viewcards;
        }
		else {
		viewcards.addObject("allcards", cardsrepo.findUsersbyid(username));
		
		viewcards.addObject("currentcards",ws.cards_avaliable_size(username));
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

	@RequestMapping("create_card_success")
	public ModelAndView createcards(Carddetails carddetail) {
		ModelAndView successmessage = new ModelAndView();
		int amount = carddetail.getAmount();
		int acc_current_balance = ws.account_balance(username);
		if (carddetail.getAmount() <=10000) {
			repo.update_account_balance(acc_current_balance - amount, username);
			cardsrepo.save(carddetail);
			successmessage.setViewName("create_card_success.jsp");
			successmessage.addObject("date", "01-01-2050");
			successmessage.addObject("cardname", carddetail.getCardname());
			successmessage.addObject("cardnumber", carddetail.getCardnumber());
			successmessage.addObject("cardbalance", carddetail.getAmount());

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

		if (check == 1) {
			mv.addObject("amount", ws.account_balance(username));
			mv.addObject("tcards", 3 - ws.cards_avaliable_size(username));
			mv.setViewName("dashboard.jsp");
			return mv;
		} else {
			username = usrdtls.getusername();
			check = ws.validate_user_details(usrdtls);
			System.out.println("11");
			if (check == 1) {
				mv.addObject("amount", ws.account_balance(username));
				mv.addObject("tcards", 3 - ws.cards_avaliable_size(username));
				mv.setViewName("dashboard.jsp");
				return mv;

			} else {
				System.out.println("11");
				ModelAndView er = new ModelAndView();
				String message = "Invalid credentials";
				er.addObject("error", message);
				er.setViewName("login.jsp");
				return er;

			}
		}
	}

	@RequestMapping("logout")
	public String logout() {
		return "login.jsp";
	}
}
