package mx.com.blueharvest.model.dto.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.TransactionDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionMapperTest {

	@InjectMocks
	private TransactionMapper TransactionMapper;

	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void mappToOuterTest() {
		Transaction Transaction = factory.manufacturePojo(Transaction.class);
		TransactionDto result = TransactionMapper.mappToOuter(Transaction);

		assertNotNull(result);
		assertEquals(result.getTransactionId(), Transaction.getTransactionId());
		assertEquals(result.getAmount(), Transaction.getAmount());
		assertEquals(result.getDescriptiont(), Transaction.getDescriptiont());
		assertEquals(result.getStatus(), Transaction.getStatus());
		assertEquals(result.getType(), Transaction.getType());
		assertEquals(result.getAccountId(), Transaction.getAccountId());

	}

	@Test
	public void mappToOuterTestNull() {
		TransactionDto result = TransactionMapper.mappToOuter(null);

		assertNotNull(result);
	}
}
