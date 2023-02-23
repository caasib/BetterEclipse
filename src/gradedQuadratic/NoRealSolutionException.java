package gradedQuadratic;

public class NoRealSolutionException extends Exception {
    public NoRealSolutionException() {
        super("No real number solution for the quadratic equation for ");
    }
}
