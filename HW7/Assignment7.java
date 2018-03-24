// Assignment #: 7
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Arizona State University CSE205
//  Description: The Assignment 7 creates a WholePanel that is
//  an extension of JPanel, add it to its content, and set
//  a size for the applet.


import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}

