package com.form3.payments.model;

import java.util.List;

public class ChargesInformation{
	private List<SenderChargesItem> senderCharges;
	private String bearerCode;
	private String receiverChargesAmount;
	private String receiverChargesCurrency;

	public void setSenderCharges(List<SenderChargesItem> senderCharges){
		this.senderCharges = senderCharges;
	}

	public List<SenderChargesItem> getSenderCharges(){
		return senderCharges;
	}

	public void setBearerCode(String bearerCode){
		this.bearerCode = bearerCode;
	}

	public String getBearerCode(){
		return bearerCode;
	}

	public void setReceiverChargesAmount(String receiverChargesAmount){
		this.receiverChargesAmount = receiverChargesAmount;
	}

	public String getReceiverChargesAmount(){
		return receiverChargesAmount;
	}

	public void setReceiverChargesCurrency(String receiverChargesCurrency){
		this.receiverChargesCurrency = receiverChargesCurrency;
	}

	public String getReceiverChargesCurrency(){
		return receiverChargesCurrency;
	}

	@Override
 	public String toString(){
		return 
			"ChargesInformation{" + 
			"sender_charges = '" + senderCharges + '\'' + 
			",bearer_code = '" + bearerCode + '\'' + 
			",receiver_charges_amount = '" + receiverChargesAmount + '\'' + 
			",receiver_charges_currency = '" + receiverChargesCurrency + '\'' + 
			"}";
		}
}