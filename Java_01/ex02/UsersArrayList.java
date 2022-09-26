public class UsersArrayList implements UsersList{

	User list[];
	int index;
	int size;

	UsersArrayList(){
		list = new User[10];
		index = 0;
		size = 10;
	}

	@Override
	public void addUser(User newUser){
		if (this.index == this.size - 1) {
			this.list = arrayExp(this.list, this.size);
			this.size = this.size + this.size / 2;
			this.list[this.index] = newUser;
			this.index++;
		}
		else if (newUser !=  null){
			this.list[this.index] = newUser;
			this.index++;
		}
	}

	private User [] arrayExp(User oldList[], int size){
		User newList[] = new User[size + (size / 2)];
		for (int i = 0; i < size; i++){
			newList[i] = oldList[i];
		}
		return (newList);
	}

	public int getSize() {
		return size;
	}

	@Override
	public int getNum(){
		return (this.index);
	}

	@Override
	public User getUserId(int ID){
		for (int i = 0; i < this.index; i++){
			if (this.list[i].getIdentifier() == ID){
				return this.list[i];
			}
		}
		throw new UserNotFoundExp();
	}

	@Override
	public User getUserIndex(int index){
		if (this.index < index){
			throw new UserNotFoundExp();
		}
		if (index < 1){
			throw new UserNotFoundExp();
		}
		return (this.list[index - 1]);
	}
}
