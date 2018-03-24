// Assignment #: 8
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: This class implements the Comparator interface to compare
//				the State and City of each ZipInfo object.  It returns
//				negative if the State of the first one comes before the
//				second alphabetically.  If they have the same state, it compares
//				the city instead

import java.util.*;

public class CityStateComparator implements Comparator<ZipInfo>
{
	public int compare(ZipInfo first, ZipInfo second)
	{
		// this method checks if the states are equal, then if they are it returns
		// the value from the compareTo (negative if its lexigraphically less than)
		// if they aren't the same, then it returns the compareTo of the state
		int result;
		if (first.getState().equals(second.getState()))
			result = first.getCity().compareTo(second.getCity());
		else
			result = first.getState().compareTo(second.getState());
		return result;
	}
}