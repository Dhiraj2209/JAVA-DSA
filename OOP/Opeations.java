//Midsem exam Question

public class A {
    private int a1;
    private int b1;
    
    // Constructor to initialize a1 and b1
    public A(int a1, int b1) {
        this.a1 = a1;
        this.b1 = b1;
    }
    
    // Method to perform addition of a1 and b1
    public int addition() {
        return a1 + b1;
    }
    
    // Method to perform subtraction of a1 and b1
    public int subtraction() {
        return a1 - b1;
    }
    
    // Method to perform multiplication of a1 and b1
    public int multiplication() {
        return a1 * b1;
    }
    
    // Method to perform division of a1 by b1
    public double division() {
        if (b1 != 0) {
            return (double) a1 / b1;
        } else {
            throw new ArithmeticException("Division by zero is undefined.");
        }
    }
    
    public static void main(String[] args) {
        // Create an object of class A
        A obj = new A(10, 5);
        
        // Call individual methods for each operation
        System.out.println("Addition: " + obj.addition());
        System.out.println("Subtraction: " + obj.subtraction());
        System.out.println("Multiplication: " + obj.multiplication());
        try {
            System.out.println("Division: " + obj.division());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
