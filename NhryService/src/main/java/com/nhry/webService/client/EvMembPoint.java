package com.nhry.webService.client;

import com.nhry.webService.client.EvMemb;

import java.math.BigDecimal;

/**
 * Created by cbz on 8/1/2016.
 */
public class EvMembPoint extends EvMemb{
    String type;
    BigDecimal balance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
