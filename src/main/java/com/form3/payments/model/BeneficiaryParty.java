package com.form3.payments.model;

public class BeneficiaryParty {

  private String bankIdCode;
  private String accountNumber;
  private int accountType;
  private String address;
  private String bankId;
  private String accountName;
  private String name;
  private String accountNumberCode;

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

  public void setAccountType(int accountType) {
    this.accountType = accountType;
  }

  public int getAccountType() {
    return accountType;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public String getBankId() {
    return bankId;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAccountNumberCode(String accountNumberCode) {
    this.accountNumberCode = accountNumberCode;
  }

  public String getAccountNumberCode() {
    return accountNumberCode;
  }

  @Override
  public String toString() {
    return
        "BeneficiaryParty{" +
            "bank_id_code = '" + bankIdCode + '\'' +
            ",account_number = '" + accountNumber + '\'' +
            ",account_type = '" + accountType + '\'' +
            ",address = '" + address + '\'' +
            ",bank_id = '" + bankId + '\'' +
            ",account_name = '" + accountName + '\'' +
            ",name = '" + name + '\'' +
            ",account_number_code = '" + accountNumberCode + '\'' +
            "}";
  }
}
