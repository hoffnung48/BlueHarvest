package mx.com.blueharvest.model.dto.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.model.dto.AccountDto;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ListAccountMapperTest {

	@InjectMocks
	private ListAccountMapper listAccountMapper;

	@Mock
	private AccountMapper accountMapper;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void mappToOuterTest() {
		List<Account> accounts = factory.manufacturePojo(List.class,Account.class);
		
		List<AccountDto> results = listAccountMapper.mappToOuter(accounts);

		assertNotNull(results);
		assertFalse(results.isEmpty());
	}

	@Test
	public void mappToOuterTestNull() {
		List<AccountDto> results = listAccountMapper.mappToOuter(null);

		assertNotNull(results);
		assertTrue(results.isEmpty());
	}
	
	@Test
	public void mappToOuterTestEmpty() {
		List<Account> accounts = new ArrayList<>();

		List<AccountDto> results = listAccountMapper.mappToOuter(accounts);
		
		assertNotNull(results);
		assertTrue(results.isEmpty());
	}

}
