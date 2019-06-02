package mx.com.blueharvest.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.blueharvest.entity.Customer;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
        customer.setCustomerId(rs.getLong("customerId"));
        customer.setName(rs.getString("name"));
        customer.setSurName(rs.getString("surname"));
        return customer;
	}

}
