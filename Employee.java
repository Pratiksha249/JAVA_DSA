// Base class: Employee
public class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    // Constructor
    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName + ", Designation: " + designation);
    }

    // Method to calculate bonus (default to zero)
    public double calculateBonus() {
        return 0;
    }
}

// Derived class: HourlyEmployee
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Calculate weekly salary
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    // Override calculateBonus method
    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.1;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

// Derived class: SalariedEmployee
class SalariedEmployee extends Employee {
    private double monthlySalary;

    // Constructor
    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    // Calculate weekly salary
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    // Override calculateBonus method
    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

// Derived class: ExecutiveEmployee
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    // Constructor
    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    // Override calculateBonus method
    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        return baseBonus + (getMonthlySalary() * 12 * bonusPercentage / 100);
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Annual Bonus: " + calculateBonus());
    }

    // Getter for monthly salary to use in bonus calculation
    public double getMonthlySalary() {
        return super.calculateWeeklySalary() * 4; // Convert weekly to monthly for reference
    }
}
