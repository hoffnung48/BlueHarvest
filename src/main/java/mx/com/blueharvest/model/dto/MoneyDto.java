package mx.com.blueharvest.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyDto {

	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("amount")
	private BigDecimal amount;
}
