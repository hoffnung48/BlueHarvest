package mx.com.blueharvest.commons.constant;

public enum EnumError {

	MANDATORY_PARAMETERES_MISSING("mandatoryParametersMissing"),

	EXPAND_ERROR("expandError"),

	PARAMETER_MISSING("parametersMissing"),

	WRONG_PARAMETERS("wrongParameters");
	
	
	private String alias;

	EnumError(final String alias) {
		this.alias = alias;
	}

}
