// package com.company;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;




public class Program {

	public static Scanner scanner;

	public static int threadsCount = 1;

	private static int num = 1;

	public static void fileReader(String path, int index){
		String str;
		URL url;
		InputStream inputStream;
		try {
			url = new URL(path);
			System.out.println("thread " + (index  + 1) + " start download " + path);
			inputStream = url.openStream();
			Files.copy(inputStream, new File(Integer.toString(num++)).toPath());
			System.out.println("thread " + (index + 1) + " end download " + path);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String []args) throws IOException, InterruptedException {
		if (args.length != 1){
			System.out.println("only urls argument ==> path tp file with URLs");
			System.exit(-1);
		}
		Thread []threads = new Thread[threadsCount];
		File file = new File(args[0]);
		scanner = new Scanner(file);
		for (int i = 0; i < threadsCount; i++){
			int finalI = i;
			sleep(10);
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					while (scanner.hasNextLine()){
						fileReader(scanner.nextLine(), finalI);
					}
				}
			});
			threads[i].start();
		}
		for (int i = 0; i < threadsCount; i++){
			threads[i].join();
		}
	}
}