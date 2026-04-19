package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;

public class PaymentService {
    private IPayment iPayment;

    public PaymentService(IPayment iPayment){
        this.iPayment =iPayment;
    }

    public boolean  pay(double amount){
        return this.iPayment.pay(amount);
    }
}
