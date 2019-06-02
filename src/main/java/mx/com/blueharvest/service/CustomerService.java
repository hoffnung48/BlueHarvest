package mx.com.blueharvest.service;

import mx.com.blueharvest.model.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomerDetails(long customerId, boolean detail);

}
