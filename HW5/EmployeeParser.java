// Assignment #: 5
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Description: A utility class used to create an employee object
// 		from a parsable string.  Creates objects of volunteer,
//		full time, and party time employees.  This class is not
//      to be instantiated.

public class EmployeeParser {
	public static Employee parseStringToEmployee(String lineToParse) {
		// this method will create the employee objects
		// declare variables needed to perform the operations
		String[] info = new String[6];
		Employee emp;
		int hours;
		double rate, bonus;
		
		info = lineToParse.split("/"); // splits the string
		
		// uses the first word of the string to either create a
		// volunteer, parttime or fulltime employee object respectively
		if (info[0].equals("Volunteer"))
			emp = new Volunteer(info[1], info[2], info[3]);
		else if (info[0].equals("PartTime")) {
			rate = Double.parseDouble(info[4]);
			hours = Integer.parseInt(info[5]);
			emp = new PartTime(info[1], info[2], info[3], rate, hours);
		} else if (info[0].equals("FullTime")) {
			rate = Double.parseDouble(info[4]);
			bonus = Double.parseDouble(info[5]);
			emp = new FullTime(info[1], info[2], info[3], rate, bonus);
		} else {
			System.out.println("ERROR! Incorrect information provided");
			emp = new Volunteer("","","");
		}
		return emp;
	}
}

