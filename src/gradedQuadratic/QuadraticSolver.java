package gradedQuadratic;

public class QuadraticSolver {
    private int a, b, c;
    private String equation = "";
    public QuadraticSolver(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.equation += a + "x^2 ";
        if (b < 0) {
            this.equation += "- " + -b + "x ";
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

    public double solveEquation(int a, int b, int c) {
        double posSolution, negSolution;
    }

    public String toString() {
        return equation;
    }
}
