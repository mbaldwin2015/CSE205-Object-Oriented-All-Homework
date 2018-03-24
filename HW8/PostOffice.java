// Assignment #: 8
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: The PostOffice class stores all of the address data in the postoffice.
//				it adds all of the data into an ArrayList.  It can also sort the objects
//				in the array list by zipcode and state/city.

import java.io.*;
import java.util.*;

public class PostOffice implements Serializable
{
	private ArrayList<ZipInfo> zipcodeList;
	
	public PostOffice()
	{
		zipcodeList = new ArrayList<ZipInfo>();
	}
	
	public int zipcodeExists(int zipcode)
	{
		// Searches for a zipcode and returns the index, returns -1 if not found
		int zip;
		for (int i=0; i < zipcodeList.size(); i++) {
			zip = zipcodeList.get(i).getZipcode();
			if (zip == zipcode)
				return i;
		}
		return -1;
	}
	
	public int cityStateExists(String city, String state)
	{
		// Searches for an object by city and state and returns the index
		// returns -1 if not found
		
		for (int i=0; i < zipcodeList.size(); i++) {
			if (((ZipInfo)zipcodeList.get(i)).getCity().equalsIgnoreCase(city) && 
					((ZipInfo)zipcodeList.get(i)).getState().equalsIgnoreCase(state))
				return i;
		}
		return -1;
	}
	
	public boolean addZipInfo(String city, String state, int zipcode)
	{
		// Creates a new ZipInfo object with the parameters and adds it to the list
		// Returns true if it was added, but if it already exists it returns false
		if (zipcodeExists(zipcode) == -1 && cityStateExists(city, state) == -1)
		{
			ZipInfo zip1 = new ZipInfo (city, state, zipcode);
			zipcodeList.add(zip1);
			return true;
		}
		return false;
	}
	
	public boolean removeZipcode(int zipcode)
	{
		// Searches for a ZipInfo object with a zipcode and removes it if found
		// Returns false if the object was not found
		if (zipcodeExists(zipcode) == -1)
			return false;
		else {
			zipcodeList.remove(zipcodeExists(zipcode));
			return true;
		}
	}
	
	public boolean removeCityState(String city, String state)
	{
		// Searches for a ZipInfo object by city and state and removes it if found
		// Returns false if the object was not found
		if (cityStateExists(city, state) == -1)
			return false;
		else {
			zipcodeList.remove(cityStateExists(city, state));
			return true;
		}
	}
	
	public void sortByZipcode()
	{
		// Sorts the ZipInfo arraylist by zipcode.
		Sorts.sort(zipcodeList, new ZipcodeComparator());
	}
	
	public void sortByCityState()
	{
		// Sorts the ZipInfo arraylist by state and city
		Sorts.sort(zipcodeList, new CityStateComparator());
	}
	
	public String listZipcode()
	{
		// Lists all of the ZipInfo objects in the ArrayList by calling
		// the compareTo() method of each object
		String list = "";
		if (zipcodeList.size() > 0) {
			for (int i=0; i < zipcodeList.size(); i++)
				list += zipcodeList.get(i).toString(); }
		else 
			return "\nno zipcode\n\n";
		return "\n" + list + "\n";
	}
	
	public void closePostOffice()
	{
		// Makes the ZipInfo array list empty
		zipcodeList.clear();
	}
	
}