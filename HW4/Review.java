// Assignment #: 4
// Name: Michael Baldwin
// StudentID: 1208386656
// Lecture: MW 12:00-1:15
// Description: This class describes the review of a Book.  It is
//         instantiated and used in the Book class. Tracks the ratings
//         and number of reviews for a book.

import java.text.DecimalFormat;

public class Review {
	// declare instance variables
	private int numberOfReviews;
	private double sumOfRatings;
	private double average;
	
	DecimalFormat fmt = new DecimalFormat("0.00"); // formats doubles
	
	public Review() {
		// initialize instance variables
		numberOfReviews = 0;
		sumOfRatings = 0.0;
		average = 0.0;
	}
	
	public void updateRating (double newRating) {
		// increases the number of reviews and adds the total sum
		// of the ratings and calculates the average rating
		numberOfReviews++;
		sumOfRatings += newRating;
		if (numberOfReviews > 0)
			average = sumOfRatings / numberOfReviews;
	}
	
	public String toString() {
		// prints the number of reviews and formatted rating
		return "Reviews:\t" + fmt.format(average) + "(" + numberOfReviews + ")";
	}
}