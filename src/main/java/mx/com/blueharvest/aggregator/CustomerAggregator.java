package mx.com.blueharvest.aggregator;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.BalanceDto;
import mx.com.blueharvest.model.dto.CustomerDto;
import mx.com.blueharvest.model.dto.mapper.CustomerMapper;
import mx.com.blueharvest.model.dto.mapper.ListAccountMapper;
import mx.com.blueharvest.model.dto.mapper.ListTransactionMapper;
import mx.com.blueharvest.repository.CustomerRepository;
import mx.com.blueharvest.repository.impl.AccountRepositoryImpl;
import mx.com.blueharvest.repository.impl.TransactionRepositoryImpl;

@Component
public class CustomerAggregator {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepositoryImpl accountRepository;

	@Autowired
	private TransactionRepositoryImpl transactionRepositoryImpl;

	@Autowired
	private ListAccountMapper listAccountMapper;

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private ListTransactionMapper listTransactionMapper;

	public CustomerDto geCustomerDetails(long customerId, boolean details) {

		Customer customer = customerRepository.getCustomerById(customerId);
		CustomerDto customerDto = customerMapper.mappToOuter(customer);

		if (details) {
			BalanceDto balance = new BalanceDto();
			balance.setBalance(new BigDecimal(0));

			List<Account> accounts = accountRepository.geAccountsBytCustomerId(customerId);
			balance.setAccounts(listAccountMapper.mappToOuter(accounts));

			for (AccountDto account : balance.getAccounts()) {
				List<Transaction> transactions = transactionRepositoryImpl
						.getTransactionByAccountId(account.getAccountId());
				account.setTransactons(listTransactionMapper.mappToOuter(transactions));
				balance.setBalance(balance.getBalance().add(account.getInitialCredit()));
			}

			customerDto.setBalance(balance);
		}

		return customerDto;
	}

}
