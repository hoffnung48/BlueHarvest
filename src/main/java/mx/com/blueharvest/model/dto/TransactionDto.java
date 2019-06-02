package mx.com.blueharvest.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")

public class TransactionDto {
	
	@JsonProperty("accountId")
	private long accountId;

	@JsonProperty("transactiontId")
	private long transactionId;
	
	@JsonProperty("status")
	private String status;

	@JsonProperty("type")
	private String type;

	@JsonProperty("amount")
	private BigDecimal amount;

	@JsonProperty("description")
	private String descriptiont;

	/**
	 * @return the accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the descriptiont
	 */
	public String getDescriptiont() {
		return descriptiont;
	}

	/**
	 * @param descriptiont the descriptiont to set
	 */
	public void setDescriptiont(String descriptiont) {
		this.descriptiont = descriptiont;
	}

	

}
