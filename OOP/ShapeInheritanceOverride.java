//Create a base class Shape. Use this class to store two double type values that could be used to compute area of any shape. Derive two specific classes called Triangle and Rectangle from the base shape. Add to the base a member function getdata() to initialize base class data member and another member function display_area() to compute and display the area of figures. (Use Method Overriding).

// The base class Shape
class Shape {

    // Attributes to store dimensions of the shape
    double d1;
    double d2;

    // Method to initialize
    void getdata(double dim1, double dim2) {
        d1 = dim1;
        d2 = dim2;
    }

    // Method to compute and display the area of a shape
    void display_area() {
        System.out.println("This method should be overridden in derived classes.");
    }
}

// Derived class Triangle from Shape
class Triangle extends Shape {

    Triangle(double base, double height) {
        getdata(base, height); // Initialize base and height of the triangle
    }

    // Override display_area in Triangle
    @Override
    void display_area() {
        double area = 0.5 * d1 * d2;
        System.out.println("Area of Triangle for base "+d1+" and height " + d2 + " : " + area);
    }
}

// Derived class Rectangle from Shape
class Rectangle extends Shape {
    // Constructor for Rectangle
    Rectangle(double length, double breadth) {
        getdata(length, breadth); // Initialize length and breadth of the rectangle
    }

    // Override display_area in Rectangle
    @Override
    void display_area() {
        double area = d1 * d2;
        System.out.println("Area of Rectangle for length "+ d1 +" and "+ d2 +" : " + area);
    }
}

// Main class to demonstrate the functionality
public class ShapeInheritanceOverride {
    public static void main(String[] args) {
        // Create a Triangle
        Triangle t = new Triangle(5.0, 10.0);
        t.display_area(); // Display the area of the triangle

        // Create a Rectangle
        Rectangle r = new Rectangle(4.5, 8.0);
        r.display_area(); // Display the area of the rectangle
    }
}
