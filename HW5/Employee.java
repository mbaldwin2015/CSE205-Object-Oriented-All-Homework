// Assignment #: 5
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Description: Contains the basic layout of an employee in a company
//		and is used as the root of the company employee hierarchy

import java.text.NumberFormat;

public abstract class Employee {
	// protected instance variables
	protected String firstName;
	protected String lastName;
	protected String employeeId;
	protected double pay;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance(); // formats currency
	
	public Employee (String fName, String lName, String empId) {
		// constructor, initializes the instance variables
		firstName = fName;
		lastName = lName;
		employeeId = empId;
		pay = 0.00;
	}
	
	public String getEmployeeId() { 
		// accessor method, just returns the employeeId
		return employeeId;
	}
	
	// the following method will be implemented by the child classes
	public abstract void computePay();
	
	public String toString() {
		// returns a string with all of the employee information
		return "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName
			+ "\nEmployee ID:\t\t" + employeeId + "\nPay:\t\t\t" 
			+ fmt.format(pay) + "\n";
	}
}