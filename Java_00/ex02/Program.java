/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hirebbec <hirebbec@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/07/18 16:44:08 by hirebbec          #+#    #+#             */
/*   Updated: 2022/07/19 16:20:32 by hirebbec         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Program {

	private static boolean isPrime(int num) {
		int	i = 2;
		int	sqrt = 1;

		if (num < 2) {
			System.err.println("theIllegalArgument");
			System.exit(-1);
		}
		while (sqrt * sqrt < num) {
			sqrt++;
		}
		while (i < sqrt + 1) {
			if (num % i == 0) {
				return (false);
			}
			i++;
		}
		return (true);
	}

	private static int SumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		return (sum);
	}

    public static void main(String[] args) {
		int	num = 0;
		int cofe = 0;
		Scanner in = new Scanner(System.in);
		while (num != 42) {
			num = in.nextInt();
			if (isPrime(SumOfDigits(num)) == true){
				cofe++;
			}
		}
		System.out.println("Count of coffee - request -" + cofe);
		System.exit(0);
	}
}