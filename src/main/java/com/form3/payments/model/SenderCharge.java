/**
 * Model generated from JSON by RoboPOJOGenerator: https://github.com/robohorse/RoboPOJOGenerator
 */

package com.form3.payments.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonCreator;

@DynamoDBDocument
public class SenderCharge {

  private double amount;
  private String currency;

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
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
        "SenderCharge{" +
            "amount = '" + amount + '\'' +
            ",currency = '" + currency + '\'' +
            "}";
  }
}