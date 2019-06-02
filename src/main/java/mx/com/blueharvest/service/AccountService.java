package mx.com.blueharvest.service;

import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.model.dto.URLDto;

public interface AccountService {

	URLDto createAccount(AccountDto account);

	AccountDto getAccount(long accountId);

}
