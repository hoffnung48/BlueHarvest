package mx.com.blueharvest.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.repository.mapper.CustomerMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRepositoryImplTest {

	@InjectMocks
	private CustomerRepositoryImpl customerRepositoryImpl;

	@Mock
	private JdbcTemplate jdbcTemplate;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void getCustomerByIdTest() {

		List<Customer> customers = factory.manufacturePojo(List.class,Customer.class);

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(CustomerMapper.class)))
				.thenReturn(customers);

		Customer result = customerRepositoryImpl.getCustomerById(1L);

		assertEquals(result, customers.get(0));
	}

	@Test
	public void getCustomerByIdTestNull() {

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(CustomerMapper.class)))
				.thenReturn(new ArrayList<>());

		Customer result = customerRepositoryImpl.getCustomerById(1);

		assertNull(result);
	}

}
