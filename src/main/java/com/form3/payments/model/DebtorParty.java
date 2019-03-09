package com.form3.payments.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "account_name",
    "account_number",
    "account_number_code",
    "address",
    "bank_id",
    "bank_id_code",
    "name"
})
public class DebtorParty {

  @JsonProperty("account_name")
  public String accountName;
  @JsonProperty("account_number")
  public String accountNumber;
  @JsonProperty("account_number_code")
  public String accountNumberCode;
  @JsonProperty("address")
  public String address;
  @JsonProperty("bank_id")
  public String bankId;
  @JsonProperty("bank_id_code")
  public String bankIdCode;
  @JsonProperty("name")
  public String name;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}