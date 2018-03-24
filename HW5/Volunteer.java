// Assignment #: 5
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Description: A subclass of the Employee class and represents
//		a volunteer that works without any pay.

public class Volunteer extends Employee {
	public Volunteer (String fName, String lName, String empId) {
		// constructor, invokes the constructor of the Employee class
		super(fName, lName, empId);
	}
	
	public void computePay() {
		// computes the pay for a volunteer
		pay += 0.00;
	}
	
	public String toString() {
		// returns the volunteers info, calls toString from parent
		return "\nVolunteer:" + super.toString() + "\n";
	}
}

