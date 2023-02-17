package gradedQuadratic;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuadraticTest {
    public static void main(String[] args) {
        try {
            FileInputStream fileToTest = new FileInputStream("C:\\Users\\nketi\\IdeaProjects\\BetterEclipse\\src\\gradedQuadratic\\caasitest.txt");
            Scanner reader = new Scanner(fileToTest);
            File fileToWrite = new File("C:\\Users\\nketi\\IdeaProjects\\BetterEclipse\\src\\gradedQuadratic\\resultsoftest.txt");
            FileWriter writer = new FileWriter(fileToWrite);
            while (reader.hasNextLine()) {
                QuadraticSolver quadratic = new QuadraticSolver(reader.nextInt(), reader.nextInt(), reader.nextInt());
                writer.write(quadratic.printSolutions() + "\n");
            }
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
