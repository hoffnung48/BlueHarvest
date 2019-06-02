package mx.com.blueharvest.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.repository.keyholder.factory.KeyHolderFactory;
import mx.com.blueharvest.repository.mapper.AccountMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryImplTest {

	@InjectMocks
	private AccountRepositoryImpl accountRepositoryImpl;
	
	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private KeyHolderFactory holderFactory;
	
	@Mock
	private KeyHolder keyHolder;

	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void createAccountTest() {
		Account account= factory.manufacturePojo(Account.class);
		
		when(holderFactory.newKeyHolder()).thenReturn(keyHolder);
		when(keyHolder.getKey()).thenReturn(1L);
		
		long result = accountRepositoryImpl.createAccount(account);
		
		assertEquals(result, 1);
	}

	@Test
	public void geAccountsBytCustomerIdTest() {
		
		List<Account> accounts = new ArrayList<>();;

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountMapper.class))).thenReturn(accounts);
		
		List<Account> result = accountRepositoryImpl.geAccountsBytCustomerId(1);
		
		assertEquals(result,accounts);
	}

	@Test
	public void geAccountBytCustomerIdTest() {

		List<Account> accounts = factory.manufacturePojo(List.class,Account.class);

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountMapper.class))).thenReturn(accounts);
		
		Account result = accountRepositoryImpl.geAccountBytCustomerId(1);
		
		assertEquals(result,accounts.get(0));
	}

}
