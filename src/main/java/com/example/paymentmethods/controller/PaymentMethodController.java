package com.example.paymentmethods.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentmethods.bo.PaymentBo;
import com.example.paymentmethods.service.PaymentMethodsService;

@RestController
@RequestMapping("api/v1.0/configuration")
public class PaymentMethodController {

	@Autowired
	private PaymentMethodsService paymentMethodsService;

	@PostMapping("/payment-methods")
	public ResponseEntity<PaymentBo> createPaymentMethod(@Valid @RequestBody PaymentBo paymentMethods) {

		return new ResponseEntity<PaymentBo>(paymentMethodsService.createPaymentMethod(paymentMethods),
				HttpStatus.CREATED);
	}

	@GetMapping("/payment-methods")
	public ResponseEntity<PaymentBo> getAllPaymentMethods() {

		return ResponseEntity.ok().body(paymentMethodsService.getAllPaymentMethods());
	}

	@GetMapping("/payment-methods-by-name")
	public ResponseEntity<PaymentBo> getPaymentMethodsByName(
			@RequestParam(required = true, name = "name") String name) {

		return ResponseEntity.ok().body(paymentMethodsService.getPaymentMethodByName(name));
	}

	@GetMapping("/payment-methods-by-id")
	public ResponseEntity<PaymentBo> getPaymentMethodsByName(@RequestParam(required = true, name = "id") Integer id) {

		return ResponseEntity.ok().body(paymentMethodsService.getPaymentMethodById(id));
	}

	@PutMapping("/payment-methods/{id}")
	public ResponseEntity<PaymentBo> updatePaymentMethod(@PathVariable(required = true, name = "id") Integer id,
			@Valid @RequestBody PaymentBo paymentMethods) {

		return ResponseEntity.ok().body(paymentMethodsService.updatePaymentMethod(id, paymentMethods));
	}

}