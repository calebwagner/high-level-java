// encapsulation in practice
public class Employee {
    public int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees; // 1) static field

    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }
    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    // 2) static method
    public static void printNumberOfEmployees() {
        System.out.println(numberOfEmployees);
    }

    // method overloading example
    public int calculateWage(int extraHours) {
        return baseSalary + (getHourlyRate() * extraHours);
    }

    // method overloading example
    public int calculateWage() {
        return calculateWage(0);
    }

    // setter
    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        }
        this.baseSalary = baseSalary;
    }

    // getter
    private int getBaseSalary() {
        return  baseSalary;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        }
        this.hourlyRate = hourlyRate;
    }
}
