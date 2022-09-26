import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		User user1 = new User("user1", 1000);
		User user2 = new User("user2", 2000);
		User user3 = new User("user3", 3000);

		System.out.println(user1.getName() + "  " + user1.getBalance() + "  " + user1.getIdentifier());
		System.out.println(user2.getName() + "  " + user2.getBalance() + "  " + user2.getIdentifier());
		System.out.println(user3.getName() + "  " + user3.getBalance() + "  " + user3.getIdentifier());
	}
}
