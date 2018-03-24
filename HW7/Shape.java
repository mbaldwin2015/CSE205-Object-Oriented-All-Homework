// Assignment #: 7
//         Name: Michael Baldwin
//    StudentID: 1208386656
//      Lecture: MW 12:00-1:15
//  Arizona State University CSE205
//  Description: An abstract class that is the basis for drawing shapes

import java.awt.*;

public abstract class Shape {
	// protected variables are inherited by child classes
	// declare protected instance variables
	protected int x1;
	protected int y1;
	protected int width;
	protected int height;
	protected Color color;
	
	public Shape(int x1, int y1, int width, int height, Color color) {
		// instantiates protected instance variables
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public abstract void draw(Graphics page); // abstact method declared
}