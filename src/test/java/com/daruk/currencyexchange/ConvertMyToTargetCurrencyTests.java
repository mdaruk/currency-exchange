package com.daruk.currencyexchange;

import com.daruk.currencyexchange.beans.RateTable;
import com.daruk.currencyexchange.services.ConvertMyToTargetCurrency;
import com.daruk.currencyexchange.services.CurrentCurrencyRates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertMyToTargetCurrencyTests {

    @Autowired
    ConvertMyToTargetCurrency convertMyToTargetCurrency;

    @Test
    public void convertGBP2EURTest() {
        Float amount = convertMyToTargetCurrency
                .convertMyCurrencyToTargetCurrency("GBP",100f,"EUR");
        assertTrue(amount > 0f);
    }

    @Test
    public void convertPLN2PLNTest() {
        Float amount = convertMyToTargetCurrency
                .convertMyCurrencyToTargetCurrency("PLN",100f,"PLN");
        assertTrue(amount == 100f);
    }

    @Test
    public void convertEUR2EURTest() {
        Float amount = convertMyToTargetCurrency
                .convertMyCurrencyToTargetCurrency("EUR",100f,"EUR");
        assertTrue(amount == 100f);
    }
}
