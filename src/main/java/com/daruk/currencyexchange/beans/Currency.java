package com.daruk.currencyexchange.beans;

public class Currency {
    String currency;
    String code;
    Float mid;

    public Currency() {
    }

    public Currency(String currency, String code, Float mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getMid() {
        return mid;
    }

    public void setMid(Float mid) {
        this.mid = mid;
    }
    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", mid=" + mid +
                '}';
    }
}
