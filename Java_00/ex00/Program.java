/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hirebbec <hirebbec@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/07/18 15:49:04 by hirebbec          #+#    #+#             */
/*   Updated: 2022/07/19 16:20:52 by hirebbec         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class Program {

    public static void main(String[] args) {
	    int	num = 123456;
		int	sum = 0;

		sum = sum + num % 10;
		num = num / 10;
		sum = sum + num % 10;
		num = num / 10;
		sum = sum + num % 10;
		num = num / 10;
		sum = sum + num % 10;
		num = num / 10;
		sum = sum + num % 10;
		num = num / 10;
		sum = sum + num % 10;
		num = num / 10;
		System.out.print(sum + "\n");
    }
}