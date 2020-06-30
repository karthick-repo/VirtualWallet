package com.wipro.application;

import org.springframework.stereotype.Component;

@Component
public interface WalletService {

	public int cards_avaliable_size(String username);

	public int account_balance(String username);

	public void verify_details(String cardname, int amount, String username);

}
