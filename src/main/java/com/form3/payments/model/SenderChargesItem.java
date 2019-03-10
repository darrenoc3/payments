package com.form3.payments.model;

public class SenderChargesItem {

  private String amount;
  private String currency;

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getAmount() {
    return amount;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return
        "SenderChargesItem{" +
            "amount = '" + amount + '\'' +
            ",currency = '" + currency + '\'' +
            "}";
  }
}
