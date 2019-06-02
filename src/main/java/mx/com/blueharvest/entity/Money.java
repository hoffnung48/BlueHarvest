package mx.com.blueharvest.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Money {

	private String currency;
	
	private BigDecimal amount;
}
