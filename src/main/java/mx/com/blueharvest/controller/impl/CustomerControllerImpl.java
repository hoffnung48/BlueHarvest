package mx.com.blueharvest.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.blueharvest.commons.exception.BusinessServiceException;
import mx.com.blueharvest.commons.validator.Validator;
import mx.com.blueharvest.controller.CustomerController;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.service.CustomerService;

@Controller
public class CustomerControllerImpl implements CustomerController {


	@Autowired
	private CustomerService service;
	
	@Autowired
	private Validator validator;
	
	@ApiOperation(value = "transactions from an account", notes = "This endpoint returns campaigns", response = CustomerDto.class, tags={ "Customer"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The user details", response = CustomerDto.class),
        @ApiResponse(code = 204, message = "no content"),
        @ApiResponse(code = 400, message = "service not found"),
        @ApiResponse(code = 500, message = "Bussines service ERROR", response = BusinessServiceException.class) })
    @RequestMapping(value = "/customer/{customerId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
	@Override
	public ResponseEntity<CustomerDto> getcustomer(@PathVariable long customerId,@RequestParam("detail") boolean detail) {
		
		validator.isNull(customerId);
		
		return new ResponseEntity<CustomerDto>(service.getCustomerDetails(customerId,detail),HttpStatus.OK);
	}


}
