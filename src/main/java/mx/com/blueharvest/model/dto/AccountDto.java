package mx.com.blueharvest.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class AccountDto {

	@JsonProperty("customerId")
	private long customerId;

	@JsonProperty("accountId")
	private long accountId;

	@JsonProperty("initialCredit")
	private BigDecimal initialCredit;
	
	@JsonProperty("description")
	private String description;

	@JsonProperty("transactions")
	private List<TransactionDto> transactons;

	
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transactons
	 */
	public List<TransactionDto> getTransactons() {
		return transactons;
	}

	/**
	 * @param transactons
	 *            the transactons to set
	 */
	public void setTransactons(List<TransactionDto> transactons) {
		this.transactons = transactons;
	}

	/**
	 * @return the initialCredit
	 */
	public BigDecimal getInitialCredit() {
		return initialCredit;
	}

	/**
	 * @param initialCredit
	 *            the initialCredit to set
	 */
	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}

}
