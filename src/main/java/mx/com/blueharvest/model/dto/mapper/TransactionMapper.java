package mx.com.blueharvest.model.dto.mapper;

import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.TransactionDto;

@Component
public class TransactionMapper {

	public TransactionDto mappToOuter(Transaction transaction) {

		TransactionDto outer = new TransactionDto();
		if (transaction != null) {
			outer.setAccountId(transaction.getAccountId());
			outer.setTransactionId(transaction.getTransactionId());
			outer.setAmount(transaction.getAmount());
			outer.setDescriptiont(transaction.getDescriptiont());
			outer.setStatus(transaction.getStatus());
			outer.setType(transaction.getType());
		}
		return outer;

	}
}
