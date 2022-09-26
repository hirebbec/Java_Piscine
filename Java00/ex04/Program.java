/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hirebbec <hirebbec@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/07/19 16:16:47 by hirebbec          #+#    #+#             */
/*   Updated: 2022/07/19 16:56:39 by hirebbec         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int unicode[] = new int[65535];
		int k = 0;
		int lst = 0;
		double size = 0.0;
		int max;
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		char str[] = line.toCharArray();
		char graf[][] = new char[12][40];
		for (int i = 0; i < line.length();i++){
			unicode[str[i]]++;
			if (unicode[str[i]] > 999){
				System.err.println("theIllegalArgument");
				System.exit(-1);
			}
		}
		for (int i = 0;i < 12; i++) {
			for (int j = 0; j < 40; j++) {
				graf[i][j] = ' ';
			}
		}
		k = 0;
		for (int i = 0; i < line.length(); i++) {
			if (unicode[k] < unicode[str[i]]) {
				k = str[i];
			}
		}
		max = unicode[k];
		size = (10.0 / ((double)unicode[k] / (double)line.length()));
		k = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < line.length(); i++) {
				if (unicode[k] < unicode[str[i]]) {
					k = str[i];
				}
                else if (unicode[k] == unicode[str[i]] && str[i] < k) {
                    k = str[i];
                }
			}
			if (unicode[k] == 0){
				break ;
			}
			graf[0][((j + 1) * 4) - 1] = (char)k;
			for (int i = 0; i < (size * unicode[k]) / line.length(); i++) {
				graf[i + 1][((j + 1) * 4) - 1] = '#';
			}
				lst = (int) ((size * unicode[k]) / line.length()) + 1;
			if ((unicode[k] % 10000) != 0) {
				graf[lst][(j * 4) + 3] = (char) ((unicode[k] % 10) + '0');
			}
				unicode[k] = unicode[k] / 10;
			if ((unicode[k] % 1000) != 0) {
				graf[lst][(j * 4) + 2] = (char) ((unicode[k] % 10) + '0');
			}
			unicode[k] = unicode[k] / 10;
			if ((unicode[k] % 100) != 0) {
				graf[lst][(j * 4) + 1] = (char) ((unicode[k] % 10) + '0');
			}
			unicode[k] = unicode[k] / 10;
			if ((unicode[k] % 10) != 0) {
				graf[lst][(j * 4) + 0] = (char) ((unicode[k] % 10) + '0');
			}
			unicode[k] = unicode[k] / 10;
			unicode[k] = 0;
		}
		System.out.println("");
		for (int i = 11;i > - 1; i--) {
			for (int j = 0; j < 40; j++) {
				System.out.print(graf[i][j]);
			}
			System.out.print("\n");
		}
		System.exit(0);
	}
}
