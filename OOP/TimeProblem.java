// Define a class Time with hours and minutes as two data members, add necessary member functions to initialize and display data of class. Do not use constructors in a class. Define a member function sum () which adds two Time objects. (Use the statements like T3.sum (T1, T2)).

class Time {
    short hr;
    short min;

    void setTime(short hr, short min){
        this.hr = hr;
        this.min = min;
    }

    void displayTime(){
        System.out.println("Time is : " + hr + " : " + min);
    }

    Time sum(Time t1, Time t2){
        Time an = new Time();

        an.hr = (short)((t1.hr + t2.hr) % 24);
        an.min = (short)((t1.min + t2.min) % 60);

        System.out.println("Sum of Times : "+ an.hr + " : " + an.min);

        return an; 
    }
}
public class TimeProblem {
    public static void main(String[] args) {
        Time t = new Time();
        t.setTime((short)12, (short)12);
        t.displayTime();
        Time t1 = new Time();
        Time t2 = new Time();
        t1.setTime((short)2, (short)55);
        t2.setTime((short)24, (short)59);
        Time t3 = new Time();
        t3.sum(t1, t2);
    }
}