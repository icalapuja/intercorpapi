package com.valcom.icalapuja.intercorpapi.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcom.icalapuja.intercorpapi.entity.*;
import com.valcom.icalapuja.intercorpapi.repository.ICustomerRepository;
import com.valcom.icalapuja.intercorpapi.util.Util;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;
	
	
	@Override
	public void addCustomer(Customer entity) {
		customerRepository.save(entity);
	}

	@Override
	public List<Customer> getAllCustomer() {

		List<Customer> customers = customerRepository.findAll();

		for(Customer customer : customers) {
			customer.setDeathDate(Util.getDeathDate());
		}
		
		return customers;
		
	}

	@Override
	public HashMap<String, Double> getStatistics() {
		int[] ages = getAges(getAllCustomer());

		HashMap<String, Double> map = new HashMap<>();
		map.put("media", Util.getMedia(ages));
        map.put("standarDeviation", Util.getStandarDeviation(ages));
        
        return map;
	}

	private int[] getAges(List<Customer> customers) {
		int i = 0;
		int[] edades = new int[customers.size()];
		
		for(Customer customer : customers) {
			edades[i] = customer.getAge();
			i++;
		}
		
		return edades;
	}

}
