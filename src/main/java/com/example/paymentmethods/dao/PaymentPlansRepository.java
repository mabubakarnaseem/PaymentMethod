package com.example.paymentmethods.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentmethods.entitiy.PaymentPlans;

@Repository
public interface PaymentPlansRepository extends JpaRepository<PaymentPlans, Integer> {

}