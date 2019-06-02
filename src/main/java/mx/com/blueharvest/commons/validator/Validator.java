package mx.com.blueharvest.commons.validator;

import org.springframework.stereotype.Component;

import mx.com.blueharvest.commons.constant.EnumError;
import mx.com.blueharvest.commons.exception.BusinessServiceException;

@Component
public class Validator {

	public void isEmptyOrNull(String string) {
		if (string == null || string.isEmpty()) {
			this.throwWrongParameters();
		}
	}

	public void isNull(Object object) {
		if (object == null) {
			this.throwWrongParameters();
		}
	}
	
	public void throwWrongParameters () {
		throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.name());
	}

}
