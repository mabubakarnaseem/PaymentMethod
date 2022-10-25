package com.example.paymentmethods.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentmethods.bo.PaymentBo;
import com.example.paymentmethods.bo.PaymentMethodBo;
import com.example.paymentmethods.dao.PaymentMethodsRepository;
import com.example.paymentmethods.entitiy.PaymentMethods;

@Service
public class PaymentMethodsService {

	@Autowired
	private PaymentMethodsRepository paymentMethodsRepository;
	@Autowired
	private ModelMapper modelMapper;

	public PaymentBo createPaymentMethod(PaymentBo paymentMethod) {

		// converting bo to entity
		List<PaymentMethods> paymentMethodRequest = paymentMethod.getPaymentMethods().stream()
				.map(x -> modelMapper.map(x, PaymentMethods.class)).collect(Collectors.toList());

		// saving a new single payment method
		PaymentMethods newPaymentMethod = paymentMethodsRepository.save(paymentMethodRequest.get(0));

		// converting entity to bo for response
		PaymentMethodBo payment = modelMapper.map(newPaymentMethod, PaymentMethodBo.class);

		return new PaymentBo(Arrays.asList(payment));

	}

	public PaymentBo getAllPaymentMethods() {

		List<PaymentMethodBo> paymentMethods = paymentMethodsRepository.findAll().stream()
				.map(paymentMethod -> modelMapper.map(paymentMethod, PaymentMethodBo.class))
				.collect(Collectors.toList());
		return new PaymentBo(paymentMethods);

	}

	public PaymentBo getPaymentMethodByName(String name) {

		List<PaymentMethods> paymentMethods = paymentMethodsRepository.findByName(name);
		List<PaymentMethodBo> payments = paymentMethods.stream().map(x -> modelMapper.map(x, PaymentMethodBo.class))
				.collect(Collectors.toList());

		return new PaymentBo(payments);

	}

	public PaymentBo getPaymentMethodById(Integer id) {

		PaymentMethods paymentMethods = paymentMethodsRepository.findById(id).orElseThrow();

		// converting entity to bo for response
		PaymentMethodBo payment = modelMapper.map(paymentMethods, PaymentMethodBo.class);

		return new PaymentBo(Arrays.asList(payment));
	}

	public PaymentBo updatePaymentMethod(int id, PaymentBo paymentMethod) {

		// converting bo to entity
		List<PaymentMethods> paymentMethodRequest = paymentMethod.getPaymentMethods().stream()
				.map(x -> modelMapper.map(x, PaymentMethods.class)).collect(Collectors.toList());

		PaymentMethods existingPaymentMethod = paymentMethodsRepository.findById(id).orElseThrow();
		if (existingPaymentMethod != null) {
			existingPaymentMethod = paymentMethodRequest.get(0);
			existingPaymentMethod.setId(id);
			paymentMethodsRepository.save(existingPaymentMethod);

		}

		// converting entity to bo for response
		PaymentMethodBo payment = modelMapper.map(existingPaymentMethod, PaymentMethodBo.class);

		return new PaymentBo(Arrays.asList(payment));
	}
}