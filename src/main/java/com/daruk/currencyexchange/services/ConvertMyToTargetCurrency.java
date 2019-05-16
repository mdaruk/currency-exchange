package com.daruk.currencyexchange.services;

import com.daruk.currencyexchange.beans.Currency;
import com.daruk.currencyexchange.beans.RateTable;
import com.daruk.currencyexchange.services.exceptions.MissingCurrencyCodeInRateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvertMyToTargetCurrency {

    @Autowired
    CurrentCurrencyRates currentExchangeRates;

    public Float convertMyCurrencyToTargetCurrency(String myCurrencyCode, Float value, String toCurrencyCode) {
        final Currency myCurrency = getCurrencyByCode(myCurrencyCode, currentExchangeRates.getCurrentRateTable());
        final Currency toCurrency = getCurrencyByCode(toCurrencyCode, currentExchangeRates.getCurrentRateTable());

        return value.floatValue() * myCurrency.getMid() / toCurrency.getMid();

    }
    public static Currency getCurrencyByCode(String currencyCode, RateTable rateTable) {
        Optional<Currency> foundCurrency =
                (currencyCode.equals("PLN")?
                        Optional.of(new Currency("PLN","PLN",1f))
                        :
                        (rateTable.getRates().stream()
                                .filter(currency -> currencyCode.equals(currency.getCode())).count() == 1
                                ?
                                rateTable.getRates().stream().filter(currency -> currencyCode.equals(currency.getCode()))
                                        .findFirst()
                                :
                                Optional.empty()
                        )
                );
                if( ! foundCurrency.isPresent() ) {
                    throw new MissingCurrencyCodeInRateTable(currencyCode);
                }
        return foundCurrency.get();
    }
}
