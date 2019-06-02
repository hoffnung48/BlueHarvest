package mx.com.blueharvest.model.dto.mapper;

import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.model.dto.AccountDto;

@Component
public class AccountMapper {

	public Account mappToInner(AccountDto account) {

		Account inner = new Account();

		if (account != null) {
			inner.setAccountId(account.getAccountId());
			inner.setCustomerId(account.getCustomerId());
			inner.setInitialCredit(account.getInitialCredit());
			inner.setDescription(account.getDescription());
		}
		
		return inner;

	}

	public AccountDto mappToOuter(Account account) {

		AccountDto outer = new AccountDto();

		if (account != null) {
			outer.setAccountId(account.getAccountId());
			outer.setCustomerId(account.getCustomerId());
			outer.setInitialCredit(account.getInitialCredit());
			outer.setDescription(account.getDescription());
		}
		return outer;

	}

}
