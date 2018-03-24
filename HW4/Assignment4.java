// Assignment #: 4
// Name: Michael Baldwin
// StudentID: 1208386656
// Lecture: MW 12:00-1:15
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;
import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String bookTitle;
       String bookPublisher;
       double rating;
       String line = new String();

       // instantiate a Book object
       Book book1 = new Book();

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);


       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = scan.nextLine();

         if (line.length() == 1)
          {
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           // matches one of the case statement
           switch (input1)
            {
             case 'A':   //Add Book
               book1 = new Book();
               System.out.print("Please enter the book information:\n");
               System.out.print("Enter a book title:\n");
               bookTitle = scan.nextLine();
               book1.setTitle(bookTitle);

               System.out.print("Enter its publisher:\n");
               bookPublisher = scan.nextLine();
               book1.setPublisher(bookPublisher);
               break;
             case 'D':   //Display Book
               System.out.print(book1);
               break;
             case 'Q':   //Quit
               break;
             case 'R':   //Add Rating
               System.out.print("Please give a rating of the book:\n");
               rating = Double.parseDouble(scan.nextLine());
               book1.addRating(rating);
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


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Book\n" +
                        "D\t\tDisplay Book\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tGive Rating\n" +
                        "?\t\tDisplay Help\n\n");
  }
}

