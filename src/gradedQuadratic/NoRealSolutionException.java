package gradedQuadratic;

public class NoRealSolutionException extends Exception {
    private int a, b, c;
    public NoRealSolutionException(int a, int b, int c) {
        super("No real number solution for the quadratic equation for " + a + "x^2 ");
    }
}
