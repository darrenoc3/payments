/**
 * Model generated from JSON by RoboPOJOGenerator: https://github.com/robohorse/RoboPOJOGenerator
 */

package com.form3.payments.model;

public class Fx {

  private String originalCurrency;
  private double exchangeRate;
  private double originalAmount;
  private String contractReference;

  public void setOriginalCurrency(String originalCurrency) {
    this.originalCurrency = originalCurrency;
  }

  public String getOriginalCurrency() {
    return originalCurrency;
  }

  public void setExchangeRate(double exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public double getExchangeRate() {
    return exchangeRate;
  }

  public void setOriginalAmount(double originalAmount) {
    this.originalAmount = originalAmount;
  }

  public double getOriginalAmount() {
    return originalAmount;
  }

  public void setContractReference(String contractReference) {
    this.contractReference = contractReference;
  }

  public String getContractReference() {
    return contractReference;
  }

  @Override
  public String toString() {
    return
        "Fx{" +
            "original_currency = '" + originalCurrency + '\'' +
            ",exchange_rate = '" + exchangeRate + '\'' +
            ",original_amount = '" + originalAmount + '\'' +
            ",contract_reference = '" + contractReference + '\'' +
            "}";
  }
}
