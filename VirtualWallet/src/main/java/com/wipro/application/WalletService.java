package com.wipro.application;

import org.springframework.stereotype.Component;

@Component
public interface WalletService {

	public int cards_avaliable_size(String userid);

	public int account_balance(String userid);

	public int verify_details(String cardname, int amount, String userid);

}
