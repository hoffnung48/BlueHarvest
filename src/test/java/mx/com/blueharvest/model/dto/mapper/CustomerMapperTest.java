package mx.com.blueharvest.model.dto.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.model.dto.CustomerDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMapperTest {

	@InjectMocks
	private CustomerMapper customerMapper;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void mappToOuterTest() {
		Customer customer = factory.manufacturePojo(Customer.class);
		CustomerDto result = customerMapper.mappToOuter(customer);

		assertNotNull(result);
		assertEquals(result.getCustomerId(), customer.getCustomerId());
		assertEquals(result.getName(), customer.getName());
		assertEquals(result.getSurName(), customer.getSurName());
	}

	@Test
	public void mappToOuterTestNull() {
		CustomerDto result = customerMapper.mappToOuter(null);

		assertNotNull(result);
	}

}
