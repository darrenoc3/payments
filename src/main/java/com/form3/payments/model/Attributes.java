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
        "amount",
        "beneficiary_party",
        "charges_information",
        "currency",
        "debtor_party",
        "end_to_end_reference",
        "fx",
        "numeric_reference",
        "payment_id",
        "payment_purpose",
        "payment_scheme",
        "payment_type",
        "processing_date",
        "reference",
        "scheme_payment_sub_type",
        "scheme_payment_type",
        "sponsor_party"
})
public class Attributes {

    @JsonProperty("amount")
    public String amount;
    @JsonProperty("beneficiary_party")
    public BeneficiaryParty beneficiaryParty;
    @JsonProperty("charges_information")
    public ChargesInformation chargesInformation;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("debtor_party")
    public DebtorParty debtorParty;
    @JsonProperty("end_to_end_reference")
    public String endToEndReference;
    @JsonProperty("fx")
    public Fx fx;
    @JsonProperty("numeric_reference")
    public String numericReference;
    @JsonProperty("payment_id")
    public String paymentId;
    @JsonProperty("payment_purpose")
    public String paymentPurpose;
    @JsonProperty("payment_scheme")
    public String paymentScheme;
    @JsonProperty("payment_type")
    public String paymentType;
    @JsonProperty("processing_date")
    public String processingDate;
    @JsonProperty("reference")
    public String reference;
    @JsonProperty("scheme_payment_sub_type")
    public String schemePaymentSubType;
    @JsonProperty("scheme_payment_type")
    public String schemePaymentType;
    @JsonProperty("sponsor_party")
    public SponsorParty sponsorParty;
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