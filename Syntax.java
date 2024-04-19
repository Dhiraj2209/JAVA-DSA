public class Main {

    // Data types
    int integerVariable = 10; // integer data type
    double doubleVariable = 10.5; // double data type
    char charVariable = 'A'; // character data type
    String stringVariable = "Hello, World!"; // String data type
    boolean booleanVariable = true; // boolean data type

    // Structures
    // if-else statement
    public void ifElseExample() {
        if (integerVariable > 5) {
            System.out.println("Integer is greater than 5");
        } else {
            System.out.println("Integer is less than or equal to 5");
        }
    }

    // for loop
    public void forLoopExample() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + (i+1));
        }
    }

    // while loop
    public void whileLoopExample() {
        int counter = 0;
        while (counter < 3) {
            System.out.println("Counter: " + counter);
            counter++;
        }
    }

    // Methods
    // Method with parameters and return type
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method invocation
    public void methodInvocationExample() {
        int result = add(5, 3);
        System.out.println("Result of addition: " + result);
    }

    // Class declaration
    public class MyClass {
        // Class variable
        private int classVariable;

        // Constructor
        public MyClass(int initialValue) {
            this.classVariable = initialValue;
        }

        // Method within a class
        public void printClassVariable() {
            System.out.println("Class variable value: " + this.classVariable);
        }
    }

    // Object creation and method invocation
    public void objectCreationExample() {
        MyClass myObject = new MyClass(10);
        myObject.printClassVariable();
    }

    // Main method
    public static void main(String[] args) {
        Main main = new Main();

        // Invoking examples
        main.ifElseExample();
        main.forLoopExample();
        main.whileLoopExample();
        main.methodInvocationExample();
        main.objectCreationExample();
    }
}
