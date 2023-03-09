package gradedQuadratic;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuadraticTest {
    public static void main(String[] args) {
        try {
            FileInputStream fileToTest = new FileInputStream("C:\\Users\\studentgvsc\\eclipse-workspace\\BetterEclipse\\src\\gradedQuadratic\\values.txt");
            Scanner reader = new Scanner(fileToTest);
            File fileToWrite = new File("C:\\Users\\studentgvsc\\eclipse-workspace\\BetterEclipse\\src\\gradedQuadratic\\Quadratic-Equations.txt");
            PrintWriter writer = new PrintWriter(fileToWrite);
            while (reader.hasNextLine()) {
                QuadraticSolver quadratic = new QuadraticSolver(reader.nextInt(), reader.nextInt(), reader.nextInt());
                writer.printf("%s\n", quadratic.printSolutions());
            }
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
