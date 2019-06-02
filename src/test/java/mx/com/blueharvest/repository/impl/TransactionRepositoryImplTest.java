package mx.com.blueharvest.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.repository.keyholder.factory.KeyHolderFactory;
import mx.com.blueharvest.repository.mapper.TransactionMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryImplTest {

	@InjectMocks
	private TransactionRepositoryImpl transactionRepositoryImpl;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private KeyHolderFactory holderFactory;

	@Mock
	private KeyHolder keyHolder;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void createTransaction() {
		Transaction transaction = factory.manufacturePojo(Transaction.class);

		when(holderFactory.newKeyHolder()).thenReturn(keyHolder);
		when(keyHolder.getKey()).thenReturn(1);

		long result = transactionRepositoryImpl.createTransaction(transaction);

		assertEquals(result, 1L);

	}

	@Test
	public void getTransactionByAccountId() {

		List<Transaction> transactions = new ArrayList<>();

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(TransactionMapper.class)))
				.thenReturn(transactions);

		List<Transaction> result = transactionRepositoryImpl.getTransactionByAccountId(1);

		assertEquals(result, transactions);
	}
}
