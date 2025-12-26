package HomeWork.G1;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee(1, "Nguyễn Văn A", 15_000_000);
        employees[1] = new PartTimeEmployee(2, "Trần Thị B", 80);
        employees[2] = new FullTimeEmployee(3, "Lê Văn C", 20_000_000);

        for (Employee emp : employees) {
            emp.showInfo();

            double salary = emp.calculateSalary();
            System.out.println("Lương: " + salary);

            if (emp instanceof BonusEligible) {
                double bonus = ((BonusEligible) emp).calculateBonus();
                System.out.println("Thưởng: " + bonus);
            }

            System.out.println("----------------------");
        }
    }
}
