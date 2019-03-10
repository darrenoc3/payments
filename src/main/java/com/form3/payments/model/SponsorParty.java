package com.form3.payments.model;

public class SponsorParty {

  private String bankIdCode;
  private String accountNumber;
  private String bankId;

  public void setBankIdCode(String bankIdCode) {
    this.bankIdCode = bankIdCode;
  }

  public String getBankIdCode() {
    return bankIdCode;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public String getBankId() {
    return bankId;
  }

  @Override
  public String toString() {
    return
        "SponsorParty{" +
            "bank_id_code = '" + bankIdCode + '\'' +
            ",account_number = '" + accountNumber + '\'' +
            ",bank_id = '" + bankId + '\'' +
            "}";
  }
}
