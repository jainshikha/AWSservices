package com.tsystems.dco.AWSservices.SES.config;

public class TransactionalEmailData {
  private final String firstName;
  private final String pin;

  public TransactionalEmailData(String firstName, String pin) {
    this.firstName = firstName;
    this.pin = pin;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getPin() {
    return pin;
  }
}
