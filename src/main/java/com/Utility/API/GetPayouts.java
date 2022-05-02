package com.Utility.API;

import java.util.List;

public class GetPayouts {
	
	public String numberOfPayouts ;
	public List<Payouts> payouts ;
	
	public String getNumberOfPayouts() {
		return numberOfPayouts;
	}
	public void setNumberOfPayouts(String numberOfPayouts) {
		this.numberOfPayouts = numberOfPayouts;
	}
	public List<Payouts> getPayouts() {
		return payouts;
	}
	public void setPayouts(List<Payouts> payouts) {
		this.payouts = payouts;
	}
	

}
