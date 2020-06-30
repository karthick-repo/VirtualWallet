package com.wipro.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userdetails {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "CCARDS")
	private int ccard;

	@Column(name = "TCARDS")
	private int tcards;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCcard() {
		return ccard;
	}

	public void setCcard(int ccard) {
		this.ccard = ccard;
	}

	public int getTcards() {
		return tcards;
	}

	public void setTcards(int tcards) {
		this.tcards = tcards;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + "]";
	}

}
