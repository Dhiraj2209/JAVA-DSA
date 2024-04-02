/*	Define a class called Cartesian Point, which has two instance variables, x and y. Provide the methods get X() and get Y() to return the values of the x and y values respectively, a method called move() which would take two integers as parameters and change the values of x and y respectively, a method called display() which would display the current values of x and y. Now overload the method move() to work with single parameter, which would set both x and y to the same values,provide constructors with two parameters and overload to work with one parameter as well. Now define a class called Test Cartesian Point, with the main method to test the various methods in the Cartesian Point class. */

class Cartesian_Point{
    private int x;
    private int y;
    
    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    void move(int a, int b){
        this.x = a;
        this.y = b;
    }

    void display(){
        System.out.println("The value of X : " + this.x + " And Y : " + this.y);
    }

    void move(int q){
        this.x = this.y = q;
    }
}

public class CartesianPoint {
    public static void main(String[] args) {
        Cartesian_Point cp = new Cartesian_Point();
        cp.move(5,4);
        System.out.println("The value of X : " + cp.getX());
        System.out.println("The value of Y : " + cp.getY());
        cp.display();
        cp.move(2);
        cp.display();
    }
}