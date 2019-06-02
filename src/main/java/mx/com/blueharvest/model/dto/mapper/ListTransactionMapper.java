package mx.com.blueharvest.model.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.blueharvest.entity.Transaction;
import mx.com.blueharvest.model.dto.TransactionDto;

@Component
public class ListTransactionMapper {

	@Autowired
	private TransactionMapper transactionMapper;
	
	public List<TransactionDto> mappToOuter(List<Transaction> transactions) {

		List<TransactionDto> transactionsDto = new ArrayList<>();
		
		if (transactions != null) {
			for(Transaction transaction: transactions) {
				transactionsDto.add(transactionMapper.mappToOuter(transaction));
			}
		}

		return transactionsDto;
	}

}
