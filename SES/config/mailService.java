package com.tsystems.dco.AWSservices.SES.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class mailService {

  @Autowired
  private MailSender mailSender;

  public void sendMailMessage() {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("shikha.jain@t-systems.com");
    simpleMailMessage.setSubject("test from java code SES");
    simpleMailMessage.setTo("shikha.jain@t-systems.com");
    simpleMailMessage.setText("hello User, this is the mail from SES");
    this.mailSender.send(simpleMailMessage);
    System.out.println("email is send successfully");
  }
}
