package com.javatechie.springdatajpademo.repository;

import com.javatechie.springdatajpademo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}
