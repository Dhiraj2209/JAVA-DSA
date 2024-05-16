import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();
        scanner.close();
        
        System.out.println("Binary equivalent: " + dec2Bin(decimal));
    }

    public static String dec2Bin(int value) {
        if (value == 0) {
            return "0";
        } else if (value == 1) {
            return "1";
        } else {
            int remainder = value % 2;
            int quotient = value / 2;
            return dec2Bin(quotient) + remainder;
        }
    }
}
