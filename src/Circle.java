import java.lang.Math;

public class Circle {
    private double radius;
    private double centerX;
    private double centerY;

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    // Метод для обчислення довжини кола
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Метод для обчислення площі круга
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Метод, що визначає, чи належить точка кругу
    public boolean containsPoint(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return distance <= radius;
    }

    // Метод, що визначає кількість точок перетину з іншим колом
    public int countIntersectionPoints(Circle otherCircle) {
        double distanceBetweenCenters = Math.sqrt(Math.pow(otherCircle.centerX - centerX, 2) + Math.pow(otherCircle.centerY - centerY, 2));
        if (distanceBetweenCenters >= radius + otherCircle.radius) {
            // Кола не перетинаються
            return 0;
        } else if (distanceBetweenCenters + radius <= otherCircle.radius || distanceBetweenCenters + otherCircle.radius <= radius) {
            // Один коло знаходиться внутрішньо іншого
            return 0;
        } else if (distanceBetweenCenters == 0 && radius == otherCircle.radius) {
            // Кола ідентичні
            return -1;
        } else {
            // Є перетин
            return 2;
        }
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0, 0.0, 0.0);
        Circle circle2 = new Circle(3.0, 4.0, 0.0);

        double x = 2.0;
        double y = 2.0;

        // Приклади викликів методів
        System.out.println("Довжина кола: " + circle1.calculateCircumference());
        System.out.println("Площа круга: " + circle1.calculateArea());
        System.out.println("Точка (" + x + ", " + y + ") належить колу: " + circle1.containsPoint(x, y));
        System.out.println("Кількість точок перетину з іншим колом: " + circle1.countIntersectionPoints(circle2));
    }
}
