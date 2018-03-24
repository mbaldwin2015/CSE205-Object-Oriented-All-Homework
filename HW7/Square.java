// Assignment #: 7
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Arizona State University CSE205
//  Description: Used to draw squares with parameters inherited from the Shape class

import java.awt.*;

public class Square extends Shape {
	public Square (int x1, int y1, int width, Color color) {
		// calls parent constructor and instantiates protected variables
		super(x1, y1, width, width, color); 
	}
	
	public void draw(Graphics page) {
		// sets color of the square
		page.setColor(color);
		// draws the square
		page.fillRect(x1, y1, width, height);
	}
}