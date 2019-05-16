package com.daruk.currencyexchange.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class RateTable {

    private String table;
    private String no;
    private Date effectiveDate;
    private List<Currency> rates;
    private LocalDate loadDate;

    public RateTable() {
    }

    public LocalDate getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(LocalDate loadDate) {
        this.loadDate = loadDate;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<Currency> getRates() {
        return rates;
    }

    public void setRates(List<Currency> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "RateTable{" +
                "table='" + table + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", rates=" + rates +
                '}';
    }
}
