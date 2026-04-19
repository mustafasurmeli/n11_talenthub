package com.n11.oop;

import com.n11.oop.interfaces.IPayment;
import com.n11.oop.payment.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<IPayment> paymentMethods = new ArrayList<>();
        paymentMethods.add(new CardPayment());
        //new
        paymentMethods.add(new PayPalPayment());
        paymentMethods.add(new CashPayment());

        SwingUtilities.invokeLater(() -> {
            PaymentFrame frame = new PaymentFrame(paymentMethods);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}