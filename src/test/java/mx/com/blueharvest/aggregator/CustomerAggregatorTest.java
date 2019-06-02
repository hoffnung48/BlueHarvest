package mx.com.blueharvest.aggregator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.model.dto.TransactionDto;
import mx.com.blueharvest.model.dto.mapper.CustomerMapper;
import mx.com.blueharvest.model.dto.mapper.ListAccountMapper;
import mx.com.blueharvest.model.dto.mapper.ListTransactionMapper;
import mx.com.blueharvest.repository.CustomerRepository;
import mx.com.blueharvest.repository.impl.AccountRepositoryImpl;
import mx.com.blueharvest.repository.impl.TransactionRepositoryImpl;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


@RunWith(MockitoJUnitRunner.class)
public class CustomerAggregatorTest {

	@InjectMocks
	private CustomerAggregator customerAggregator;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private AccountRepositoryImpl accountRepository;

	@Mock
	private TransactionRepositoryImpl transactionRepositoryImpl;

	@Mock
	private ListAccountMapper listAccountMapper;

	@Mock
	private CustomerMapper customerMapper;

	@Mock
	private ListTransactionMapper listTransactionMapper;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void geCustomerDetailsTest() {

		Customer customer = factory.manufacturePojo(Customer.class);
		CustomerDto customerDto = factory.manufacturePojo(CustomerDto.class);

		when(customerRepository.getCustomerById(anyLong())).thenReturn(customer);
		when(customerMapper.mappToOuter(any(Customer.class))).thenReturn(customerDto);

		CustomerDto result = customerAggregator.geCustomerDetails(1, false);

		assertNotNull(result);
		assertEquals(customerDto,result);
		assertEquals(customerDto.getCustomerId(), result.getCustomerId());
	}
	
	@Test
	public void geCustomerDetailsDetailsTestDetail() {

		Customer customer = factory.manufacturePojo(Customer.class);
		CustomerDto customerDto = factory.manufacturePojo(CustomerDto.class);

		when(customerRepository.getCustomerById(anyLong())).thenReturn(customer);
		when(customerMapper.mappToOuter(any(Customer.class))).thenReturn(customerDto);
		when(accountRepository.geAccountsBytCustomerId(anyLong())).thenReturn(factory.manufacturePojo(List.class,Account.class));
		when(transactionRepositoryImpl.getTransactionByAccountId(anyLong())).thenReturn(factory.manufacturePojo(List.class,Transaction.class));
		when(listAccountMapper.mappToOuter(anyList())).thenReturn(factory.manufacturePojo(List.class,AccountDto.class));
		when(listTransactionMapper.mappToOuter(anyList())).thenReturn(factory.manufacturePojo(List.class,TransactionDto.class));
		
		CustomerDto result = customerAggregator.geCustomerDetails(1, true);

		assertNotNull(result);
		assertEquals(customerDto,result);
		assertEquals(customerDto.getCustomerId(), result.getCustomerId());
		assertNotNull(result.getBalance());
		assertFalse(result.getBalance().getAccounts().isEmpty());
		assertFalse(result.getBalance().getAccounts().get(0).getTransactons().isEmpty());
	}

}
