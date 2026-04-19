package com.n11.oop.payment;

import com.n11.oop.interfaces.IPayment;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaymentRegistry {

    private List<IPayment> paymentMethods = new ArrayList<>();

    public void scan(){
        String packageName= "com.n11.oop.payment";
        String path = packageName.replace('.','/');

        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(path);
            File directory = new File(url.toURI());

            for (File file : directory.listFiles()){
                if(!file.getName().endsWith(".class")) continue;

                String className = packageName + "." +file.getName().replace(".class", "");
                Class<?> clazz = Class.forName(className);

                if (clazz.getAnnotation(Payment.class)==null) continue;

                if(!IPayment.class.isAssignableFrom(clazz)) continue;

                IPayment instance = (IPayment) clazz.getDeclaredConstructor().newInstance();
                paymentMethods.add(instance);

                Payment annotation = clazz.getAnnotation(Payment.class);
                System.out.println("Loaded: "+ annotation.name());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<IPayment> getPaymentMethods(){
        return paymentMethods;
    }

}
