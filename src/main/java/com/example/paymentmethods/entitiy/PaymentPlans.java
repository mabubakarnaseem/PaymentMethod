package com.example.paymentmethods.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaymentPlans {
	@Id
	@GeneratedValue
	private int id;
	private float netAmount;
	private float taxAmount;
	private float grossAmount;
	private String currency;
	private String duration;

	public PaymentPlans(float netAmount, float taxAmount, float grossAmount, String currency, String duration) {
		super();
		this.netAmount = netAmount;
		this.taxAmount = taxAmount;
		this.grossAmount = grossAmount;
		this.currency = currency;
		this.duration = duration;
	}

	public PaymentPlans() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public float getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(float grossAmount) {
		this.grossAmount = grossAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}