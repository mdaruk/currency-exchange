package com.daruk.currencyexchange.services.exceptions;

public class MissingCurrencyCodeInRateTable extends RuntimeException {
    public MissingCurrencyCodeInRateTable(String currencyCode) {
        super("Missing Currency Code: " + currencyCode + " in rate table (or rate table inconsistent).");
    }
}
