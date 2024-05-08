// Declare interfaces I1 and I2
interface I1 {}
interface I2 {}

// Interface I3 extends both I1 and I2
interface I3 extends I1, I2 {}

// Declare interface I4
interface I4 {}

// Class X implements I3
class X implements I3 {}

// Class W extends X and implements I4
class W extends X implements I4 {}

public class InterfaceBasic {
    public static void main(String[] args) {
        // Create an object of class W
        W obj = new W();

        // Test if the object implements each of the interfaces
        System.out.println("Does obj implement I1? " + (obj instanceof I1));
        System.out.println("Does obj implement I2? " + (obj instanceof I2));
        System.out.println("Does obj implement I3? " + (obj instanceof I3));
        System.out.println("Does obj implement I4? " + (obj instanceof I4));

        // Test if the object is of type X
        System.out.println("Is obj of type X? " + (obj instanceof X));
    }
}
