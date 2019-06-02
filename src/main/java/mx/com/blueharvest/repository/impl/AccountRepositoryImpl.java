package mx.com.blueharvest.repository.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.repository.keyholder.factory.KeyHolderFactory;
import mx.com.blueharvest.repository.mapper.AccountMapper;

@Repository
public class AccountRepositoryImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private KeyHolderFactory factory;
	
	
	public long createAccount(Account account) {

		KeyHolder keyHolder = factory.newKeyHolder();
		
		jdbcTemplate.update(
	              connection -> {
	                  PreparedStatement ps = connection.prepareStatement("insert into account(customerId, initialCredit, description) values(?, ?, ?)", 
	                  new String[]{"ACCOUNTID"});
	                  ps.setLong(1, account.getCustomerId());
	                  ps.setBigDecimal(2, account.getInitialCredit() == null ? new BigDecimal(0) : account.getInitialCredit());
	                  ps.setString(3, account.getDescription());
	                  return ps;
	              }, keyHolder);

		return (long) keyHolder.getKey();
	}

	public List<Account> geAccountsBytCustomerId(long customerId) {

		return jdbcTemplate.query("select * from account where customerId=?", new Object[] { customerId },
				new AccountMapper());
	}

	public Account geAccountBytCustomerId(long customerId) {

		List<Account> accounts = jdbcTemplate
				.query("select * from account where accountId=?", new Object[] { customerId }, new AccountMapper());
		
		return accounts.isEmpty() ? null : accounts.get(0); 
	}
}
