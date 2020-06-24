package com.wipro.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.wipro.application.WalletService"})
public class VirtualWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualWalletApplication.class, args);
	}

}
