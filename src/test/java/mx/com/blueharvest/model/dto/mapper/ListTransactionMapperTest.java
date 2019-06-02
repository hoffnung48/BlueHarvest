package mx.com.blueharvest.model.dto.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.TransactionDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ListTransactionMapperTest {

	@InjectMocks
	private ListTransactionMapper listTransactionMapper;

	@Mock
	private TransactionMapper transactionMapper;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void mappToOuterTest() {
		List<Transaction> transactions = factory.manufacturePojo(List.class,Transaction.class);
		List<TransactionDto> results = listTransactionMapper.mappToOuter(transactions);

		assertNotNull(results);
		assertFalse(results.isEmpty());
	}

	@Test
	public void mappToOuterTestNull() {
		List<TransactionDto> results = listTransactionMapper.mappToOuter(null);

		assertNotNull(results);
		assertTrue(results.isEmpty());
	}
	
	@Test
	public void mappToOuterTestEmpty() {
		List<TransactionDto> results = listTransactionMapper.mappToOuter(null);

		assertNotNull(results);
		assertTrue(results.isEmpty());
	}
}
