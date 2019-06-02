package mx.com.blueharvest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.URLDto;
import mx.com.blueharvest.model.dto.mapper.AccountMapper;
import mx.com.blueharvest.model.enumeration.AccountType;
import mx.com.blueharvest.repository.impl.AccountRepositoryImpl;
import mx.com.blueharvest.repository.impl.TransactionRepositoryImpl;
import mx.com.blueharvest.service.AccountService;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepositoryImpl accountRepository;

	@Autowired
	private TransactionRepositoryImpl transactionRepositoryImpl;

	@Autowired
	private AccountMapper accountMapper;

	@Value("${base.url}")
	private String baseURL;
	
	@Value("${resource.account}")
	private String resource;
	
	@Value("${transaction.default.description}")
	private String transactionDescription;
	

	@Override
	public URLDto createAccount(AccountDto account) {
		
		account.setDescription(AccountType.CURRENT_ACCOUNT.toString());

		Long accountId = accountRepository.createAccount(accountMapper.mappToInner(account));

		if (account.getInitialCredit() != null && account.getInitialCredit().intValue() > 0) {

			transactionRepositoryImpl.createTransaction(
					new Transaction(accountId, account.getInitialCredit(), transactionDescription));
		}

		return buildUrlDto(accountId);
	}

	private URLDto buildUrlDto(long accountId) {
		URLDto urlDto = new  URLDto();
		urlDto.setBaseUrl(baseURL);
		urlDto.setResource(resource);
		urlDto.setResourceId(accountId);
		urlDto.setResourceUrl(baseURL + resource + accountId);
		return urlDto;
	}

	@Override
	public AccountDto getAccount(long accountId) {
		return accountMapper.mappToOuter(accountRepository.geAccountBytCustomerId(accountId));
	}

}
