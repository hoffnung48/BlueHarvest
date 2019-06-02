package mx.com.blueharvest.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.URLDto;

public interface AccountController {
	
	ResponseEntity<URLDto> createAccount(AccountDto account);

	ResponseEntity<AccountDto> getAccount(long accountId);
}