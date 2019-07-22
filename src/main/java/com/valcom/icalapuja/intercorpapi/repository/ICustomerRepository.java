package com.valcom.icalapuja.intercorpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valcom.icalapuja.intercorpapi.entity.Customer;

public interface ICustomerRepository  extends JpaRepository<Customer, Long>{

}
