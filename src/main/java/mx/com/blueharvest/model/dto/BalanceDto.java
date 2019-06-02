package mx.com.blueharvest.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class BalanceDto {

	@JsonProperty("balance")
	private BigDecimal balance;
	
	@JsonProperty("accounts")
	private List<AccountDto> accounts;

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return the accounts
	 */
	public List<AccountDto> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}
	
	
}
