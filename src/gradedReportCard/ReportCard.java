/**
 * Author: Caasi Boakye
 * Date:   Sep 22, 2022
 * Description: 
 */
package gradedReportCard;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class ReportCard {
	
	static Scanner scan = new Scanner(System.in);
	static String schoolName, studentName;
	static String classOne, classTwo, classThree, classFour, classFive, classSix, classSeven;
	static int gradeOne, gradeTwo, gradeThree, gradeFour, gradeFive, gradeSix, gradeSeven;
	
	public static void getReportCardInfo() {
		System.out.println("School name: ");
		schoolName = scan.nextLine();
		System.out.println("Student name: ");
		studentName = scan.nextLine();
		System.out.println("Put all classes, separated by a new line: ");
		classOne = scan.nextLine();
		classTwo = scan.nextLine();
		classThree = scan.nextLine();
		classFour = scan.nextLine();
		classFive = scan.nextLine();
		classSix = scan.nextLine();
		classSeven = scan.nextLine();
		System.out.println("Put the grade for each class: ");
		gradeOne = scan.nextInt();
		gradeTwo = scan.nextInt();
		gradeThree = scan.nextInt();
		gradeFour = scan.nextInt();
		gradeFive = scan.nextInt();
		gradeSix = scan.nextInt();
		gradeSeven = scan.nextInt();
	}
	
	public static String convertToLetter(int grade) {
		String letterGrade = "";
		
		if (grade >= 90) {
			letterGrade = "A";
		}
		else if ((grade >= 80) && (grade < 90)) {
			letterGrade = "B";
		}
		else if ((grade >= 70) && (grade < 80)) {
			letterGrade = "C";
		}
		else if ((grade >= 60) && (grade < 70)) {
			letterGrade = "D";
		}
		else if (grade < 60) {
			letterGrade = "F";
		}
		
		return letterGrade;
	}
	
	public static void run() {
		getReportCardInfo();
		System.out.println(schoolName);
		System.out.println(studentName);
		System.out.println();
		System.out.printf("%-30s %3d %s\n", classOne, gradeOne, convertToLetter(gradeOne));
		System.out.printf("%-30s %3d %s\n", classTwo, gradeTwo, convertToLetter(gradeTwo));
		System.out.printf("%-30s %3d %s\n", classThree, gradeThree, convertToLetter(gradeThree));
		System.out.printf("%-30s %3d %s\n", classFour, gradeFour, convertToLetter(gradeFour));
		System.out.printf("%-30s %3d %s\n", classFive, gradeFive, convertToLetter(gradeFive));
		System.out.printf("%-30s %3d %s\n", classSix, gradeSix, convertToLetter(gradeSix));
		System.out.printf("%-30s %3d %s\n", classSeven, gradeSeven, convertToLetter(gradeSeven));
	}
	
	public static void main(String[] args) {
		run();
	}

}
