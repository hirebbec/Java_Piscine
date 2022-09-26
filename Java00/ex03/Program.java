/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hirebbec <hirebbec@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/07/18 19:54:17 by hirebbec          #+#    #+#             */
/*   Updated: 2022/07/19 16:20:23 by hirebbec         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int	MinScoreForWeeks = 0;
		int	i = 0;
		int	j = 0;
		int	tmp = 0;
        int min = 0;
        int k;
		String str = "lol";
		while (i < 19) {
            str = in.nextLine();
			if (str.equals("42") == true){
				break ;
			}
			if (!str.equals("Week " + (i + 1))){
				System.err.println("theIllegalArgument");
				System.exit(-1);
			}
            min = 0;
			while (j < 5){
				tmp = in.nextInt();
				if (tmp < 1 || tmp > 9){
					System.err.println("theIllegalArgument");
					System.exit(-1);
				}
				if (min > tmp || min == 0) {
                    min = tmp;
                }
				j++;
			}
            k = 1;
            for (int l = 0; l < i; l++) {
                k = k * 10;
            }
            MinScoreForWeeks = MinScoreForWeeks + min * k;
			j = 0;
			i++;
            str = in.nextLine();
            if (!str.equals("")){
				System.err.println("theIllegalArgument");
				System.exit(-1);
			}

		}
		i = 1;
		while (MinScoreForWeeks != 0){
			System.out.print("Week " + i + " ");
            i++;
			j = 0;
			while (j < MinScoreForWeeks % 10){
				System.out.print("=");
                j++;
			}
			System.out.println(">");
            MinScoreForWeeks = MinScoreForWeeks / 10;
		}
		System.exit(0);
	}
}