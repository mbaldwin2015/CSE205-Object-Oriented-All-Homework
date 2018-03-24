// Assignment #: 5
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Description: A subclass of the employee class, represents
//		a part time employee of a company

import java.text.NumberFormat;

public class PartTime extends Employee {
	// declares instance variables rate and hoursWorked
	private double rate;
	private int hoursWorked;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public PartTime (String fName, String lName, String empId, 
				double rate, int hours) {
		//constructor, invokes parent constructor, initializes rate and hours
		super(fName, lName, empId);
		this.rate = rate;
		hoursWorked = hours;
	}
	
	public void computePay() {
		// computes the pay of the part time employee
		pay = rate*hoursWorked;
	}
	
	public String toString() {
		// returns the part time employees information
		return "\nPart Time Employee:" + super.toString() + "Rate:\t\t\t"
			+ fmt.format(rate) + "\nHours:\t\t\t" + hoursWorked + "\n\n";
	}
}