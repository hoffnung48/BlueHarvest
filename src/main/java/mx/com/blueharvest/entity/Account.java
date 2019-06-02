package mx.com.blueharvest.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Account
 */
public class Account {

	private long accountId;
	private long customerId;
	private BigDecimal initialCredit;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
