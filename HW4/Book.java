// Assignment #: 4
// Name: Michael Baldwin
// StudentID: 1208386656
// Lecture: MW 12:00-1:15
// Description: stores the title and publisher of the book
//          being reviewed and also invokes methods from and creates
//          an object of the Review class to track and calculate
//          the number of reviews and ratings

public class Book {
	// declare instance variables
	private String title;
	private String publisher;
	private Review bookReview;
	
	public Book() {
		// initializes instance variables
		title = "?";
		publisher = "?";
		bookReview = new Review(); // object of Review class
	}
	
	public String getTitle() {
		// returns title of book
		return title;
	}
	
	public String getPublisher() {
		// returns the name of the publisher
		return publisher;
	}
	
	public Review getBookReview() {
		// returns the Review object
		return bookReview;
	}
	
	public void setTitle (String newTitle) {
		// sets the book title from the argument
		title = newTitle;
	}
	
	public void setPublisher (String newPublisher) {
		// sets the publisher name from the argument
		publisher = newPublisher;
	}
	
	public void addRating (double newRating) {
		// calls the updateRating method from Review to update the rating
		bookReview.updateRating(newRating);
	}
	
	public String toString() {
		// prints the information from the class, including toString method
		// from the Review class
		return "\nTitle:\t" + title + ",\n" + "Publisher:\t" + publisher +
		        ",\n" + bookReview.toString() + "\n\n";
	}
}