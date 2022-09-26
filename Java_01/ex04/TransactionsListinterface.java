
import java.util.UUID;

public interface TransactionsListinterface{
	void	addTransaction(Transaction newTransaction);
	void	deleteTransaction(UUID Id);
	Transaction []getTransactionArray();
}
