import java.util.Stack;

import static java.lang.Thread.sleep;

public class Program {

	private static Integer status;

	public static void main(String []args) throws InterruptedException {
		int num = 0;
		status = 1;

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
		int finalNum = num;
		Thread EggThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < finalNum; i++){
					if (status == 1) {
						synchronized (status) {
							System.out.println("Egg");
							status = 0;
						}
					}
					else {
						try {
							sleep(1);
							i--;
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		});
		Thread HenThread = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < finalNum; i++){
					if (status == 0) {
						synchronized (status) {
							System.out.println("Hen");
							status = 1;
						}
					}
					else {
						try {
							sleep(1);
							i--;
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		});
		EggThread.start();
		HenThread.start();
		EggThread.join();
		HenThread.join();
	}
}
