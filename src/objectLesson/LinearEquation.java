/**
 * Author: Caasi Boakye
 * Date:   Oct 4, 2022
 * Description: 
 */
package objectLesson;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class LinearEquation {
	/*
	 * A class is the blueprint for an object
	 * The class tells us the attributes (variables)
	 * and the behaviors (methods) associated with that object.
	 * 
	 */
	
	//All linear equations have a slope and all non-vertical lines have a y-intercept
	
	//Given the slope and y-intercept, what could a line do?
	
	//We could determine if a point is on the line
	//We could determine the x-intercept
	//We could determine the slope of a line perpendicular (orthogonal) to the line
	//We could print the equation of the line in slope intercept form
	
	//Class level variables exist for the entire class and any method can use them
	//For security and debugging reasons, class variables are marked private
	//Private variables (and methods) are only visible in the class that they are defined
	
	private double slope, yInt;
	
	//A constructor is a SPECIAL method that generally initializes the class variables of an
	//object
	//The constructor is ALWAYS THE EXACT NAME of the class
	//Constructors do not have a return type
	
	public LinearEquation(double slope, double yInt) {
		this.slope = slope;
		this.yInt = yInt;
		
		//The keyword "this" refers to THAT object's variable
		//The left side of the assignment is for the variables, the right side is for parameters
		
	}
	
	//Getter and setter methods are used to access and change the values of class variables
	//Getter methods should return the value of the specific variable and be named getVariableName
	//Setter methods should change the value of the variable. These methods are void methods
	
	public double getSlope() { //This method returns the slope of the line
		return this.slope;
	}
	
	public double getY() {
		return this.yInt;
	}
	
	public void setSlope(double newSlope) {
		this.slope = newSlope;
	}
	
	public void setY(double newY) {
		this.yInt = newY;
	}
}
