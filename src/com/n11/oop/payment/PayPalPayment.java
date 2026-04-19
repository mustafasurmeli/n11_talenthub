package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;

@Payment(name="PayPal")
public class PayPalPayment implements IPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with PayPal");
        return true;
    }

    @Override
    public String toString(){
        return "PayPal";
    }
}
