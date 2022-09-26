
import java.util.UUID;

public class Transaction {
	private UUID Identifier;
	private User Recipient;
	private User Sender;
	private String Transfer;
	private String Status;
	private int Amount;

	public Transaction(User recipient, User sender, String transfer, int amount) {
		this.Amount = amount;
		this.Recipient = recipient;
		this.Sender = sender;
		this.Identifier = UUID.randomUUID();
		this.Transfer = transfer;
		if (this.Transfer.equals("DEBIT")) {
			if (this.getAmount() >= 0 && this.Sender.getBalance() >= this.getAmount()) {
				this.Sender.setBalance(this.Sender.getBalance() - this.getAmount());
				this.Recipient.setBalance(this.Recipient.getBalance() + this.getAmount());
				this.setStatus("SUCCES");
			}
			else {
				this.setStatus("FAIL");
			}
		}
		else if (this.Transfer.equals("CREDIT")) {
			if (this.getAmount() <= 0 && this.Sender.getBalance() >= -(this.getAmount())) {
				this.Sender.setBalance(this.Sender.getBalance() + this.getAmount());
				this.Recipient.setBalance(this.Recipient.getBalance() - this.getAmount());
				this.setStatus("SUCCES");
			}
			else {
				this.setStatus("FAIL");
			}
		}
		else {
			this.setStatus("FAIL");
		}
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

	public String toString() {
		return ("\nID: " + this.getIdentifier() + "\nSENDER NAME: " + this.Sender.getName() + "\nRECIPIENT NAME: " + this.Recipient.getName() + "\nTRANSFER: " + this.getTransfer() + "\nAMOUNT: " + this.getAmount() + "\nSTATUS: " + this.getStatus());
	}
}
