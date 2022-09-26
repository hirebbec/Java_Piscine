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

	public static int arraySize;
	public static int threadsCount;

	public static int []array;

	public static int sumByThreads = 0;
	public static int sumReal = 0;

	public static int numForThread;

	public static void	counter(int start, int end, int index){
		int count = 0;
		int tmp = start;
		while (start < end){
			count += array[start];
			start++;
		}
		System.out.println("Thread " + index + ": from " + tmp + " to " + (end - 1) + " sum is " + count);
		sumByThreads += count;
	}

	public static void main(String []args) throws IOException, InterruptedException {
	if (args.length != 2){
		System.out.println("2 parametrs pls");
		System.exit(-1);
	}
	if (!args[0].matches("--arraySize=\\d+") || !args[1].matches("--threadsCount=\\d+")){
		System.out.println("incorrect format");
		System.exit(-1);
	}
	arraySize = Integer.parseInt(args[0].substring(12));
	threadsCount  = Integer.parseInt(args[1].substring(15));
	if (arraySize > 2000000 || arraySize < threadsCount){
		System.out.println("incorrect because: arraySize > 2000000 or arraySize < threadsCount");
		System.exit(-1);
	}
	Random obj = new Random();
	array = new int[arraySize];
	for (int k = 0; k < arraySize; k++){
		array[k] = obj.nextInt(1000);
		sumReal += array[k];
	}
	Thread []threads = new Thread[threadsCount];
	numForThread = arraySize / threadsCount;
	int i = 0, j = 0;
	System.out.println("Real sum = " + sumReal);
	while (i < arraySize && j < threadsCount){
		int finalI = i;
		int finalJ = j;
		threads[j] = new Thread(new Runnable() {
			@Override
			public void run() {
				if (finalJ == threadsCount - 1){
					counter(finalI, arraySize, finalJ);
				}
				else {
					counter(finalI, finalI + numForThread, finalJ);
				}
			}
		});
		threads[j].start();
		i += numForThread;
		j++;
	}
	for (int k = 0; k < threadsCount; k++){
		threads[k].join();
	}
	System.out.println("Sum by threads = " + sumByThreads);
	}
}
