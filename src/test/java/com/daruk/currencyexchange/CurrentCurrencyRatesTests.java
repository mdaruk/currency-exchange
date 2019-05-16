package com.daruk.currencyexchange;

import com.daruk.currencyexchange.beans.RateTable;
import com.daruk.currencyexchange.services.CurrentCurrencyRates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrentCurrencyRatesTests {

    @Autowired
    CurrentCurrencyRates currentCurrencyRates;

    @Test
    public void loadTest() {
        RateTable currentRateTable = currentCurrencyRates.getCurrentRateTable();
        assertNotNull(currentRateTable);
    }
    @Test
    public void nextLoadIsCachedTest() {
        RateTable currentRateTable = currentCurrencyRates.getCurrentRateTable();
        assertTrue(currentRateTable == currentCurrencyRates.getCurrentRateTable());
    }
    @Test
    public void nextDayLoadIsRefreshedTest() {
        RateTable initialRateTable = currentCurrencyRates.getCurrentRateTable();
        initialRateTable.setLoadDate(LocalDate.now().minusDays(1));
        assertTrue(currentCurrencyRates.getCurrentRateTable().getLoadDate().isEqual(LocalDate.now()));
        assertTrue(currentCurrencyRates.getCurrentRateTable() != initialRateTable);
    }
}
