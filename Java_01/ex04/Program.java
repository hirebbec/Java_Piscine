

import java.lang.reflect.Array;
import java.util.UUID;

public class Program {

	public static void main(String[] args) {
		User user1 = new User("user1", 10000);
		User user2 = new User("user2", 20000);
		User user3 = new User("user3", 30000);

		TransactionsService Service = new TransactionsService();
		Service.addUser(user1);
		Service.addUser(user2);
		Service.addUser(user3);
		System.out.println(Service.getUserBalance(1));
		Service.CreateTransaction(user1, user2, 100);
		Service.CreateTransaction(user2, user3, 1000);
		System.out.println(user1.list.head);
		System.out.println(user2.list.head);
		System.out.println("----------------------------------------------------------------");
		Service.deleteTransaction(user2.getIdentifier(), user2.list.head.getIdentifier());
		System.out.println(user1.list.head);
		System.out.println(user2.list.head);
		System.out.println("----------------------------------------------------------------");
		Service.deleteTransaction(user2.getIdentifier(), user3.list.head.getIdentifier());
		Transaction []Array = Service.Checker();
		for (int i = 0; i < Service.CheckerSize(); i++){
			System.out.println(Array[i]);
		}
		System.out.println("----------------------------------------------------------------");
	}
}
