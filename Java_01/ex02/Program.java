public class Program {

	public static void main(String[] args) {
		User user1 = new User("user1", 1000);
		User user2 = new User("user2", 2000);
		User user3 = new User("user3", 3000);

		System.out.println(user1.getName() + "  " + user1.getBalance() + "  " + user1.getIdentifier());
		System.out.println(user2.getName() + "  " + user2.getBalance() + "  " + user2.getIdentifier());
		System.out.println(user3.getName() + "  " + user3.getBalance() + "  " + user3.getIdentifier());
		System.out.println("---------------------------------------------------------------");
		UsersArrayList users = new UsersArrayList();

		users.addUser(user1);
		users.addUser(user3);
		users.addUser(user2);
		users.addUser(user1);
		users.addUser(user1);
		users.addUser(user3);
		users.addUser(user2);
		users.addUser(user1);
		users.addUser(user1);
		users.addUser(user3);
		users.addUser(user2);
		users.addUser(user1);
		users.addUser(user1);
		users.addUser(user3);
		users.addUser(user2);
		users.addUser(user1);
		users.addUser(user1);
		users.addUser(user3);
		users.addUser(user2);
		users.addUser(user1);
		System.out.println(users.list[0].getName() + "  " + users.list[0].getBalance() + "  " + users.list[0].getIdentifier());
		System.out.println(users.list[1].getName() + "  " + users.list[1].getBalance() + "  " + users.list[1].getIdentifier());
		System.out.println(users.list[2].getName() + "  " + users.list[2].getBalance() + "  " + users.list[2].getIdentifier());
		System.out.println(users.list[3].getName() + "  " + users.list[3].getBalance() + "  " + users.list[3].getIdentifier());
		System.out.println(users.getNum());
		System.out.println(users.getUserId(0).getName());
		System.out.println(users.getUserIndex(2).getName());
		System.out.println(users.getUserIndex(1).getName());
		System.out.println(users.getUserIndex(100).getName());
	}
}
