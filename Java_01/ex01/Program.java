/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hirebbec <hirebbec@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/07/18 16:18:14 by hirebbec          #+#    #+#             */
/*   Updated: 2022/07/19 16:20:40 by hirebbec         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
	   	int	i = 2;
		int	sqrt = 1;
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		if (num < 2) {
			System.err.println("theIllegalArgument");
			System.exit(-1);
		}
		while (sqrt * sqrt < num) {
			sqrt++;
		}
		while (i < sqrt + 1) {
			if (num % i == 0) {
				System.out.println("false " + (i - 1));
				System.exit(0);
			}
			i++;
		}
		System.out.println("true " + (i - 2));
		System.exit(0);
	}
}