// Assignment #: 5
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Description: A subclass of the Employee class and represents
//		a full-time that can also receive a bonus in addition to
//      his/her salary

import java.text.NumberFormat;

public class FullTime extends Employee {
	// declare instance variables for rate and bonus
	private double rate;
	private double bonus;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public FullTime (String fName, String lName, String empId, 
				double rate, double bonus) {
		// constructor, invokes parent constructor, initializes rate and bonus
		super(fName, lName, empId);
		this.rate = rate;
		this.bonus = bonus;
	}
	
	public void computePay() {
		// computes the pay by adding in the rate and bonus to pay
		pay += rate;
		pay += bonus;
	}
	
	public String toString() {
		// returns the full time employees information
		return "\nFull Time Employee:" + super.toString() + "Rate:\t\t\t" +
			fmt.format(rate) + "\nBonus:\t\t\t" + fmt.format(bonus) + "\n\n";
	}
}