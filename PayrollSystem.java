public class PayrollSystem {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "John Doe", "Part-time Instructor", 20.0, 35);
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Jane Smith", "Full-time Professor", 4000.0);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Sarah Johnson", "Dean", 8000.0, 15.0);

        hourlyEmployee.displayInfo();
        System.out.println("Bonus: " + hourlyEmployee.calculateBonus());

        salariedEmployee.displayInfo();
        System.out.println("Bonus: " + salariedEmployee.calculateBonus());

        executiveEmployee.displayInfo();
    }
}
