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
import org.springframework.jdbc.core.RowMapper;

import mx.com.blueharvest.entity.Account;
import mx.com.blueharvest.entity.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMapperTest {

	@InjectMocks
	private CustomerMapper customerMapper;

	@Mock
	private ResultSet rs;
	
	@Test
	public void mapRowTest() throws SQLException{
		
		Customer customer = customerMapper.mapRow(rs, 1);
		
		assertNotNull(customer);
	}
	
	@Test(expected=SQLException.class)
	public void mapRowTestException() throws SQLException{
	
		when(rs.getLong(anyString())).thenThrow(new SQLException());
		
		Customer customer = customerMapper.mapRow(rs, 1);
	
	}


}
