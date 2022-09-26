
import javax.jws.soap.SOAPBinding;

public class User {
	private int Identifier;
	private String Name;
	private int Balance;
	public TransactionList list;

	public User(String name, int balance){
		this.setName(name);
		if (balance < 0) {
			this.Balance = 0;
		}
		else {
			this.setBalance(balance);
		}
		this.Identifier = UserIdsGenerator.getInstance().generateId();
		this.list = new TransactionList();
	}


	public int getBalance() {
		return Balance;
	}

	public String getName() {
		return Name;
	}

	public int getIdentifier() {
		return Identifier;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public void setName(String name) {
		if (name.equals("")) {
			Name = "default";
		}
		else {
			Name = name;
		}
	}

	public void setIdentifier(int identifier) {
		Identifier = identifier;
	}
}
