// Define Class named Point which represents 2-D Point, i.e P (x, y).  Define Defaultconstructor to initialize both data member value 5, Parameterized constructor to initialize member according to value supplied by user and Copy Constructor. Define Necessary Function and Write a program to test class Point.

class Point {
    int x; int y;

    //Default constructor
    Point() { 
        this.x = this.y = 5;
    }

    //Parameterized constructor
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Copy constructor
    Point(int c){
        this.x = this.y =c;
    }

    //Get x and y
    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }

    void displayCoor(){ // Display Coordinates
        System.out.println("Point Coordinates are : (" + this.x +", " +this.y +")");
    }

    double distance(Point p){
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt((dx * dx + dy * dy));
    }

}
public class X_YPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println("Default Constructor X coor : "+ p1.getX());
        System.out.println("Default Constructor y coor : "+ p1.getY());
        p1.displayCoor();

        Point p2 = new Point(1,3);
        p2.displayCoor();
        System.out.println("Distance of P1 from P2 : "+ String.format("%.2f", p2.distance(p1)));
    }
}