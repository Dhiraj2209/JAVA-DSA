class IllegalMarkException extends Exception {
    public IllegalMarkException(String message) {
        super(message);
    }
}

class MarkList {
    private String regNo;
    private int marks;

    public MarkList(String regNo, int marks) {
        this.regNo = regNo;
        this.marks = marks;
    }

    public String getRegNo() {
        return regNo;
    }

    public int getMarks() {
        return marks;
    }

    public String checkResult() {
        try {
            if (marks < 0) {
                throw new IllegalMarkException("Illegal Mark");
            } else if (marks >= 40) {
                return "PASS";
            } else {
                return "FAIL";
            }
        } catch (IllegalMarkException e) {
            return e.getMessage();
        }
    }
}

public class MarkListApplication {
    public static void main(String[] args) {
        // Test with different marks
        MarkList student1 = new MarkList("12345", 80);
        MarkList student2 = new MarkList("67890", -10);

        System.out.println("Student 1 Result: " + student1.checkResult());
        System.out.println("Student 2 Result: " + student2.checkResult());
    }
}