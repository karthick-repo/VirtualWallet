package com.wipro.application;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface WalletService {
	
	public int cards_avaliable_size(String userid);
	public int account_balance(String userid);
	public int sample(String userid);
}
