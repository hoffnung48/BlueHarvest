package mx.com.blueharvest.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.aggregator.CustomerAggregator;
import mx.com.blueharvest.model.dto.CustomerDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest  {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Mock
	private CustomerAggregator customerAggregator;
	
	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void getCustomerDetailsTest() {
		CustomerDto customer = factory.manufacturePojo(CustomerDto.class);
		
		when(customerAggregator.geCustomerDetails(anyLong(), anyBoolean())).thenReturn(customer);
		
		CustomerDto result = customerServiceImpl.getCustomerDetails(1, false);
		
		assertNotNull(result);
	}

	@Test
	public void getCustomerDetailsTestDetailTrue() {
		CustomerDto customer = factory.manufacturePojo(CustomerDto.class);
		
		when(customerAggregator.geCustomerDetails(anyLong(), anyBoolean())).thenReturn(customer);
		
		CustomerDto result = customerServiceImpl.getCustomerDetails(1, true);
		
		assertNotNull(result);
	}

}
