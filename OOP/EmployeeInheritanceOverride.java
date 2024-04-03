//Write a Program to maintain employee’s information. Program should illustrate Inheritance concept

// Base class to hold common employee information
class Employee {
    String name;
    int employeeId;
    String phnum;
    int baseSalary;

    // Constructor
    public Employee(String name, int employeeId, String phnum, int s) {
        this.name = name;
        this.employeeId = employeeId;
        this.phnum = phnum;
        this.baseSalary = s;
    }

    // Method to display basic employee information
    void displayEmployeeInfo() {
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Your Phone Number : " + this.phnum);
        System.out.println("your base Salary : "+this.baseSalary);
    }

    //Calculate bonus
    double calculateBonus() {
        return baseSalary * 0.1; // Default bonus calculation
    }

    //Set baseSalary
    void setBaseSalary(int baseSalary) { // set basesalary
        this.baseSalary = baseSalary;
    }
}

//Engineer class which inherites Employee class
class Engineer extends Employee {
    private String specialty;

    public Engineer(String name, int employeeId,String phnum, int s, String specialty) {
        super(name, employeeId, phnum, s);
        this.specialty = specialty;
    }

    @Override
    void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Role: Engineer, Specialty: " + specialty);
    }

    @Override
    //Calculate bonus for Engineer
    double calculateBonus() {
        return baseSalary * 0.25; // Default bonus calculation
    }

}

public class EmployeeInheritanceOverride {
    public static void main(String[] args) {
        Employee dhiraj = new Employee("Dhiraj Prajapati", 9988, "3000500011",99000);
        dhiraj.displayEmployeeInfo();
        System.out.println("Bonus of dhiraj : "+ dhiraj.calculateBonus());

        System.out.println("----------*****----------");
        Engineer om = new Engineer("Om", 5566, "6665556669", 75000, "AI");
        om.displayEmployeeInfo();
        System.err.println("Bonus of Om : " + om.calculateBonus());
    }
}