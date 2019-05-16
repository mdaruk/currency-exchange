package com.daruk.currencyexchange;

import com.daruk.currencyexchange.services.CurrentCurrencyRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeApplication {

	@Autowired
	CurrentCurrencyRates currentExchangeRates;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}
}
