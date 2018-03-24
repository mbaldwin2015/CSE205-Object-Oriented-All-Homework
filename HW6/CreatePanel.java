// Assignment #: 6
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: M/W 12:00-1:15pm
//  Arizona State University CSE205
//  Description: Declares and initializes all of the components for the first
//		tab of the program and organizes them in the JPanel to be imported.
//		Allows a user to enter the title and publish of a book to the book list

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
	// declaring all of the objects/components
   private Vector bookList;
   private JButton button1;
   private ReviewPanel rPanel;
   private JLabel message;
   private JLabel bookLabel, publisherLabel;
   private JTextField bookTitle, publisher;
   private JTextArea displayBooks;
   private JPanel input, leftPanel, leftBoxPanel;
   private JScrollPane bookArea;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector bookList, ReviewPanel rPanel)
  {
    this.bookList = bookList;
    this.rPanel = rPanel;

    //organize components here
    message = new JLabel(""); // JLabel for the messages at the top
    message.setForeground(Color.red);
    message.setPreferredSize(new Dimension(0, 100));
    bookLabel = new JLabel("Book Title"); // label for book title text field
    publisherLabel = new JLabel("Publisher"); // label for publisher text field
    
    bookTitle = new JTextField(); // init text fields
    publisher = new JTextField();

    button1 = new JButton("Create a book"); // init button
    button1.addActionListener(new ButtonListener()); // adds the ButtonListener to the button
    
    displayBooks = new JTextArea("No book"); // init the text area
    bookArea = new JScrollPane(displayBooks); // adds the text area to a scroll pane
    bookArea.setPreferredSize(new Dimension(450,350)); // sets preferred size of scroll pane
    
    // creates a panel with a grid layout for text fields and their labels
    input = new JPanel();
    input.setLayout(new GridLayout(2,2));
    input.add(bookLabel);
    input.add(bookTitle);
    input.add(publisherLabel);
    input.add(publisher);
    
    leftPanel = new JPanel(); // border layout panel for left
    leftPanel.setLayout(new BorderLayout());
    leftPanel.add(message, BorderLayout.NORTH);
    leftPanel.add(input, BorderLayout.CENTER);
    
    leftBoxPanel = new JPanel(); // box layout to organize left side
    leftBoxPanel.setLayout(new BoxLayout(leftBoxPanel, BoxLayout.Y_AXIS));
    leftBoxPanel.setMaximumSize(new Dimension(200,350)); // so only textarea extends
    leftBoxPanel.add(leftPanel);
    leftBoxPanel.add(button1);
    button1.setAlignmentX(button1.CENTER_ALIGNMENT); // center button
    leftBoxPanel.add(Box.createRigidArea(new Dimension(200, 100))); // blank space
    
    // adds left panel and scroll pane side by side to main JPanel
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    add(leftBoxPanel);
    add(bookArea);
  }


  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
    	// declare variables
    	String book, pub;
    	Book currentBook = new Book();
    	book = (String)bookTitle.getText();
    	pub = (String)publisher.getText();
    	
    	// will not execute if nothing is entered into the text fields
    	if ((book.length() > 0) && (pub.length() > 0)) {
    		if((displayBooks.getText()).equals("No book"))
    			displayBooks.setText(""); // removes default text
    		message.setText("Book added.");
    		bookTitle.setText(""); // removes text from text fields
    		publisher.setText("");
    		currentBook.setTitle(book); // adds info to Book object
    		currentBook.setPublisher(pub);
    		displayBooks.append(currentBook.toString()); // adds text to text area
    		bookList.add(currentBook); // adds Book object to Vector
    		rPanel.updatebookList(); // updates JList on second tab
    	} else {
    		message.setText("Please fill both title and publisher"); // error msg
    	}

     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class
