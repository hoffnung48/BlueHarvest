package mx.com.blueharvest.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.URLDto;
import mx.com.blueharvest.model.dto.mapper.AccountMapper;
import mx.com.blueharvest.repository.impl.AccountRepositoryImpl;
import mx.com.blueharvest.repository.impl.TransactionRepositoryImpl;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;

	@Mock
	private AccountRepositoryImpl accountRepository;

	@Mock
	private TransactionRepositoryImpl transactionRepositoryImpl;

	@Mock
	private AccountMapper accountMapper;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void createAccountTest() {

		Account account = factory.manufacturePojo(Account.class);
		AccountDto accountDto = factory.manufacturePojo(AccountDto.class);
		accountDto.setInitialCredit(new BigDecimal(1));
		
		when(accountMapper.mappToInner(any(AccountDto.class))).thenReturn(account);
		when(accountRepository.createAccount(any(Account.class))).thenReturn(1L);
		
		URLDto result = accountServiceImpl.createAccount(accountDto);
		
		assertEquals(result.getResourceId(), 1);
	}

	@Test
	public void createAccountTestInitialCreditNull() {

		Account account = factory.manufacturePojo(Account.class);
		AccountDto accountDto = factory.manufacturePojo(AccountDto.class);
		accountDto.setInitialCredit(null);
		
		when(accountMapper.mappToInner(any(AccountDto.class))).thenReturn(account);
		when(accountRepository.createAccount(any(Account.class))).thenReturn(1L);
		
		URLDto result = accountServiceImpl.createAccount(accountDto);
		
		assertEquals(result.getResourceId(), 1);
	}

	@Test
	public void createAccountTestInitialCreditZero() {
		Account account = factory.manufacturePojo(Account.class);
		AccountDto accountDto = factory.manufacturePojo(AccountDto.class);
		accountDto.setInitialCredit(new BigDecimal(0));
		
		when(accountMapper.mappToInner(any(AccountDto.class))).thenReturn(account);
		when(accountRepository.createAccount(any(Account.class))).thenReturn(1L);
		
		URLDto result = accountServiceImpl.createAccount(accountDto);
		
		assertEquals(result.getResourceId(), 1);
	}

	@Test
	public void getAccountTest() {
		
		Account account = factory.manufacturePojo(Account.class);
		AccountDto accountDto = factory.manufacturePojo(AccountDto.class);
		
		when(accountRepository.geAccountBytCustomerId(anyLong())).thenReturn(account);
		when(accountMapper.mappToOuter(any(Account.class))).thenReturn(accountDto);
		
		AccountDto result = accountServiceImpl.getAccount(1);
		
		assertEquals(accountDto, result);
		
		
	}

}
