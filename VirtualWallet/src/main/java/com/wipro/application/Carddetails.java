package com.wipro.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carddetails {

	@Id
	@Column(name = "CARDNUMBER")
	private long cardnumber;

	@Column(name = "username")
	private String username;

	@Column(name = "CARDNAME")
	private String cardname;

	@Column(name = "amount")
	private int amount;

	@Column(name = "Date")
	private String date;

	public long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CardDetails [username=" + username + ", cardname=" + cardname + ", amount=" + amount + ", cardnumber="
				+ cardnumber + ", date=" + date + "]";
	}

}
