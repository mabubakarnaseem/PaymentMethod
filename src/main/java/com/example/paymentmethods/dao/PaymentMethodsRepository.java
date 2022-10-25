package com.example.paymentmethods.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentmethods.entitiy.PaymentMethods;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	List<PaymentMethods> findByName(String name);
}