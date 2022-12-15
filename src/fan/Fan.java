/**
 * Author: Caasi Boakye
 * Date:   Oct 13, 2022
 * Description: 
 */
package fan;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Fan {
	//Class/instance variables
	String color;
	boolean isOn;
	int speed;
	double radius;
	
	//This constructor is for a default fan
	//Doesn't need parameters to initialize class variables
	public Fan() {
		this.speed = 1;
		this.isOn = false;
		this.radius = 5;
		this.color = "blue";
	}
	
	//This constructor is for a specific type of fan
	public Fan(String color, boolean isOn, int speed, double radius) {
		this.speed = speed;
		this.isOn = isOn;
		this.radius = radius;
		this.color = color;
	}
	
	public String toString() {
		String summary = "";
		
		summary += "Fan speed : " + this.speed + "\n";
		summary += "Fan color : " + this.color + "\n";
		summary += "Fan radius: " + this.radius + "\n";
		summary += "Is on     : " + this.isOn + "\n";
		
		return summary;
	}
}
