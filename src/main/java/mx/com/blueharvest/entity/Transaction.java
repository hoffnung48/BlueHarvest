package mx.com.blueharvest.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction
 */
public class Transaction {

	private long transactionId;
	private long accountId;
	private String status;
	private String type;
	private BigDecimal amount;
	private String descriptiont;

	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	public Transaction( long accountId, BigDecimal amount, String descriptiont) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.descriptiont = descriptiont;
	}
	
	public Transaction() {
		
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
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
	 * @param type
	 *            the type to set
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
	 * @param amount
	 *            the amount to set
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
	 * @param descriptiont
	 *            the descriptiont to set
	 */
	public void setDescriptiont(String descriptiont) {
		this.descriptiont = descriptiont;
	}

}
