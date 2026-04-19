package com.n11.oop;

import com.n11.oop.interfaces.IPayment;
import com.n11.oop.payment.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        PaymentRegistry registry = new PaymentRegistry();
        registry.scan();

        SwingUtilities.invokeLater(() -> {
            PaymentFrame frame = new PaymentFrame(registry.getPaymentMethods());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}