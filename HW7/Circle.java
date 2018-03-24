// Assignment #: 7
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Arizona State University CSE205
//  Description: Used to draw circles with parameters inherited from the Shape class

import java.awt.*;

public class Circle extends Shape {
	public Circle (int x1, int y1, int diameter, Color color) {
		// calls parent constructor and instantiates protected variables
		super(x1, y1, diameter, diameter, color);
	}
	
	public void draw(Graphics page) {
		// sets the color of the circle
		page.setColor(color);
		// draws the circle
		page.fillOval(x1, y1, width, height);
	}
}