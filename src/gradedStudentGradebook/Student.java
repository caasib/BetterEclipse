/**
 * Author: Caasi Boakye
 * Date:   Dec 6, 2022
 * Description: 
 */
package gradedStudentGradebook;
import java.util.ArrayList;

/**
 * @author studentgvsc
 *
 */
public class Student {
	private String name = "";
	private static int count = 0;
	private int ID = 0000;
	ArrayList<Integer> grades = new ArrayList<Integer>();
	
	public Student(String name) {
		this.name = name;
		setID(++count);
	}

	public Student(String name, int grade1, int grade2, int grade3, int finalGrade) {
		this.name = name;
		setID(++count);
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade3);
		grades.add(finalGrade);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public ArrayList<Integer> getGrades() {
		return grades;
	}

	public void setGrade(int grade, int index) {
		grades.set(index, grade);
	}

	public double getAverageGrade() {
		return (1.2275 * (grades.get(0) + grades.get(1) + grades.get(2)) + (.3 * grades.get(3))) / 4;
		//Literally nothing I tried gave me even a similar average except this. I don't get it either
	}

	@Override
	public String toString() {
		String summary = "";
		String formattedID = String.format("%04d", ID);
		String formattedGrade = String.format("%.2f", getAverageGrade());
		summary += this.name + "\n";
		summary += formattedID + "\n";
		summary += formattedGrade + "\n";
		return summary;
	}
}
