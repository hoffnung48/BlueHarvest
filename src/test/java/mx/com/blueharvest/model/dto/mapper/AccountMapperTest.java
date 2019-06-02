package mx.com.blueharvest.model.dto.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.model.dto.AccountDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountMapperTest {

	@InjectMocks
	private AccountMapper accountMapper;

	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void mappToInnerTest() {

		AccountDto account = factory.manufacturePojo(AccountDto.class);
		Account result = accountMapper.mappToInner(account);

		assertNotNull(result);
		assertEquals(result.getAccountId(), account.getAccountId());
		assertEquals(result.getCustomerId(), account.getCustomerId());
		assertEquals(result.getDescription(), account.getDescription());
		assertEquals(result.getInitialCredit(), account.getInitialCredit());
	}

	@Test
	public void mappToInnerTestNull() {
		Account result = accountMapper.mappToInner(null);

		assertNotNull(result);
	}

	@Test
	public void mappToOuterTest() {
		Account account = factory.manufacturePojo(Account.class);
		AccountDto result = accountMapper.mappToOuter(account);

		assertNotNull(result);
		assertEquals(result.getAccountId(), account.getAccountId());
		assertEquals(result.getCustomerId(), account.getCustomerId());
		assertEquals(result.getDescription(), account.getDescription());
		assertEquals(result.getInitialCredit(), account.getInitialCredit());
	}

	@Test
	public void mappToOuterTestNull() {
		AccountDto result = accountMapper.mappToOuter(null);
		assertNotNull(result);
	}

}
