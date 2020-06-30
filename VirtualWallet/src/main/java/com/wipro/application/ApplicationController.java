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
	public int avaliablecards = totalcards - currentcards;
	ArrayList al = new ArrayList();
	ArrayList al2 = new ArrayList();
	ModelAndView mv = new ModelAndView();
	ArrayList<Integer> find_balance = new ArrayList<Integer>();

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		int cardsused = cardsrepo.findUsersbyid(username).size();
		mv.addObject("amount", ws.account_balance(username));
		mv.addObject("tcards", MAXIMUM_CARD_LIMIT - cardsused);
		mv.setViewName("dashboard.jsp");

		return mv;
	}

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

	@RequestMapping("viewcards")
	public ModelAndView viewcards() {
		ModelAndView viewcards = new ModelAndView();
		viewcards.addObject("allcards", cardsrepo.findUsersbyid(username));
		viewcards.addObject("currentcards",ws.cards_avaliable_size(username));
		viewcards.setViewName("viewcards.jsp");
		return viewcards;
	}

	@RequestMapping("newcard")
	public ModelAndView newcard() {
		ModelAndView newcard = new ModelAndView();

		long first14 = (long) (Math.random() * 10000000000000000L);
		long cardnumber = 52000L + first14;
		

		newcard.addObject("cardnumber", cardnumber);
		newcard.addObject("username", al.get(0));
		newcard.addObject("date", "01-01-2050");
		newcard.setViewName("createcards.jsp");
		return newcard;

	}

	@RequestMapping("createcards")
	public ModelAndView createcards(Carddetails carddetail) {
		ModelAndView successmessage = new ModelAndView();
		int amount = carddetail.getAmount();
		int acc_current_balance = ws.account_balance(username);
		if (carddetail.getAmount() <=10000) {
			repo.update_account_balance(acc_current_balance - amount, username);
			cardsrepo.save(carddetail);
			successmessage.setViewName("success.jsp");
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

	@RequestMapping("validate")
	public ModelAndView validate(Userdetails usrdtls) {

		username = usrdtls.getusername();
		String password = usrdtls.getPassword();

		if (repo.findById(username).isPresent())// if username present in db
		{
			al.add(repo.findById(username).get().getusername());
			al.add(repo.findById(username).get().getPassword());
			al.add(repo.findById(username).get().getAmount());
			al.add(repo.findById(username).get().getCcard());
			al.add(repo.findById(username).get().getTcards());

			mv.addObject("amount", ws.account_balance(username));
			// avaliablecards = cardsrepo.findUsersbyid(username).size();
			mv.addObject("tcards", 3 - ws.cards_avaliable_size(username));

			mv.setViewName("dashboard.jsp");

			if (al.get(0).equals(username) && (al.get(1).equals(password))) // check credentials crt
				return mv;
			else {
				ModelAndView er = new ModelAndView();
				String message = "Invalid credentials";
				er.addObject("error", message);
				er.setViewName("login.jsp");
				return er;
			}
		}
		ModelAndView NotPresent = new ModelAndView();
		NotPresent.setViewName("login.jsp");
		String message = "Not a registered user";
		NotPresent.addObject("error", message);
		NotPresent.setViewName("login.jsp");
		return NotPresent;
	}

	@RequestMapping("logout")
	public String logout() {
		return "login.jsp";
	}
}
