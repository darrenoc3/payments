package com.form3.payments.model;

public class Attributes{
	private DebtorParty debtorParty;
	private String paymentScheme;
	private String amount;
	private SponsorParty sponsorParty;
	private String schemePaymentSubType;
	private String processingDate;
	private ChargesInformation chargesInformation;
	private String numericReference;
	private String endToEndReference;
	private String reference;
	private Fx fx;
	private String paymentType;
	private BeneficiaryParty beneficiaryParty;
	private String paymentPurpose;
	private String paymentId;
	private String currency;
	private String schemePaymentType;

	public void setDebtorParty(DebtorParty debtorParty){
		this.debtorParty = debtorParty;
	}

	public DebtorParty getDebtorParty(){
		return debtorParty;
	}

	public void setPaymentScheme(String paymentScheme){
		this.paymentScheme = paymentScheme;
	}

	public String getPaymentScheme(){
		return paymentScheme;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setSponsorParty(SponsorParty sponsorParty){
		this.sponsorParty = sponsorParty;
	}

	public SponsorParty getSponsorParty(){
		return sponsorParty;
	}

	public void setSchemePaymentSubType(String schemePaymentSubType){
		this.schemePaymentSubType = schemePaymentSubType;
	}

	public String getSchemePaymentSubType(){
		return schemePaymentSubType;
	}

	public void setProcessingDate(String processingDate){
		this.processingDate = processingDate;
	}

	public String getProcessingDate(){
		return processingDate;
	}

	public void setChargesInformation(ChargesInformation chargesInformation){
		this.chargesInformation = chargesInformation;
	}

	public ChargesInformation getChargesInformation(){
		return chargesInformation;
	}

	public void setNumericReference(String numericReference){
		this.numericReference = numericReference;
	}

	public String getNumericReference(){
		return numericReference;
	}

	public void setEndToEndReference(String endToEndReference){
		this.endToEndReference = endToEndReference;
	}

	public String getEndToEndReference(){
		return endToEndReference;
	}

	public void setReference(String reference){
		this.reference = reference;
	}

	public String getReference(){
		return reference;
	}

	public void setFx(Fx fx){
		this.fx = fx;
	}

	public Fx getFx(){
		return fx;
	}

	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;
	}

	public String getPaymentType(){
		return paymentType;
	}

	public void setBeneficiaryParty(BeneficiaryParty beneficiaryParty){
		this.beneficiaryParty = beneficiaryParty;
	}

	public BeneficiaryParty getBeneficiaryParty(){
		return beneficiaryParty;
	}

	public void setPaymentPurpose(String paymentPurpose){
		this.paymentPurpose = paymentPurpose;
	}

	public String getPaymentPurpose(){
		return paymentPurpose;
	}

	public void setPaymentId(String paymentId){
		this.paymentId = paymentId;
	}

	public String getPaymentId(){
		return paymentId;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setSchemePaymentType(String schemePaymentType){
		this.schemePaymentType = schemePaymentType;
	}

	public String getSchemePaymentType(){
		return schemePaymentType;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"debtor_party = '" + debtorParty + '\'' + 
			",payment_scheme = '" + paymentScheme + '\'' + 
			",amount = '" + amount + '\'' + 
			",sponsor_party = '" + sponsorParty + '\'' + 
			",scheme_payment_sub_type = '" + schemePaymentSubType + '\'' + 
			",processing_date = '" + processingDate + '\'' + 
			",charges_information = '" + chargesInformation + '\'' + 
			",numeric_reference = '" + numericReference + '\'' + 
			",end_to_end_reference = '" + endToEndReference + '\'' + 
			",reference = '" + reference + '\'' + 
			",fx = '" + fx + '\'' + 
			",payment_type = '" + paymentType + '\'' + 
			",beneficiary_party = '" + beneficiaryParty + '\'' + 
			",payment_purpose = '" + paymentPurpose + '\'' + 
			",payment_id = '" + paymentId + '\'' + 
			",currency = '" + currency + '\'' + 
			",scheme_payment_type = '" + schemePaymentType + '\'' + 
			"}";
		}
}
