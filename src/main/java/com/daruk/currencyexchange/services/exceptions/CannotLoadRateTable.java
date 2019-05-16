package com.daruk.currencyexchange.services.exceptions;

public class CannotLoadRateTable extends RuntimeException {

    public CannotLoadRateTable() {
        super("Cannot load Currency Rate Table.");
    }
}
