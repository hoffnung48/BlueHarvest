package mx.com.blueharvest.model.dto.mapper;

import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.model.dto.CustomerDto;

@Component
public class CustomerMapper {

	public CustomerDto mappToOuter(Customer customer) {

		CustomerDto outer = new CustomerDto();
		
		if (customer != null) {	
			outer.setCustomerId(customer.getCustomerId());
			outer.setName(customer.getName());
			outer.setSurName(customer.getSurName());
		}
		
		return outer;

	}

}
