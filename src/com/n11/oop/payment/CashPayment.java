package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;

public class CashPayment implements IPayment {

    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with cash");
        return true;
    }

    @Override
    public String toString() {
        return "Cash";
    }
}
