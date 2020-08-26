package com.wipro.application;

import org.springframework.stereotype.Component;

@Component
public interface WalletService {
	
	public int validateUserDetails(String username, String password);

	public int cardsAvaliableSize(String username);

	public int accountBalance(String username);

}
