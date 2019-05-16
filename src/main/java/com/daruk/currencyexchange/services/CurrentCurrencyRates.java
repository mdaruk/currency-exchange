package com.daruk.currencyexchange.services;

import com.daruk.currencyexchange.beans.RateTable;
import com.daruk.currencyexchange.services.exceptions.CannotLoadRateTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class CurrentCurrencyRates {

    @Autowired
    RateTable rateTable;

    public RateTable getCurrentRateTable() {
        LocalDate today = LocalDate.now();
        if(rateTable == null || rateTable.getLoadDate() == null ||
                rateTable.getLoadDate().isBefore(today)){
            refreshExchangeRates();
        }
        return rateTable;
    }

    @PostConstruct
    private void postConstruct() {
        refreshExchangeRates();
    }

    private void refreshExchangeRates() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String exchangeRatesUrl
                    = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
            ResponseEntity<String> response
                    = restTemplate.getForEntity(exchangeRatesUrl + "/1", String.class);
            String body = response.getBody();
            ObjectMapper mapper = new ObjectMapper();

            RateTable[] rateTables = mapper.readValue(body, RateTable[].class);
            if(rateTables.length != 1) {
                throw new CannotLoadRateTable();
            } else {
                rateTable = rateTables[0];
                rateTable.setLoadDate(LocalDate.now());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
