
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static Map<String, String > getSignatures() throws FileNotFoundException {
		String signaturesPath = "/Users/hirebbec/JAVA/day02/ex00/signatures.txt";
		File sigFile = new File(signaturesPath);
		Map<String, String> signaturesMap = new HashMap<>();

		Scanner scanner = new Scanner(sigFile);
		StringBuilder builder = new StringBuilder();
		while (scanner.hasNext()){
			builder.delete(0, builder.length());
			String str = scanner.nextLine();
			String arr[] = str.split(",");
			String[] dig = arr[1].split(" ");
			for (int i = 1; i < dig.length; i++){
				builder.append(dig[i]);
			}
			signaturesMap.put(arr[0], builder.toString());
		}
		scanner.close();
		return (signaturesMap);
	}


	public static void main(String []args) throws IOException {
		Map <String, String> signaturesMap = getSignatures();
		File resulFile = new File("/Users/hirebbec/JAVA/day02/ex00/result.txt");
		Scanner scanner = new Scanner(System.in);
		String userPath;
		int buf;
		boolean flag = false;
		OutputStream resFile = new FileOutputStream("/Users/hirebbec/JAVA/day02/ex00/result.txt", true);
		while (true){
			StringBuilder builder = new StringBuilder();
			userPath = scanner.nextLine();
			if (userPath.equals("42")){
				System.exit(0);
			}
			try (InputStream fileInputStream = new FileInputStream(userPath)){
				while ((buf = fileInputStream.read()) != -1){
					builder.append(String.format("%02X", buf));
				}
				for (String key : signaturesMap.keySet()){
					flag = builder.toString().contains(signaturesMap.get(key));
					if (flag){
						System.out.println("PROCESSED");
						resFile.write(key.getBytes());
						resFile.write("\n".getBytes());
						break;
					}
				}
				if (!flag)
					System.out.println("UNDEFINED");
			} catch (FileNotFoundException e) {
				System.out.println("File not exists!");
			}

		}
	}
}
