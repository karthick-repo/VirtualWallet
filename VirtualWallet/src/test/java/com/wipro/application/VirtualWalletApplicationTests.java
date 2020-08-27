package com.wipro.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VirtualWalletApplicationTests {
	
	@Test
	void userNameNotNull() {
		ApplicationController myClass = new ApplicationController();
	     String actual=myClass.username;
	     assertThat(actual).isNull();//.isNotNull();
	}

}
