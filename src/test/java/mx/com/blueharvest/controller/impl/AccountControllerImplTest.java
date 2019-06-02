package mx.com.blueharvest.controller.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import mx.com.blueharvest.commons.exception.BusinessServiceException;
import mx.com.blueharvest.commons.validator.Validator;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.URLDto;
import mx.com.blueharvest.service.AccountService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerImplTest {
	
	@InjectMocks
	private AccountControllerImpl accountControllerImpl;

	@Mock
	private AccountService service;

	@Mock
	private Validator validator;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void createAccountTest() {
    
		URLDto url = factory.manufacturePojo(URLDto.class);
		
    	when(service.createAccount(any(AccountDto.class))).thenReturn(url);
    	
    	ResponseEntity<URLDto> result = accountControllerImpl.createAccount(new AccountDto());
    	
    	assertEquals(url.getResourceId(), result.getBody().getResourceId());
	}
	
	@Test(expected=BusinessServiceException.class)
	public void createAccountTestException() {
    
		URLDto url = factory.manufacturePojo(URLDto.class);
		
    	when(service.createAccount(any(AccountDto.class))).thenThrow(new BusinessServiceException(""));
    	
    	ResponseEntity<URLDto> result = accountControllerImpl.createAccount(new AccountDto());
	}
	
	@Test(expected=BusinessServiceException.class)
	public void createAccountTestAccountNull() {
		
		AccountDto account = null;
    
		URLDto url = factory.manufacturePojo(URLDto.class);
		
    	doThrow(new BusinessServiceException("")).when(validator).isNull(null);
    	
    	ResponseEntity<URLDto> result = accountControllerImpl.createAccount(account);
	}

	@Test
	public void getAccountTest() {
		
		AccountDto account = factory.manufacturePojo(AccountDto.class);
		
		when(service.getAccount(anyLong())).thenReturn(account);
		
		ResponseEntity<AccountDto> result = accountControllerImpl.getAccount(1);
		
		assertEquals(result.getBody(), account);
	}

}
