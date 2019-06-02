package mx.com.blueharvest.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.blueharvest.entity.Customer;
import mx.com.blueharvest.entity.Money;
import mx.com.blueharvest.entity.Transaction;

public class TransactionMapper implements RowMapper<Transaction>{

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = new Transaction();
        transaction.setTransactionId(rs.getLong("transactionId"));
        transaction.setAccountId(rs.getLong("accountId"));
        transaction.setStatus(rs.getString("status"));
        transaction.setType(rs.getString("type"));
        transaction.setAmount(rs.getBigDecimal("amount"));
        transaction.setDescriptiont(rs.getString("description"));
        return transaction;
	}
}
