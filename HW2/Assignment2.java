// Assignment #: 2
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Description: This class reads an any number of integers until 0 is entered
//				 and performs calculations on the integers

import java.util.Scanner; // import scanner class

public class Assignment2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // create 'in' Scanner object
		// initialize all variables
		int sum = 0;
		int count = 0;
		int min = 0;
		int current = -1;
		
		while (current != 0) { // will keep looping until a 0 is entered
			current = in.nextInt(); // take input
			if (current != 0) { // if the int from the input is not 0
				if (current % 2 == 0) // if even, add to sum
					sum += current;
				if (current < min) // if less than min, change min
					min = current;
				if (current > 0) // if positive, increase count by 1
					count++;
			}
		}
		// show output
		System.out.println("The minimum integer is " + min);
		System.out.println("The sum of even integers is " + sum);
		System.out.println("The count of positive integers in the sequence is " + count);
	}
}