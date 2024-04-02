/*Design a class named Rectangle to represent a rectangle. The class contains: Two double data fields named width and height that specify the width and height of the rectangle. The default values are 1 for both width and height.
A no-arg constructor that creates a default rectangle.
A constructor that creates a rectangle with the specified width and height.
A method named getArea() that returns the area of this rectangle.
A method named getPerimeter() that returns the perimeter.
Write a test program that creates two Rectangle objects—one with width 4 and height 40 and the other with width 3.5 and height 35.9. Display the width, height, area, and perimeter of each rectangle in this order
 */

class Rectangle {
    double width;
    double height;

    Rectangle(){
        this.width = 1 ;
        this.height = 1;
    }

    Rectangle(double w, double h){
        this.width = w;
        this.height = h;
        System.out.println("Height : " + this.height);
        System.out.println("Width : "+ this.width);
    }

    double getArea(){
        return this.height * this.width;
    }
    
    double getPerimeter(){
        return (2 * this.height) + (2 * this.width);
    }
}

public class RectangleArea {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println("Without Arguments(Area) -> " + r.getArea());
        System.out.println("Without Arguments(Perimeter) -> " + r.getPerimeter());
        
        Rectangle r2 = new Rectangle(4,40);
        System.out.println("Area of r2 : "+ r2.getArea());
        System.out.println("Perimeter of r2 : "+ r2.getPerimeter());

        Rectangle r3 = new Rectangle(3.5,35.9);
        System.out.println("Area of r2 : "+ r3.getArea());
        System.out.println("Perimeter of r2 : "+ r3.getPerimeter());
    }
}