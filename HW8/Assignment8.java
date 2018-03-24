// Assignment #: 8
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15pm
//  Arizona State University CSE205 Spring 2015
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;
import java.util.*;

public class Assignment8 implements Serializable
 {
  public static void main (String[] args)
   {
     char input1;
     String city, state, zipStr;
     int zipcode;
     boolean operation = false;
     int operation2 = 0;
     String line;
     String filename;

     // create a PostOffice object. This is used throughout this class.
     PostOffice office1 = new PostOffice();

     try
      {
       // print out the menu
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)          //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add Zipcode
               try 
                {
                 System.out.print("Please enter a city to add:\n");
                 city = stdin.readLine().trim();
                 System.out.print("Please enter its state to add:\n");
                 state = stdin.readLine().trim();
                 System.out.print("Please enter its zipcode to add:\n");
                 zipStr = stdin.readLine().trim();
                 zipcode = Integer.parseInt(zipStr);

                 operation = office1.addZipInfo(city, state, zipcode);
                 if (operation == true)
                  System.out.print("zipcode added\n");
                 else
                  System.out.print("zipcode exists\n");
                }
/************************************************************************************
***  Complete the follwing catch statement
***********************************************************************************/
               catch(IOException e)
                {
            	   System.out.println(e);
                }
               break;
             case 'D':  //Search by Zipcode
              try
               {
                 System.out.print("Please enter zipcode to search:\n");
                 zipStr = stdin.readLine().trim();
                 zipcode = Integer.parseInt(zipStr);
                 operation2=office1.zipcodeExists(zipcode);

                 if (operation2 > -1)
                   System.out.print("zipcode found\n");
                 else
                   System.out.print("zipcode not found\n");
                }
/************************************************************************************
***  Complete the follwing catch statement
***********************************************************************************/
               catch(NumberFormatException e)
                {
            	   System.out.println("Please enter an integer for zipcode. Zipcode not found");
                }
               break;
             case 'E':  //Search by City and State
                System.out.print("Please enter a city to search:\n");
                city = stdin.readLine().trim();
                System.out.print("Please enter a state to search:\n");
                state = stdin.readLine().trim();
                operation2=office1.cityStateExists(city, state);
                    
                if (operation2 > -1)
                    System.out.print("city and state found\n");
                else
                    System.out.print("city and state not found\n");
                break;
             case 'L':   //List Zipcodes
               System.out.print(office1.listZipcode());
               break;
             case 'O':  // Sort by Zipcode
               office1.sortByZipcode();
               System.out.print("sorted by zipcode\n");
               break;
             case 'P':  // Sort by States and Cities
               office1.sortByCityState();
               System.out.print("sorted by states and cities\n");
               break;
             case 'Q':   //Quit
               break;
             case 'R':  //Remove by Zipcode
              try
               {
                 System.out.print("Please enter zipcode to remove:\n");
                 zipStr = stdin.readLine().trim();
                 zipcode = Integer.parseInt(zipStr);
                 operation=office1.removeZipcode(zipcode);

                 if (operation == true)
                    System.out.print("zipcode removed\n");
                 else
                    System.out.print("zipcode not found\n");
                }
/************************************************************************************
***  Complete the follwing catch statement
***********************************************************************************/
                 catch(NumberFormatException e)
               {
          	      System.out.println("Please enter an integer for zipcode. Zipcode not removed");
               }
               break;
                case 'S':  //Remove by State and City
                    System.out.print("Please enter a city to remove:\n");
                    city = stdin.readLine().trim();
                    System.out.print("Please enter a state to remove:\n");
                    state = stdin.readLine().trim();
                    operation=office1.removeCityState(city, state);

                    if (operation == true)
                        System.out.print("city and state removed\n");
                    else
                        System.out.print("city and state not found\n");
                    break;
             case 'T':  //Close PostOffice
               office1.closePostOffice();
               System.out.print("post office closed\n");
               break;
             case 'U':  //Write Text to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to write a text (string) to the specified file. Catch exceptions.
************************************************************************************/
               FileWriter fw = null;
               BufferedWriter bw = null;
               PrintWriter outFile = null;
               try {
            	   System.out.println("Please enter a string to write in the file:");
            	   line = stdin.readLine().trim();
            	   
            	   fw = new FileWriter(filename);
            	   bw = new BufferedWriter(fw);
            	   outFile = new PrintWriter(bw);
            	   
            	   outFile.println(line);
            	   
               } catch (IOException e) {
            	   System.out.println(e);
               } finally {
            	   System.out.println(filename + " was written");
            	   outFile.close();
               }
               break;
             case 'V':  //Read Text from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to read a text (string) from the specified file. Catch exceptions.
************************************************************************************/
               FileReader fr = null;
               BufferedReader inFile = null;
               
               try {
            	   fr = new FileReader(filename);
            	   inFile = new BufferedReader(fr);
            	   line = inFile.readLine();
            	   System.out.println(filename + " was read");
    		   	   System.out.println("The first line of the file is:");
    		       System.out.println(line);
               } catch (FileNotFoundException e) {
            	   System.out.println(filename + " was not found");
               } catch (IOException e) {}
               finally {
            	   try {
            		   if (inFile != null)
            			   inFile.close();
            	   } catch (NullPointerException e) {}
            	     catch (IOException e) {}
               }
               break;
             case 'W':  //Serialize PostOffice to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to write the post office bject to the specified file. Catch exceptions.
************************************************************************************/
               FileOutputStream fos = null;
               ObjectOutputStream outStream = null;
               try {
            	   fos = new FileOutputStream(filename);
            	   outStream = new ObjectOutputStream (fos);
            	   
            	   outStream.writeObject(office1);
            	   
               } catch (NotSerializableException e) {
            	   System.out.println(e);
               }
               catch (IOException e) {
            	   System.out.println(e);
               } finally {
            	   try {
            		   if (outStream != null) {
            			   System.out.println(filename + " was written");
            			   outStream.close(); }
            	   } catch (IOException e) {
            		   System.out.println(e);
            	   }
               }
               break;
              case 'X':  //Deserialize PostOffice from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to read a post office object from the specified file. Catch exceptions.
***********************************************************************************/
               FileInputStream fis = null;
               ObjectInputStream inStream = null;
               try {
            	   fis = new FileInputStream (filename);
            	   inStream = new ObjectInputStream (fis);
            	   
            	   Object in1 = inStream.readObject();
            	   
            	   if (in1 instanceof PostOffice) {
            		   office1 = (PostOffice) in1;
            		   System.out.println(filename + " was read");
            	   }
               } catch (ClassNotFoundException e) {
            	   System.out.println(e);
               } catch (FileNotFoundException e) {
            	   System.out.println(filename + " was not found");
               } catch (IOException e) {
            	   System.out.println(e);
               } finally {
            	   try {
            		   if (inStream != null)
            			   inStream.close();
            	   } catch (IOException e) {
            		   System.out.println(e);
            	   }
               }
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Zipcode\n" +
                      "D\t\tSearch for Zipcode\n" +
                      "E\t\tSearch for City and State\n" +
                      "L\t\tList Zipcode\n" +
                      "O\t\tSort by Zipcode\n" +
                      "P\t\tSort by City and State\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove by Zipcode\n" +
                      "S\t\tRemove by City and State\n" +
                      "T\t\tClose PostOffice\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize PostOffice to File\n" +
                      "X\t\tDeserialize PostOffice from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
} // end of Assignment8 class


