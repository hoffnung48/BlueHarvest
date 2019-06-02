package mx.com.blueharvest.repository;

import mx.com.blueharvest.entity.Customer;

public interface CustomerRepository {

	Customer getCustomerById(long customerId);
	
}
