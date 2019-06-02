package mx.com.blueharvest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.CustomerDto;

public interface CustomerController {
	
	ResponseEntity<CustomerDto> getcustomer(long id,boolean detail);

}