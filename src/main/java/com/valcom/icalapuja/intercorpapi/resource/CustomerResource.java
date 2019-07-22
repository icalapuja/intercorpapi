package com.valcom.icalapuja.intercorpapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;

import com.valcom.icalapuja.intercorpapi.util.Util;
import com.valcom.icalapuja.intercorpapi.entity.Customer;
import com.valcom.icalapuja.intercorpapi.service.CustomerService;


@Slf4j
@RestController
@RequestMapping("/api")
public class CustomerResource {
	private @Autowired CustomerService customerService;
	
	@PostMapping("/customers")
	@ResponseBody
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer) {
		log.info("addCustomer::init {} " + customer.toString());
		customer.setAge(Util.getAge(customer.getBirthDate()));
		
		ResponseBodyResource responseBodyResource = valData(customer);
		
		if(responseBodyResource.getStatus() == 200){
			customerService.addCustomer(customer);
			responseBodyResource.setMessage("Cliente agregado");
			return new ResponseEntity<>(responseBodyResource, HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest()
			        .contentType(MediaType.APPLICATION_JSON)
			        .body(responseBodyResource);
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<?> getDeathDate() {
		return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping("/statistics")
	public ResponseEntity<?> getStatistics() {
		return new ResponseEntity<>(customerService.getStatistics(),HttpStatus.OK);
	}
	
	private ResponseBodyResource valData(Customer customer) {
		ResponseBodyResource responseBodyResource = new ResponseBodyResource(200,"OK","");
		
		if(customer.getAge()< 18) {
			responseBodyResource.setStatus(400);
			responseBodyResource.setError("Bad Request");
			responseBodyResource.setMessage("El cliente no debe ser menor de edad");
		}
		
		return responseBodyResource;
	}
	
}
