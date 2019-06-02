package mx.com.blueharvest.repository.mapper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.blueharvest.entity.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountMapperTest {
	
	@InjectMocks
	private AccountMapper AccountMapper;

	@Mock
	private ResultSet rs;
	
	@Test
	public void mapRowTest() throws SQLException{
		
		Account account = AccountMapper.mapRow(rs, 1);
		
		assertNotNull(account);
	}
	
	@Test(expected=SQLException.class)
	public void mapRowTestException() throws SQLException{
	
		when(rs.getLong(anyString())).thenThrow(new SQLException());
		
		Account account = AccountMapper.mapRow(rs, 1);
	
	}

}
