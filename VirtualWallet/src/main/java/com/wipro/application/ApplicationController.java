package com.wipro.application;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.wipro.application.Constants.*;

@Controller
public class ApplicationController {
  
@Autowired
Dao repo;
@Autowired
CardsDao cardsrepo;
@Autowired
WalletService ws;


public String userid;
public int totalcards=3;
public int currentcards;
int balance;
int rs;
public int avaliablecards=totalcards-currentcards;
ArrayList al = new ArrayList(); 
ArrayList al2 = new ArrayList(); 
ModelAndView mv = new ModelAndView();
ArrayList<Integer> find_balance=new ArrayList<Integer>();


@RequestMapping("/dashboard")
public ModelAndView dashboard()
{	
	 int cardsused =cardsrepo.findUsersbyid(userid).size();
	 mv.addObject("amount",ws.account_balance(userid));
     mv.addObject("tcards",MAXIMUM_CARD_LIMIT-cardsused );
     mv.setViewName("dashboard.jsp");

	 return mv;
}

@RequestMapping("login")
public String login()
{
	return "login.jsp";
}
@RequestMapping("topupcard")
public ModelAndView topupcard()
{
	ModelAndView topup=new ModelAndView();
	topup.setViewName("topupcard.jsp");
	
	return topup;
}
@RequestMapping("viewcards")
public ModelAndView viewcards()
{
	ModelAndView viewcards = new ModelAndView();
	viewcards.addObject("allcards",cardsrepo.findUsersbyid(userid));
	viewcards.setViewName("viewcards.jsp");
	 return viewcards;
}

@RequestMapping("newcard")
public ModelAndView newcard()
{
	ModelAndView newcard = new ModelAndView();
	
	long first14 = (long) (Math.random() * 10000000000000000L);
	long cardnumber= 52000L + first14;
	
	newcard.addObject("cardnumber", cardnumber);
	newcard.addObject("userid", al.get(0));
	newcard.addObject("date", "01-01-2050");
	newcard.setViewName("createcards.jsp");
	return newcard;
	
}

@RequestMapping("createcards")
public ModelAndView createcards(Carddetails carddetail)
{
	ModelAndView successmessage = new ModelAndView();
	if(carddetail.getAmount()<10000)
	{
	cardsrepo.save(carddetail);
	successmessage.setViewName("success.jsp");
	successmessage.addObject("date", "01-01-2050");
	successmessage.addObject("cardname", carddetail.getCardname());
	successmessage.addObject("cardnumber",carddetail.getCardnumber());
	successmessage.addObject("cardbalance",carddetail.getAmount());
	
    return successmessage;
	}
	else
	{
		ModelAndView errormessage = new ModelAndView();
		
		errormessage.addObject("msg", MAXIMUM_AMOUNT_REACHED);
		errormessage.setViewName("error.jsp");
		
	    return errormessage;

	}
}

@RequestMapping("validate")
public ModelAndView validate(Userdetails usrdtls)
{
    
	          userid = usrdtls.getUserid();
	 String password = usrdtls.getPassword();
	 
	    if(repo.findById(userid).isPresent())//if userid present in db
        {
		 al.add(repo.findById(userid).get().getUserid());
		 al.add(repo.findById(userid).get().getPassword());
		 al.add(repo.findById(userid).get().getAmount());
		 al.add(repo.findById(userid).get().getCcard());
		 al.add(repo.findById(userid).get().getTcards());
		 
		
		 mv.addObject("amount",ws.account_balance(userid));
         
         avaliablecards=cardsrepo.findUsersbyid(userid).size();
         mv.addObject("tcards",3-avaliablecards );
         
         mv.setViewName("dashboard.jsp");

		 if(al.get(0).equals(userid)&&(al.get(1).equals(password))) // check credentials crt 
		 	return mv;
		 else
		 {
			 ModelAndView er=new ModelAndView();
			 String message="Invalid credentials";
			 er.addObject("error",message);
			 er.setViewName("login.jsp");
			 return er;
		 }
        }
        ModelAndView NotPresent =new ModelAndView();
        NotPresent.setViewName("login.jsp");
        String message="Not a registered user";
        NotPresent.addObject("error",message);
        NotPresent.setViewName("login.jsp");
		return NotPresent;}
}
/*
<%-- 
<%  ArrayList<Carddetails> al=new ArrayList<Carddetails>();
   al=(ArrayList<Carddetails>)request.getAttribute("allcards");
   for(Carddetails cd:a1)
   {
 	  out.println(cd.getUserid());
   }


  %>--%>*/

