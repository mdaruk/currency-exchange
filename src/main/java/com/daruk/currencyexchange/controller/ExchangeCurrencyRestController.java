package com.daruk.currencyexchange.controller;

import com.daruk.currencyexchange.beans.ConversionResult;
import com.daruk.currencyexchange.beans.ConversionRequest;
import com.daruk.currencyexchange.services.ConvertMyToTargetCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExchangeCurrencyRestController {

    @Autowired
    ConvertMyToTargetCurrency exchangeMyToCurrenct;

    @PostMapping("/convertCurrency")
    public ConversionResult exchangeCurrencyRest(@RequestBody ConversionRequest exchangeRequest) {
        Float amount = exchangeMyToCurrenct.convertMyCurrencyToTargetCurrency(
                exchangeRequest.getMyCurrencyCode(),
                exchangeRequest.getAmount(),
                exchangeRequest.getTargetCurrencyCode());
        ConversionResult conversionResult = new ConversionResult();
        conversionResult.setAmount(amount);
        conversionResult.setCurrencyCode(exchangeRequest.getTargetCurrencyCode());
        return conversionResult;
    }

    @GetMapping("/convertCurrency")
    public String greeting() {
        return "This API supports only POST requests.";
    }
}