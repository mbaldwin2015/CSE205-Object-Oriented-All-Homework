// Assignment #: 8
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: This class implements the Comparator interface which
//				is used to compare two different zipcodes.  it returns
// 				negative if the first is smaller than the second

import java.util.*;

public class ZipcodeComparator implements Comparator<ZipInfo>
{
	public int compare(ZipInfo first, ZipInfo second)
	{
		// this returns the difference in the zipcodes
		return first.getZipcode() - second.getZipcode();
	}
}