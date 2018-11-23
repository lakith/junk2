package com.example.demo2;

public class ResponseModel2 {

    private int currency_id;
    private String currency;

    public ResponseModel2() {
    }

    public ResponseModel2(int currency_id, String currency) {
        this.currency_id = currency_id;
        this.currency = currency;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
