

import javax.jws.soap.SOAPBinding;
import java.util.UUID;

public class TransactionsService {
	private UsersArrayList UserList;
	public TransactionList Transfers;

	public void addUser(User newUser){
		this.UserList.addUser(newUser);
	}

	public TransactionsService() {
		UserList = new UsersArrayList();
		Transfers = new TransactionList();
	}

	public int getUserBalance(int Id){
		return (UserList.getUserId(Id).getBalance());
	}

	public void CreateTransaction(User Recipient, User Sender, int Amount){
		Transaction Credit = new Transaction(Recipient, Sender, "CREDIT", -Amount);
		Transaction Debit = new Transaction(Recipient, Sender, "DEBIT", Amount);
		Debit.setTwin(Credit);
		Credit.setTwin(Debit);
		Debit.setIdentifier(Credit.getIdentifier());
		Transaction Credit2 = new Transaction(Recipient, Sender, "CREDIT", -Amount);
		Recipient.list.addTransaction(Debit);
		Sender.list.addTransaction(Credit);
		Transfers.addTransaction(Debit);
		Transfers.addTransaction(Credit);
	}

	public Transaction []Checker(){
		Transaction []Array = this.Transfers.getTransactionArray();
		TransactionList tmp = new TransactionList();
		for (int i = 0; i < this.Transfers.list_size; i++){
			if (Array[i].getRecipient().list.findTrasactionID(Array[i].getIdentifier()) +
					Array[i].getSender().list.findTrasactionID(Array[i].getIdentifier()) == 1){
				if (Array[i].getRecipient().list.findTrasactionID(Array[i].getIdentifier()) == 1){
					tmp.addTransaction(Array[i].getRecipient().list.getTrasactionID(Array[i].getIdentifier()));
				}
				else{
					tmp.addTransaction(Array[i].getSender().list.getTrasactionID(Array[i].getIdentifier()));
				}
			}
		}
		return (tmp.getTransactionArray());
	}

	public int CheckerSize(){
		Transaction []Array = this.Transfers.getTransactionArray();
		TransactionList tmp = new TransactionList();
		for (int i = 0; i < this.Transfers.list_size; i++){
			if (Array[i].getRecipient().list.findTrasactionID(Array[i].getIdentifier()) +
					Array[i].getSender().list.findTrasactionID(Array[i].getIdentifier()) == 1){
				if (Array[i].getRecipient().list.findTrasactionID(Array[i].getIdentifier()) == 1){
					tmp.addTransaction(Array[i].getRecipient().list.getTrasactionID(Array[i].getIdentifier()));
				}
				else{
					tmp.addTransaction(Array[i].getSender().list.getTrasactionID(Array[i].getIdentifier()));
				}
			}
		}
		return (tmp.list_size);
	}

	public void deleteTransaction(int userId, UUID TransactionId){
		this.UserList.getUserId(userId).list.deleteTransaction(TransactionId);
		this.Transfers.deleteTransaction(TransactionId);
	}
}
