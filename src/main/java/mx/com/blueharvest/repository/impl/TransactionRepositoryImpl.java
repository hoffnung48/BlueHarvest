package mx.com.blueharvest.repository.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.repository.keyholder.factory.KeyHolderFactory;
import mx.com.blueharvest.repository.mapper.TransactionMapper;

@Repository
public class TransactionRepositoryImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private KeyHolderFactory factory;

	public long createTransaction(Transaction transaction) {

		KeyHolder keyHolder = factory.newKeyHolder();

		jdbcTemplate.update(
	              connection -> {
	                  PreparedStatement ps = connection.prepareStatement("insert into transaction (accountId, amount,description) " + "values(?,?,?)", 
	                  new String[]{"TRANSACTIONID"});
	                  ps.setLong(1, transaction.getAccountId());
	                  ps.setBigDecimal(2, transaction.getAmount());
	                  ps.setString(3, transaction.getDescriptiont());
	                  return ps;
	              }, keyHolder);
		
		return keyHolder.getKey().longValue();
		    
	}

	public List<Transaction> getTransactionByAccountId(long accountId) {
		
		return jdbcTemplate.query("select * from transaction where accountId=?", 
				new Object[] {accountId}, 
				new TransactionMapper());	
	}
}
