package HomeWork.G1;

public class PartTimeEmployee extends Employee{
    private int workingHour;
    private double hourlyRate = 50_000;

    public PartTimeEmployee(int id, String name, int workingHour) {
        super(id, name);
        this.workingHour = workingHour;
    }

    @Override
    public double calculateSalary() {
        return workingHour * hourlyRate;
    }
}
