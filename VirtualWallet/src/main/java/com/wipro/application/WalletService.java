package com.wipro.application;

import org.springframework.stereotype.Component;

@Component
public interface WalletService {
	
	public int validate_user_details(Userdetails usrdtls);

	public int cards_avaliable_size(String username);

	public int account_balance(String username);

}
