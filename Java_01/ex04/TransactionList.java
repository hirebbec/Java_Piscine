

import java.util.UUID;

public class TransactionList implements TransactionsListinterface {
	public Transaction head;
	public Transaction tail;

	public int list_size;

	@Override
	public void addTransaction(Transaction newTransaction) {
		if (this.head == null && this.tail == null){
			this.tail = newTransaction;
			this.head = newTransaction;
			list_size++;
			return ;
		}
		newTransaction.setPrev(tail);
		tail.setNext(newTransaction);
		tail = tail.next;
		list_size++;
	}

	@Override
	public void deleteTransaction(UUID Id) {
		Transaction tmp = this.head;
		if (list_size == 1 && head.getIdentifier() == Id){
			head = null;
			tail = null;
			list_size--;
			return;
		}
		if (head.getIdentifier() == Id){
			head = head.next;
			head.setPrev(null);
			list_size--;
			return;
		}
		else if (tail.getIdentifier() == Id){
			tail = tail.prev;
			tail.setNext(null);
			list_size--;
			return;
		}
		else{
			for (int i = 0; i < this.list_size; i++) {
				if (Id == tmp.getIdentifier()) {
					tmp.prev.setNext(tmp.next);
					tmp.next.setPrev(tmp.prev);
					list_size--;
					return;
				}
				tmp = tmp.next;
			}
		}
		throw new TransactionNotFound();
	}

	@Override
	public Transaction[] getTransactionArray() {
		Transaction []Array = new Transaction[this.list_size];
		Transaction tmp = this.head;
		for (int i = 0; i < list_size; i++){
			Array[i] = tmp;
			tmp = tmp.next;
		}
		return (Array);
	}

	public class TransactionNotFound extends RuntimeException{

		public String toString() {
			return ("Transaction not found :(");
		}
	}

	public int findTrasactionID(UUID id){
		Transaction []Array = this.getTransactionArray();
		for (int i = 0; i < this.list_size; i++){
			if (Array[i].getIdentifier() == id){
				return (1);
			}
		}
		return (0);
	}

	public Transaction getTrasactionID(UUID id){
		Transaction []Array = this.getTransactionArray();
		for (int i = 0; i < this.list_size; i++){
			if (Array[i].getIdentifier() == id){
				return (Array[i]);
			}
		}
		return (null);
	}

	public int getList_size() {
		return list_size;
	}
}
