import static java.lang.Thread.sleep;

class ThreadCreater implements Runnable
{
	String message;
	int count;
	ThreadCreater (int count, String message){
		this.count = count;
		this.message = message;
	}
	public void run()
	{
		for (int i = 0; i < this.count; i++){
			System.out.println(this.message);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

public class Program {
	public static void main(String []args) throws InterruptedException {
		int num = 0;
		String []Array;
		if (args.length != 1){
			System.err.println("the program can be started with only one parameter, example: --count==50");
			System.exit(-1);
		}
		Array = args[0].split("=");
		if (Array.length != 2){
			System.err.println("the program can be started with only one parameter, example: --count==50");
			System.exit(-1);
		}
		if (!Array[0].equals("--count")){
			System.err.println("the program can be started with only one parameter, example: --count==50");
			System.exit(-1);
		}
		try {num = Integer.parseInt(Array[1]);}
		catch (NumberFormatException e) {
			throw new StringToInt();
		}
		if (num < 0){
			System.out.println("please enter positive numbers");
		}
		ThreadCreater HenThreadCreater = new ThreadCreater(num, "Hen");
		ThreadCreater EggThreadCreater = new ThreadCreater(num, "Egg");
		Thread EggThread = new Thread(EggThreadCreater);
		Thread HenThread = new Thread(HenThreadCreater);
		EggThread.start();
		HenThread.start();
		EggThread.join();
		HenThread.join();
		for (int i = 0; i < num; i++){
			System.out.println("Human");
		}
	}
}
