// Assignment #: 8
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: This class takes in an ArrayList of objects and a Comparator
//				object, it uses Selection Sort and the Comparator object to
//				sort the data in the ArrayList

import java.io.*;
import java.util.*;

public class Sorts
{
	// this method uses the Selection Sort algorithm 
	// to sort the arraylist of ZipInfo objects
	// depending on which method of PostOffice called it will it sort
	// by either Zipcode or State and City
	public static void sort(ArrayList objects, Comparator<ZipInfo> objs)
	{
		int min;
		ZipInfo temp;

		for (int index=0; index < objects.size()-1; index++)
		{
			min = index;
			for (int scan=index+1; scan < objects.size(); scan++) {

				// store the lowest value found
				if ((objs.compare((ZipInfo)objects.get(scan), (ZipInfo)objects.get(min))) < 0)
					min = scan; } 

			// swap the object at the current index with the object of the lowest value
			temp = (ZipInfo)objects.get(min);
			objects.set(min, (ZipInfo)objects.get(index));
			objects.set(index, temp);
		}
	}
}