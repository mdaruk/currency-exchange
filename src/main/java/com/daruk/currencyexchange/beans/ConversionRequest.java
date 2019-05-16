package com.daruk.currencyexchange.beans;

public class ConversionRequest {
    Float amount;
    String myCurrencyCode;
    String targetCurrencyCode;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMyCurrencyCode() {
        return myCurrencyCode;
    }

    public void setMyCurrencyCode(String myCurrencyCode) {
        this.myCurrencyCode = myCurrencyCode;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }
}
