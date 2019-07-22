package com.valcom.icalapuja.intercorpapi.service;

import java.util.HashMap;
import java.util.List;
import com.valcom.icalapuja.intercorpapi.entity.*;

public interface ICustomerService {
	void addCustomer(Customer entity);
	List<Customer> getAllCustomer();
	HashMap<String, Double> getStatistics();
}
