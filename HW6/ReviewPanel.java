// Assignment #: 6
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: M/W 12:00-1:15pm
//  Arizona State University CSE205
//  Description: Declares and initializes the components for the review tab
// 			of the program.  Contains a selectable list of all of the books
//			added for review and a rating system, updates the list and rating
//			and number of reviews for each book.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ReviewPanel extends JPanel
 {
	// declare components
     private Vector bookList;
     private JLabel description;
     private JRadioButton one, two, three, four, five;
     private JList reviewList;
     private JButton submit;
     private JPanel radioPanel, center, main;
     private JScrollPane listScroll;
     private double rate;
     private int listSel;

   //Constructor initialize each component and arrange them using
   //certain layouts
   public ReviewPanel(Vector bookList)
     {
         this.bookList = bookList;

         //organize components for review panel
         description = new JLabel("Choose a book to give a review, and select a rating:");
         
         submit = new JButton("Submit Review");
         submit.addActionListener(new ButtonListener());
         submit.setPreferredSize(new Dimension(0,30));
         
         // initializes radio buttons with a label for each
         one = new JRadioButton("1 Poor");
         two = new JRadioButton("2 Fair");
         three = new JRadioButton("3 Average");
         four = new JRadioButton("4 Good");
         five = new JRadioButton("5 Excellent");
         
         // adds radio buttons to a group, only one button can be selected in this group
         ButtonGroup group = new ButtonGroup();
         group.add(one);
         group.add(two);
         group.add(three);
         group.add(four);
         group.add(five);
         
         // creates an object of embeded class RatingListener so all buttons
         // share the same instance of the class
         RatingListener rating = new RatingListener();
         one.addActionListener(rating);
         two.addActionListener(rating);
         three.addActionListener(rating);
         four.addActionListener(rating);
         five.addActionListener(rating);
         
         // organizes radio buttons in a panel
         radioPanel = new JPanel();
         radioPanel.setLayout(new GridLayout(1,5));
         radioPanel.setMaximumSize(new Dimension(650,20));
         radioPanel.add(one);
         radioPanel.add(two);
         radioPanel.add(three);
         radioPanel.add(four);
         radioPanel.add(five);
         
         // initializes JList, adds a list listener for single selection mode
         reviewList = new JList(bookList); // constructor takes in the Vector
         reviewList.addListSelectionListener(new ListListener());
         reviewList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
         listScroll = new JScrollPane(reviewList); // scroll pane for JList
         
         center = new JPanel(); // creating center for main border panel
         center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
         center.add(listScroll);
         center.add(radioPanel);
         
         main = new JPanel(); // organizes components in a border layout
         main.setLayout(new BorderLayout());
         main.add(description, BorderLayout.NORTH);
         main.add(center, BorderLayout.CENTER);
         main.add(submit, BorderLayout.SOUTH);
         
         // organizes main layout of the tab
         setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         add(main);
         add(Box.createRigidArea(new Dimension(0, 50)));
     }

 public void updatebookList()
  {
	 // adds all current content of the Vector to the JList
	 reviewList.updateUI();
  }


 private class RatingListener implements ActionListener
     {
         public void actionPerformed(ActionEvent event)
         {
        	 Object source = event.getSource();
        	 // values assigned to each of the radio buttons
        	 if (source == one) rate = 1.00;
        	 else if (source == two) rate = 2.00;
        	 else if (source == three) rate = 3.00;
        	 else if (source == four) rate = 4.00;
        	 else rate = 5.00;
         }
     }

 private class ListListener implements ListSelectionListener
 {
	 public void valueChanged(ListSelectionEvent event)
	 {
		 // sets the index in the Vector of the selected book
			 listSel = reviewList.getSelectedIndex();
	 }
 }


 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
    	   // adds rating to the book, updating the avg rating and total reviews
    	   // then updates the JList with all current info from Vector
    	   if (rate > 0.00) {
    		   ((Book)bookList.get(listSel)).addRating(rate);
    	       updatebookList();
    	   }
        }
  } //end of ButtonListener class

} //end of ReviewPanel class
