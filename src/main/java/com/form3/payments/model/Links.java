package com.form3.payments.model;

public class Links {

  private String self;

  public void setSelf(String self) {
    this.self = self;
  }

  public String getSelf() {
    return self;
  }

  @Override
  public String toString() {
    return
        "Links{" +
            "self = '" + self + '\'' +
            "}";
  }
}
