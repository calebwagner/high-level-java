// encapsulation in practice
public class Employee {
    public int baseSalary;
    private int hourlyRate;

    public int calculateWage(int extraHours) {
        return baseSalary + (getHourlyRate() * extraHours);
    }

    // setter
    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        }
        this.baseSalary = baseSalary;
    }

    // getter
    public int getBaseSalary() {
        return  baseSalary;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        }
        this.hourlyRate = hourlyRate;
    }
}
