package mx.com.blueharvest.repository.keyholder.factory.impl;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import mx.com.blueharvest.repository.keyholder.factory.KeyHolderFactory;

@Component
public class KeyHolderFactoryImpl implements KeyHolderFactory {

	@Override
	public KeyHolder newKeyHolder() {
		return new GeneratedKeyHolder();
	}

}
