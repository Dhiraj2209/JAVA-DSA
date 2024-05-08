import java.util.Scanner;

public class AllKeywords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // First try block to handle division by zero
            try {
                if (denominator == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                int result = numerator / denominator;
                System.out.println("Result of division: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Second try block to handle input mismatch exception
            try {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                System.out.println("You entered: " + number);
            } catch (Exception e) {
                System.out.println("Error: Input must be an integer!");
                scanner.nextLine(); // Consume the remaining input
            }

            // Demonstration of 'finally' block
            System.out.println("Finally block executed.");

        } catch (Exception e) {
            // Catch any other exception that may occur
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner in the finally block to ensure it always gets closed
            scanner.close();
        }
    }
}
