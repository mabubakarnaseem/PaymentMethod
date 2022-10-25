package com.example.paymentmethods.entitiy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PaymentMethods {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String paymentType;
	private String displayName;
	@OneToMany(targetEntity = PaymentPlans.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "pm_fk", referencedColumnName = "id")
	private List<PaymentPlans> paymentPlans;

	public PaymentMethods(String name, String paymentType, List<PaymentPlans> paymentPlans) {
		super();
		this.name = name;
		this.paymentType = paymentType;
		this.paymentPlans = paymentPlans;
	}

	public PaymentMethods() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<PaymentPlans> getPaymentPlans() {
		return paymentPlans;
	}

	public void setPaymentPlans(List<PaymentPlans> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}