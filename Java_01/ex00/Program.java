
import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		User user1 = new User("user1", 1000);
		User user2 = new User("user2", 2000);
		User user3 = new User("user3", 3000);

		System.out.println(user1.getName() + "  " + user1.getBalance());
		System.out.println(user2.getName() + "  " + user2.getBalance());
		System.out.println(user3.getName() + "  " + user3.getBalance());
		System.out.print("---------------------------------------------------------------");

		Transaction tr1 = new Transaction(user1, user2, "DEBIT", 1000);
		Transaction tr2 = new Transaction(user3, user2, "CREDIT", 500);

		System.out.println(tr1);
		System.out.print("---------------------------------------------------------------");
		System.out.println(tr2);
		System.out.println("---------------------------------------------------------------");
		System.out.println(user1.getName() + "  " + user1.getBalance());
		System.out.println(user2.getName() + "  " + user2.getBalance());
		System.out.println(user3.getName() + "  " + user3.getBalance());
	}
}
