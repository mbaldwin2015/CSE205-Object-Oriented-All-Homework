// Assignment #: 7
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Arizona State University CSE205
//  Description: This program will allow the user to draw circles or squares on
//           a canvas with different sizes and colors and will allow the user
//           to Undo the last changes made.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private Color currentColor;
   private int currentSize;
   private int x, y;
   private Point pt;
   private CanvasPanel canvas;
   private JPanel topPanel, menu;
   private JButton undo;
   private ArrayList shapeList;
   private JComboBox shapeBox, sizeBox, colorBox;
   // String arrays for the drop down menus
   private String[] shapeChoice = {"circle", "square",};
   private String[] sizeChoice = {"10", "20", "30", "40", "50"};
   private String[] colorChoice = {"black", "red", "blue", "green", "orange"};
   private Shape currentShape;
   private JLabel instructions;

   public WholePanel()
   {
      //default color to draw is black
      currentColor = Color.black;
      currentSize = 10;
      shapeList = new ArrayList();
      
      // instructions label for the top of the applet
      instructions = new JLabel("Choose Circle or Square, its size and its color");

      // undo button
      undo = new JButton ("Undo");
      undo.addActionListener(new ButtonListener());
      
      // instantiate and add listeners to the drop down menus
      shapeBox = new JComboBox(shapeChoice);
      shapeBox.addActionListener(new ComboListener());
      sizeBox = new JComboBox(sizeChoice);
      sizeBox.addActionListener(new ComboListener());
      colorBox = new JComboBox(colorChoice);
      colorBox.addActionListener(new ComboListener());

      // defines the menu as a grid layout, adds all drop downs and buttons
      menu = new JPanel();
      menu.setLayout(new GridLayout(1,4));
      menu.add(shapeBox);
      menu.add(sizeBox);
      menu.add(colorBox);
      menu.add(undo);
      
      // adds the instructions JLabel to the top and the menu below it
      topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      topPanel.add(instructions, BorderLayout.NORTH);
      topPanel.add(menu, BorderLayout.SOUTH);

      canvas = new CanvasPanel();
      canvas.addMouseListener(new PointListener()); // canvas will listen for the mouse

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      // sets the layout of the primary panel
      setLayout(new BorderLayout());
      add(sp);
    }

  //CanvasPanel is the panel where shapes will be drawn
  private class CanvasPanel extends JPanel
   {
      //this method draws all shapes specified by a user
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.WHITE);

        for (int i = 0; i < shapeList.size(); i++)
          	((Shape)shapeList.get(i)).draw(page); // draws the shapes stored
       }
    } //end of CanvasPanel class


   //ButtonListener defined actions to take in case
   //"Undo" is chosed.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
          if (!(shapeList.isEmpty())) {
        	  // deletes the last shape that was drawn
        	  shapeList.remove(shapeList.size()-1);
        	  canvas.repaint();
          }
      }
   } // end of ButtonListener


   // listener class to set the color chosen by a user using
   // color combo box, set the size chosen using size combo box
   // or set the shape (circle or square) using shape combo box
   private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
         {
        	// set the size based on the choice in the drop down
          if (sizeBox.getSelectedIndex() == 0)
        	  currentSize = 10;
          else if (sizeBox.getSelectedIndex() == 1)
          	  currentSize = 20;
          else if (sizeBox.getSelectedIndex() == 2)
          	  currentSize = 30;
          else if (sizeBox.getSelectedIndex() == 3)
          	  currentSize = 40;
          else if (sizeBox.getSelectedIndex() == 4)
          	  currentSize = 50;
          
          // set the color based on the choice in the drop down
          if (colorBox.getSelectedIndex() == 0)
        	  currentColor = Color.black;
          else if (colorBox.getSelectedIndex() == 1)
        	  currentColor = Color.red;
          else if (colorBox.getSelectedIndex() == 2)
        	  currentColor = Color.blue;
          else if (colorBox.getSelectedIndex() == 3)
        	  currentColor = Color.green;
          else if (colorBox.getSelectedIndex() == 4)
        	  currentColor = Color.orange;
         }
    } // end of ComboListener


   // listener class that listens to the mouse
   public class PointListener implements MouseListener
    {
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
          pt = event.getPoint();
          // centers the object onto the mouse by shifting the location up and left
          // based on the half the size of the object
          x = (pt.x) - (currentSize/2);
          y = (pt.y) - (currentSize/2);
          
          // creates either a circle or square and adds it to the arrayList
          // then has the canvas repaint
          if (shapeBox.getSelectedIndex() == 0) {
        	  currentShape = new Circle(x, y, currentSize, currentColor);
        	  shapeList.add(currentShape);
        	  canvas.repaint();
          } else if (shapeBox.getSelectedIndex() == 1) {
        	  currentShape = new Square(x, y, currentSize, currentColor);
        	  shapeList.add(currentShape);
        	  canvas.repaint();
          }
      }


     public void mouseReleased (MouseEvent event) {}
     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}

    } // end of PointListener

} // end of Whole Panel Class
