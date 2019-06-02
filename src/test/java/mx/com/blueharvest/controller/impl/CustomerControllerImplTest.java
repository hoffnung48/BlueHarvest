package mx.com.blueharvest.controller.impl;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyBoolean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import mx.com.blueharvest.commons.validator.Validator;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.service.CustomerService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerImplTest {

	@InjectMocks
	private CustomerControllerImpl customerControllerImpl;

	@Mock
	private CustomerService service;
	
	@Mock
	private Validator validator;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void getcustomer() {
		
		CustomerDto customer = factory.manufacturePojo(CustomerDto.class);
		
		when(service.getCustomerDetails(anyLong(), anyBoolean())).thenReturn(customer);
		
		ResponseEntity<CustomerDto> result =  customerControllerImpl.getcustomer(1, false);
		
		assertEquals(customer, result.getBody());
	}


}
