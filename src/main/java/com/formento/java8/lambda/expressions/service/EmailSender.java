package com.formento.java8.lambda.expressions.service;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    public void sendEmail(String emailAddress, String message) {
        System.out.println("send to " + emailAddress + ": " + message);
    }
}
