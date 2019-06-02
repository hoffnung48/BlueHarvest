package mx.com.blueharvest.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class CustomerDto {

	@JsonProperty("customerId")
	private long customerId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("surName")
	private String surName;

	@JsonProperty("balance")
	private BalanceDto balance;

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName
	 *            the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * @return the balance
	 */
	public BalanceDto getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(BalanceDto balance) {
		this.balance = balance;
	}

}
