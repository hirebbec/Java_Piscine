

import java.util.UUID;

public class Transaction {
	private UUID Identifier;
	private User Recipient;
	private User Sender;
	private String Transfer;
	private String Status;
	private int Amount;
	public Transaction next;
	public Transaction prev;

	private Transaction twin;

	public Transaction(User recipient, User sender, String transfer, int amount) {
		this.Amount = amount;
		this.Recipient = recipient;
		this.Sender = sender;
		this.Identifier = UUID.randomUUID();
		this.Transfer = transfer;
		this.next = null;
		this.prev = null;
		if (this.Transfer.equals("DEBIT")) {
			if (this.getAmount() >= 0 && this.Sender.getBalance() >= this.getAmount()) {
				this.Sender.setBalance(this.Sender.getBalance() - this.getAmount());
				this.Recipient.setBalance(this.Recipient.getBalance() + this.getAmount());
				this.setStatus("SUCCESS");
			}
			else {
				this.setStatus("FAIL");
				throw new IllegalTransactionException();
			}
		}
		else if (this.Transfer.equals("CREDIT")) {
			if (this.getAmount() <= 0 && this.Sender.getBalance() >= -(this.getAmount())) {
				this.Sender.setBalance(this.Sender.getBalance() + this.getAmount());
				this.Recipient.setBalance(this.Recipient.getBalance() - this.getAmount());
				this.setStatus("SUCCESS");
			}
			else {
				this.setStatus("FAIL");
				throw new IllegalTransactionException();
			}
		}
		else {
			this.setStatus("FAIL");
			throw new IllegalTransactionException();
		}
	}


	public void setTwin(Transaction twin) {
		this.twin = twin;
	}

	public Transaction getTwin() {
		return twin;
	}

	public void setNext(Transaction next) {
		this.next = next;
	}

	public Transaction getNext() {
		return next;
	}

	public Transaction getPrev() {
		return prev;
	}

	public void setPrev(Transaction prev) {
		this.prev = prev;
	}

	public String getStatus() {
		return Status;
	}

	public String getTransfer() {
		return Transfer;
	}

	public int getAmount() {
		return Amount;
	}

	public User getRecipient() {
		return Recipient;
	}

	public User getSender() {
		return Sender;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public void setRecipient(User recipient) {
		Recipient = recipient;
	}

	public void setSender(User sender) {
		Sender = sender;
	}

	public void setTransfer(String transfer) {
		Transfer = transfer;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public UUID getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(UUID identifier) {
		Identifier = identifier;
	}

	@Override
	public String toString() {
		return ("\nID: " + this.getIdentifier() + "\nSENDER NAME: " + this.Sender.getName() + "\nRECIPIENT NAME: " + this.Recipient.getName() + "\nTRANSFER: " + this.getTransfer() + "\nAMOUNT: " + this.getAmount() + "\nSTATUS: " + this.getStatus());
	}

	public class IllegalTransactionException extends RuntimeException{
		public String toString() {
			return ("Transaction not valid!");
		}
	}

}
