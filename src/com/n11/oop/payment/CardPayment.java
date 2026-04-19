package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;


public class CardPayment implements IPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with credit card");
        return true;
    }

    @Override
    public String toString(){
        return "Credit Card";
    }
}
