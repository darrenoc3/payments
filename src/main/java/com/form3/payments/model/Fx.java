package com.form3.payments.model;

public class Fx {

  private String originalCurrency;
  private String exchangeRate;
  private String originalAmount;
  private String contractReference;

  public void setOriginalCurrency(String originalCurrency) {
    this.originalCurrency = originalCurrency;
  }

  public String getOriginalCurrency() {
    return originalCurrency;
  }

  public void setExchangeRate(String exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public String getExchangeRate() {
    return exchangeRate;
  }

  public void setOriginalAmount(String originalAmount) {
    this.originalAmount = originalAmount;
  }

  public String getOriginalAmount() {
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
