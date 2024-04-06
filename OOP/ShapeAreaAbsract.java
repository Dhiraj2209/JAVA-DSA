/* Describe abstract class called Shape which has three subclasses say Triangle, Rectangle, 
Circle. Define one method area() in the abstract class and override this area() in these three 
subclasses to calculate for specific object, i.e., area() of Triangle subclass should calculate 
area of triangle etc. Same for Rectangle and Circle. */

abstract class Shape {
    abstract double calculateArea();

    void display(){
        System.out.println("Main abstarct class called.");
    }
}

class Circle extends Shape {
    double radius;

    // Constructor
    Circle(double r){
        this.radius = r;
    }
    
    // Override area method to calculate area of triangle
    @Override 
    double calculateArea(){
        return 3.14 * radius * radius;
    }
}

class Triangle extends Shape {
    double base;
    double height;
    
    // Constructor
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    // Override area method to calculate area of triangle
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    
    // Constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // Override area method to calculate area of rectangle
    @Override
    double calculateArea() {
        return length * width;
    }
}

public class ShapeAreaAbsract {

    public static void main(String[] args) {

        //We cannot Create a object of an Abstarct class directly 
        //Shape s = new Shape(); // Complilation error
        Circle c = new Circle(1.5);
        Triangle t = new Triangle(5.2, 8);
        Rectangle r = new Rectangle(4.955, 6.6);

        System.out.println("Area of Circle : " + c.calculateArea());
        System.out.println("Area of triangle: " + t.calculateArea());
        System.out.println("Area of rectangle: " + r.calculateArea());
        c.display();
    }
}