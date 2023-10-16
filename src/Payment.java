import java.util.Calendar;
import java.util.Date;

public class Payment {
    private String lastName;
    private String firstName;
    private double salary;
    private int employmentYear;
    private double bonusPercentage;
    private double tax;
    private int workedDays;
    private int daysInMonth;
    private double calculatedAmount;
    private double withheldAmount;

    public Payment(String lastName, String firstName, double salary, int employmentYear, double bonusPercentage, double tax, int workedDays, int daysInMonth) {
        this.lastName = "Шейчук";
        this.firstName = "Олександр";
        this.salary = salary;
        this.employmentYear = employmentYear;
        this.bonusPercentage = bonusPercentage;
        this.tax = tax;
        this.workedDays = workedDays;
        this.daysInMonth = daysInMonth;
    }

    // Метод для обчислення нарахованої суми
    public void calculateCalculatedAmount() {
        double baseSalary = salary * (workedDays / (double) daysInMonth);
        double bonus = baseSalary * (bonusPercentage / 100);
        calculatedAmount = baseSalary + bonus;
    }

    // Метод для обчислення утриманої суми
    public void calculateWithheldAmount() {
        withheldAmount = (calculatedAmount * (tax / 100));
    }

    // Метод для обчислення стажу роботи
    public int calculateExperience() {
        Calendar currentYear = Calendar.getInstance();
        int year = currentYear.get(Calendar.YEAR);
        return year - employmentYear;
    }

    public double getCalculatedAmount() {
        return calculatedAmount;
    }

    public double getWithheldAmount() {
        return withheldAmount;
    }

    public void displayPaymentDetails() {
        System.out.println("Прізвище: " + lastName);
        System.out.println("Ім'я: " + firstName);
        System.out.println("Оклад: " + salary);
        System.out.println("Рік поступлення на роботу: " + employmentYear);
        System.out.println("Відсоток надбавки: " + bonusPercentage + "%");
        System.out.println("Податок: " + tax + "%");
        System.out.println("Кількість відпрацьованих днів в місяць: " + workedDays);
        System.out.println("Кількість днів в місяці: " + daysInMonth);
        System.out.println("Нарахована сума: " + calculatedAmount);
        System.out.println("Утримана сума: " + withheldAmount);
        System.out.println("Стаж роботи: " + calculateExperience() + " років");
    }

    public static void main(String[] args) {
        Payment employee = new Payment("Прізвище", "Ім'я", 3000, 2010, 10, 20, 20, 20);
        employee.calculateCalculatedAmount();
        employee.calculateWithheldAmount();
        employee.displayPaymentDetails();
    }
}
