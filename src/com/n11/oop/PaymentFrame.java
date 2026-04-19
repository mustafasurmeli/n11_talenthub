package com.n11.oop;

import com.n11.oop.interfaces.IPayment;
import com.n11.oop.payment.PaymentService;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PaymentFrame extends JFrame {
    private final JTextField amountField;
    private final JList<IPayment> methodList;
    private final JTextArea logArea;

    public PaymentFrame(List<IPayment> paymentMethods) {
        super("Payment System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Amount:"));
        amountField = new JTextField(12);
        top.add(amountField);
        add(top, BorderLayout.NORTH);

        DefaultListModel<IPayment> model = new DefaultListModel<>();
        for (IPayment p : paymentMethods) model.addElement(p);
        methodList = new JList<>(model);
        methodList.setSelectedIndex(0);
        methodList.setBorder(BorderFactory.createTitledBorder("Payment Methods"));
        add(new JScrollPane(methodList), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(0, 5));
        JButton payButton = new JButton("Pay");
        bottom.add(payButton, BorderLayout.NORTH);

        logArea = new JTextArea(6, 30);
        logArea.setEditable(false);
        logArea.setBorder(BorderFactory.createTitledBorder("Log"));
        bottom.add(new JScrollPane(logArea), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        payButton.addActionListener(e -> handlePayment());
    }

    private void handlePayment() {
        IPayment selected = methodList.getSelectedValue();
        if (selected == null) {
            log("ERROR: Please choose a payment method");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountField.getText().trim());
        } catch (NumberFormatException ex) {
            log("ERROR: Please choose a valid amount");
            return;
        }

        PaymentService service = new PaymentService(selected);
        boolean success = service.pay(amount);

        if (success) {
            log("SUCCESS: " + amount + " TL paid → " + selected);
        } else {
            log("FAIL: Payment failure");
        }
    }

    private void log(String message) {
        logArea.append(message + "\n");
    }
}