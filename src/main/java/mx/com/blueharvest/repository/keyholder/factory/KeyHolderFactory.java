package mx.com.blueharvest.repository.keyholder.factory;

import org.springframework.jdbc.support.KeyHolder;

public interface KeyHolderFactory {

	/**
	 * This is factory method for creating new {@link KeyHolder}.
	 * 
	 * @return the new {@link KeyHolder} instance.
	 */
	KeyHolder newKeyHolder();
	
}
