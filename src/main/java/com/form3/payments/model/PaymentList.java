package com.form3.payments.model;

import java.util.List;

public class PaymentList{
	private List<Payment> data;
	private Links links;

	public void setData(List<Payment> data){
		this.data = data;
	}

	public List<Payment> getData(){
		return data;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	@Override
 	public String toString(){
		return 
			"PaymentList{" + 
			"data = '" + data + '\'' + 
			",links = '" + links + '\'' + 
			"}";
		}
}