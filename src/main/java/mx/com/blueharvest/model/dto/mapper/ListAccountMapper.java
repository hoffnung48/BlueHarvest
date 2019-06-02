package mx.com.blueharvest.model.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.model.dto.AccountDto;

@Component
public class ListAccountMapper {

	@Autowired
	private AccountMapper accountMapper;
	
	public List<AccountDto> mappToOuter(List<Account> accounts) {

		List<AccountDto> accountsDto = new ArrayList<>();
		
		if (accounts != null) {
			for(Account account: accounts) {
				accountsDto.add(accountMapper.mappToOuter(account));
			}
		}

		return accountsDto;
	}

}
