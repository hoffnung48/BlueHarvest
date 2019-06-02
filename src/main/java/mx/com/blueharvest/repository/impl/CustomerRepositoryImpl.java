package mx.com.blueharvest.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.repository.CustomerRepository;
import mx.com.blueharvest.repository.mapper.CustomerMapper;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer getCustomerById(long customerId) {
		
		List<Customer> customers = jdbcTemplate.query("select * from customer where customerId=?", new Object[] {customerId}, 
				new CustomerMapper());
		
		return customers.isEmpty() ? null : customers.get(0);
	}

}
