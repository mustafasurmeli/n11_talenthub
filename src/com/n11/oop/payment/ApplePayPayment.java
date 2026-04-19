package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;

@Payment(name="Apple Pay")
public class ApplePayPayment  implements IPayment {
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with apple pay");
        return true;
    }

    @Override
    public String toString() {
        return "Apple Pay";
    }
}
