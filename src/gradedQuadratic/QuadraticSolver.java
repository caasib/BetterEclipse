package gradedQuadratic;
import java.util.ArrayList;
import java.util.Collections;

public class QuadraticSolver {
    private int a, b, c;
    private String equation = "";
    public QuadraticSolver(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == 1) {
            this.equation += "x^2 ";
        }
        else if (a == -1) {
            this.equation += "-x^2 ";
        }
        else {
            this.equation += a + "x^2 ";
        }
        if (b < 0) {
            this.equation += "- " + -b + "x ";
        }
        else if (b == 1) {
            this.equation += "+ x ";
        }
        else if (b == -1) {
            this.equation += "- x ";
        }
        else if (b > 0) {
            this.equation += "+ " + b + "x ";
        }
        if (c < 0) {
            this.equation += "- " + -c;
        }
        else if (c > 0) {
            this.equation += "+ " + c;
        }
    }

    public ArrayList<Double> solveEquation() throws NoRealSolutionException {
        ArrayList<Double> solutions = new ArrayList<Double>();
        double posSolution, negSolution, discriminant;
        discriminant = Math.pow(b, 2) - (4 * a * c);
        posSolution = (-b + Math.sqrt(discriminant))/(2 * a);
        negSolution = (-b - Math.sqrt(discriminant))/(2 * a);
        if (!Double.isNaN(negSolution)) {
            solutions.add(negSolution);
        }
        if (!Double.isNaN(posSolution) && Double.compare(posSolution, negSolution) != 0) {
            solutions.add(posSolution);
        }
        if (Double.isNaN(posSolution) && Double.isNaN(negSolution)) {
            throw new NoRealSolutionException();
        }
        else {
            Collections.sort(solutions);
            return solutions;
        }
    }

    public String printSolutions() {
        String summary = "";
        try {
            ArrayList<Double> solutions = solveEquation();
            if (solutions.size() == 2) {
                summary = String.format("The solutions for %s are:  x = %.2f, x = %.2f.", this.equation, solutions.get(0), solutions.get(1));
            }
            else if (solutions.size() == 1) {
                summary = String.format("The solution for %s is:  x = %.2f.", this.equation, solutions.get(0));
            }
        }
        catch (NoRealSolutionException e) {
            summary = e.getMessage() + " for " + this.equation + ".";
        }
        return summary;
    }
}
