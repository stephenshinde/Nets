package com.Utility.API;

import java.util.List;

/*Pojo Class*/
public class Payouts {
	
	private String id ;
	private String reference ;
	private String date ;
	private String bankAccountIban ;
	private String bankAccountBic ;
	private String currency ;
	private String amount ;
	private String chargedAmount ;
	private String numberOfCharges ;
	private String refundedAmount ;
	private String numberOfRefunds ;
	private String fees ;
	private String feeVATpercent ;
	private String feeTaxRate ;
	private String feeTaxAmount ;
	private List<TransactionDetails> transactionTaxDetails ;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBankAccountIban() {
		return bankAccountIban;
	}
	public void setBankAccountIban(String bankAccountIban) {
		this.bankAccountIban = bankAccountIban;
	}
	public String getBankAccountBic() {
		return bankAccountBic;
	}
	public void setBankAccountBic(String bankAccountBic) {
		this.bankAccountBic = bankAccountBic;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getChargedAmount() {
		return chargedAmount;
	}
	public void setChargedAmount(String chargedAmount) {
		this.chargedAmount = chargedAmount;
	}
	public String getNumberOfCharges() {
		return numberOfCharges;
	}
	public void setNumberOfCharges(String numberOfCharges) {
		this.numberOfCharges = numberOfCharges;
	}
	public String getRefundedAmount() {
		return refundedAmount;
	}
	public void setRefundedAmount(String refundedAmount) {
		this.refundedAmount = refundedAmount;
	}
	public String getNumberOfRefunds() {
		return numberOfRefunds;
	}
	public void setNumberOfRefunds(String numberOfRefunds) {
		this.numberOfRefunds = numberOfRefunds;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getFeeVATpercent() {
		return feeVATpercent;
	}
	public void setFeeVATpercent(String feeVATpercent) {
		this.feeVATpercent = feeVATpercent;
	}
	public String getFeeTaxRate() {
		return feeTaxRate;
	}
	public void setFeeTaxRate(String feeTaxRate) {
		this.feeTaxRate = feeTaxRate;
	}
	public String getFeeTaxAmount() {
		return feeTaxAmount;
	}
	public void setFeeTaxAmount(String feeTaxAmount) {
		this.feeTaxAmount = feeTaxAmount;
	}
	public List<TransactionDetails> getTransactionTaxDetails() {
		return transactionTaxDetails;
	}
	public void setTransactionTaxDetails(List<TransactionDetails> transactionTaxDetails) {
		this.transactionTaxDetails = transactionTaxDetails;
	}
	
	
	
	

}
