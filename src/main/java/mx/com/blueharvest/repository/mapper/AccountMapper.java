package mx.com.blueharvest.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.blueharvest.entity.Account;

public class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

		Account account = new Account();
		account.setCustomerId(rs.getLong("customerId"));
		account.setAccountId(rs.getLong("accountId"));
		account.setInitialCredit(rs.getBigDecimal("initialCredit"));
		account.setDescription(rs.getString("initialCredit"));
		return account;

	}

}
