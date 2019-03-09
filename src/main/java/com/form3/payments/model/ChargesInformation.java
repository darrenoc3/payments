package com.form3.payments.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bearer_code",
        "sender_charges",
        "receiver_charges_amount",
        "receiver_charges_currency"
})
public class ChargesInformation {

    @JsonProperty("bearer_code")
    public String bearerCode;
    @JsonProperty("sender_charges")
    public List<SenderCharge> senderCharges = null;
    @JsonProperty("receiver_charges_amount")
    public String receiverChargesAmount;
    @JsonProperty("receiver_charges_currency")
    public String receiverChargesCurrency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}