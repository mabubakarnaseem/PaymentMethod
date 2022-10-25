package com.example.paymentmethods.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class PaymentBo {

	private List<PaymentMethodBo> paymentMethods;

	public PaymentBo(List<PaymentMethodBo> paymentMethods) {
		super();
		this.paymentMethods = paymentMethods;
	}

	public PaymentBo() {
		super();
	}

	public List<PaymentMethodBo> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethodBo> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

}