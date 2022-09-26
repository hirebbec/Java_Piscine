public final class UserIdsGenerator {
	private static UserIdsGenerator instance;
	private static int ID;

	private UserIdsGenerator() {
		this.ID = -1;
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null){
			instance = new UserIdsGenerator();
		}
		return instance;
	}

	public int generateId(){
		return ++ID;
	}
}
