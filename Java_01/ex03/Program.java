import java.util.UUID;

public class Program {

	public static void main(String[] args) {
		User user1 = new User("user1", 1000);
		User user2 = new User("user2", 2000);
		User user3 = new User("user3", 3000);

		Transaction tr1 = new Transaction(user1, user2, "CREDIT", -100);
		Transaction tr2 = new Transaction(user3, user2, "DEBIT", 200);
		Transaction tr3 = new Transaction(user1, user2, "CREDIT", -1000);
		Transaction tr4 = new Transaction(user3, user2, "DEBIT", 20000);
		user1.list.addTransaction(tr1);
		user1.list.addTransaction(tr2);
		Transaction []Array = user1.list.getTransactionArray();
		for (int i = 0; i < user1.list.list_size; i++){
			System.out.println(Array[i]);
		}
		System.out.println("---------------------------------------------------");
		user1.list.addTransaction(tr3);
		user1.list.addTransaction(tr4);
		Transaction []Array2 = user1.list.getTransactionArray();
		for (int i = 0; i < user1.list.list_size; i++){
			System.out.println(Array2[i]);
		}
		System.out.println("---------------------------------------------------");
		user1.list.deleteTransaction(tr1.getIdentifier());
		user1.list.deleteTransaction(tr2.getIdentifier());
		Transaction []Array3 = user1.list.getTransactionArray();
		for (int i = 0; i < user1.list.list_size; i++){
			System.out.println(Array3[i]);
		}
		user1.list.deleteTransaction(tr3.getIdentifier());
		user1.list.deleteTransaction(tr4.getIdentifier());
		System.out.println("---------------------------------------------------");
		Transaction []Array4 = user1.list.getTransactionArray();
		for (int i = 0; i < user1.list.list_size; i++){
			System.out.println(Array4[i]);
		}
		System.out.println("---------------------------------------------------");
		user1.list.addTransaction(tr1);
		Transaction []Array5 = user1.list.getTransactionArray();
		for (int i = 0; i < user1.list.list_size; i++){
			System.out.println(Array5[i]);
		}
		user1.list.deleteTransaction(tr4.getIdentifier());
	}
}
