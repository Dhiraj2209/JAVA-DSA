// Interface Exam
interface Exam {
    boolean Pass(int mark);
}

// Interface Classify
interface Classify {
    String Division(int average);
}

// Class Result implementing both Exam and Classify interfaces
class Result implements Exam, Classify {
    // Implementing Pass method from Exam interface
    public boolean Pass(int mark) {
        return mark >= 50;
    }

    // Implementing Division method from Classify interface
    public String Division(int average) {
        if (average >= 60) {
            return "First";
        } else if (average >= 50) {
            return "Second";
        } else {
            return "No division";
        }
    }
}

public class ResultExamClassify {
    public static void main(String[] args) {
        // Creating an object of Result class
        Result result = new Result();

        // Testing Pass method
        System.out.println("Pass result for mark 70: " + result.Pass(70));
        System.out.println("Pass result for mark 40: " + result.Pass(40));

        // Testing Division method
        System.out.println("Division for average 65: " + result.Division(65));
        System.out.println("Division for average 55: " + result.Division(55));
        System.out.println("Division for average 45: " + result.Division(45));
    }
}
