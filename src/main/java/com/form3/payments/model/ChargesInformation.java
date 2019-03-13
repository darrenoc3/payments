/**
 * Model generated from JSON by RoboPOJOGenerator: https://github.com/robohorse/RoboPOJOGenerator
 */

package com.form3.payments.model;

import java.util.Arrays;
import java.util.List;
import javax.money.MonetaryAmount;

public class ChargesInformation {

  private MonetaryAmount[] senderCharges;
  private String bearerCode;
  private double receiverChargesAmount;
  private String receiverChargesCurrency;

  public void setSenderCharges(MonetaryAmount[] senderCharges) {
    this.senderCharges = senderCharges;
  }

  public List<MonetaryAmount> getSenderCharges() {
    return Arrays.asList(senderCharges);
  }

  public void setBearerCode(String bearerCode) {
    this.bearerCode = bearerCode;
  }

  public String getBearerCode() {
    return bearerCode;
  }

  public void setReceiverChargesAmount(double receiverChargesAmount) {
    this.receiverChargesAmount = receiverChargesAmount;
  }

  public double getReceiverChargesAmount() {
    return receiverChargesAmount;
  }

  public void setReceiverChargesCurrency(String receiverChargesCurrency) {
    this.receiverChargesCurrency = receiverChargesCurrency;
  }

  public String getReceiverChargesCurrency() {
    return receiverChargesCurrency;
  }

  @Override
  public String toString() {
    return
        "ChargesInformation{" +
            "sender_charges = '" + senderCharges + '\'' +
            ",bearer_code = '" + bearerCode + '\'' +
            ",receiver_charges_amount = '" + receiverChargesAmount + '\'' +
            ",receiver_charges_currency = '" + receiverChargesCurrency + '\'' +
            "}";
  }
}