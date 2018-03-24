// Assignment #: 9
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: This program utilizes recursion instead of iteration in order
//               to solve a few different calculations on an array of integers.
//               Takes input in the form of integers until 0 is entered.

import java.io.*;

public class Assignment9 {
	public static void main(String[] args) {
		int index=0;
		int num=0;
		int[] arr = new int[100];
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		do {
			try { // try-catch block incase of incorrect input
				num = Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Please enter an integer only.\n");
				} catch (IOException e) {
					System.out.println(e);
				} finally { 
					// if there are no issues, set the index in the array 
					// to the number entered and increment the index
					arr[index] = num;
					index++;
				}
		} while (num != 0); // loops until 0 is entered
		
		// calls all of the recursive methods and prints the output
		System.out.println("The minimum number is " + findMin(arr, 0, index));
		System.out.println("The sum of the numbers at even indexes is " 
												+ computeSumAtEven(arr, 0, index));
		System.out.println("The total count of odd numbers is " + countOdd(arr, 0, index));
		System.out.println("The total count of numbers that are same as the first is " 
											+ countSameAsFirst(arr, 1, index, arr[0]));
	}
	
	public static int findMin(int[] numbers, int startIndex, int endIndex) {
		int min;
		if (startIndex == endIndex) // base case
			return numbers[startIndex]; // returns when recursion arrives at the end of the array
		else {
			// accepts the minumum number through the recursion
			// then compares it to the number at the current index
			// if smaller return it, if not pass min through the recursion
			min = findMin(numbers, startIndex + 1, endIndex);
			if (numbers[startIndex] < min)
				return numbers[startIndex];
			else
				return min;
		}
	}
	
	public static int computeSumAtEven(int[] numbers, int startIndex, int endIndex) {
		int result;
		
		if (startIndex == endIndex) // base case
			result = 0; // last index is always zero for this program
		else
		{
			// if the current index is even, add the number to the total passed
			// through the recursion, if not just pass the number through untouched
			int temp = computeSumAtEven(numbers, startIndex+1, endIndex);
			if (startIndex%2 == 0)
				result = numbers[startIndex] + temp;
			else
				result = temp;
		}
		return result;
	}
	
	public static int countOdd(int[] numbers, int startIndex, int endIndex) {
		int result = 0;
		
		if (startIndex == endIndex) // base case
		{
			if ((numbers[startIndex])%2 != 0) // if number at current index is odd
				result = 1;
			else
				result = 0;
		}
		else
		{
			// accepts the count passed through the recursion, then if the number
			// add the current index is odd, it increments count and returns it
			// if not, it just passes it through
			int count = countOdd(numbers, startIndex+1, endIndex);
			if (numbers[startIndex]%2 != 0)
			{
				count++;
				result = count;
			}
			else
				result = count;
		}
		return result;
	}
	
	public static int countSameAsFirst(int[] numbers, int startIndex, int endIndex, int firstNumber) {
		int result = 0;
		
		if (startIndex == endIndex) // base case
		{
			if (numbers[startIndex] == firstNumber) // if the current number is equal to the first number
				result = 1;
			else
				result = 0;
		}
		else
		{
			// accepts the count that is passed through the recursion
			// if the number at the current index is the same as the first number
			// increment the count and return it, if not just pass the count through
			int count = countSameAsFirst(numbers, startIndex+1, endIndex, firstNumber);
			if (numbers[startIndex] == firstNumber)
			{
				count++;
				result = count;
			}
			else
				result = count;
		}
		return result;
	}
}