import java.util.Scanner;

// Custom exception class for "Divide by Zero" error
class DivideByZeroException extends Exception {
    // Constructor with a custom error message
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class DivideByZero {
    // Method to perform division and handle DivideByZeroException
    public static double divide(double numerator, double denominator) throws DivideByZeroException {
        if (denominator == 0) {
            // Throw DivideByZeroException if the denominator is zero
            throw new DivideByZeroException("Error: Divide by Zero");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numerator: ");
        double numerator = scanner.nextDouble();

        System.out.print("Enter the denominator: ");
        double denominator = scanner.nextDouble();

        scanner.close();

        try {
            // Perform division and handle DivideByZeroException
            double result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (DivideByZeroException e) {
            // Handle DivideByZeroException by printing the error message
            System.out.println(e.getMessage());
        }
    }
}

