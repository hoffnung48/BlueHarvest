package mx.com.blueharvest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.blueharvest.aggregator.CustomerAggregator;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerAggregator customerAggregator;

	@Override
	public CustomerDto getCustomerDetails(long customerId,boolean details) {
		return customerAggregator.geCustomerDetails(customerId,details);
	}


}
