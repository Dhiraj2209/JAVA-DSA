// Write a program that finds Volume of any shape by overloading volume () method for Cube, Rectangular Cube and Sphere.
// Write a program that finds area of any shape by overloading area () method for Square, Rectangle, Triangle and Circle.

class Volume {
    double volume(double s) { // Cube
        return (s * s * s);
    }

    double volume(double l, double w, double h) { // Rectangular Cube
        return (l * w * h);
    }

    double volume(int r) { // Sphere
        return (4.0 / 3.0 * 3.14 * r * r * r);
    }
}

class Area {
    double area(double l){ //Sqaure
        return (l * l);
    }
    
    double area(double l, double w){ //Rectangle
        return (l * w);
    }

    double area(int r){// Circle
        return (3.14 * r * r);
    }

    double area(double a, double b, double c){ // Triangle
        double s = (a + b + c) / 2;
        return Math.sqrt((s) * (s - a) * (s - b) * (s - c));
    }
}

public class AreaVolumeMethodOverloading {
    public static void main(String args[]){

        Area a = new Area();
        System.out.println("The area of Circle for radius 3 : " + a.area(3));
        System.out.println("The area of Square for length 5.6 : "+ a.area(5.6));
        System.out.println("The area of Rectangle for l = 4.5 and w = 6.5 : " + a.area(4.5, 6.5));
        System.out.println("The area of triangle with sides 2.2, 3.4, 5.78 : "+  a.area(8.2, 6.5, 9.2));

        Volume av = new Volume();
        System.out.println("The volume of Cube for side 4.0 : " + av.volume(4.0));
        System.out.println("The volume of Rectangular Cube for l = 2.0, w = 3.0, h = 4.0 : " + av.volume(2.0, 3.0, 4.0));
        System.out.println("The volume of Sphere for radius 5 : " + av.volume(5));
    }
}