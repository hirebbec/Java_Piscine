
import java.io.*;
import java.util.*;

public class Program {

	private static final SortedSet<String> Dictionary = new TreeSet<String>();

	public static void main(String []args) throws Exception {
		String tmp;
		if (args.length != 2){
			System.err.println("there can only be 2 input arguments");
			System.exit(-1);
		}
		File file1 = new File(args[0]);
		File file2 = new File(args[1]);
		if (file1.length() / (1024 * 1024) > 10 || file2.length() / (1024 * 1024) > 10)
			throw new Exception("File too large!");
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
			BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));
			List <String> file1Words = new ArrayList<String>();
			List <String> file2Words = new ArrayList<String>();
			while ((tmp = reader1.readLine()) != null){
				file1Words.addAll(Arrays.asList(tmp.split("\\P{L}+")));
			}
			while ((tmp = reader2.readLine()) != null){
				file2Words.addAll(Arrays.asList(tmp.split("\\P{L}+")));
			}
			Dictionary.addAll(file1Words);
			Dictionary.addAll(file2Words);
			String []forSort = Dictionary.toArray(new String[0]);
			Arrays.sort(forSort);
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Dictionary.txt")))) {
				for (String str : forSort){
					writer.write(str + " ");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			List <Integer> file1Vector = getNum(file1Words);
			List <Integer> file2Vector = getNum(file2Words);
			System.out.format("similarity = %.2f\n", getSimilarity(file1Vector, file2Vector));
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
	}

	private static List <Integer> getNum(List <String> list){
		List <Integer> tmp = new ArrayList<Integer>(Dictionary.size());
		int i = 0;
		for( String temp : Dictionary){
			for (String temp2 : list) {
				if (temp.equals(temp2)){
					i++;
				}
			}
			tmp.add(i);
			i = 0;
		}
		return (tmp);
	}

	public static double getSimilarity(List <Integer> list1, List <Integer> list2){
		double nor = 0.0;
		double denor = 0.0;
		Integer []Array1 = list1.toArray(new Integer[0]);
		Integer []Array2 = list2.toArray(new Integer[0]);
		for (int i = 0;i < list1.size(); i++){
			nor += (double) Array1[i] * (double)Array2[i];
		}
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < list1.size(); i++){
			sum1 += (Array1[i] * Array1[i]);
		}
		for (int i = 0; i < list2.size(); i++){
			sum2 += (Array2[i] * Array2[i]);
		}
		denor = Math.sqrt(sum1) * Math.sqrt(sum2);
		return (nor/denor);
	}
}


