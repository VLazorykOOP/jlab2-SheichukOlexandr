import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(resultReal, resultImaginary);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double resultReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double resultImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(resultReal, resultImaginary);
    }

    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double argument() {
        return Math.atan2(imaginary, real);
    }

    public static void main(String[] args) {
        double real1, imaginary1, real2, imaginary2;
        Scanner scanner = new Scanner(System.in);

        if (args.length != 4) {
            System.out.println("Введіть дійсну та уявну частини першого числа (наприклад, 3 4):");
            real1 = scanner.nextDouble();
            imaginary1 = scanner.nextDouble();
            System.out.println("Введіть дійсну та уявну частини другого числа (наприклад, 1 -2):");
            real2 = scanner.nextDouble();
            imaginary2 = scanner.nextDouble();
        } else {
            real1 = Double.parseDouble(args[0]);
            imaginary1 = Double.parseDouble(args[1]);
            real2 = Double.parseDouble(args[2]);
            imaginary2 = Double.parseDouble(args[3]);
        }

        Complex complex1 = new Complex(real1, imaginary1);
        Complex complex2 = new Complex(real2, imaginary2);

        Complex sum = complex1.add(complex2);
        Complex difference = complex1.subtract(complex2);
        Complex product = complex1.multiply(complex2);
        Complex quotient = complex1.divide(complex2);

        System.out.println("Результат додавання: " + sum.real + " + " + sum.imaginary + "i");
        System.out.println("Результат віднімання: " + difference.real + " + " + difference.imaginary + "i");
        System.out.println("Результат множення: " + product.real + " + " + product.imaginary + "i");
        System.out.println("Результат ділення: " + quotient.real + " + " + quotient.imaginary + "i");
        System.out.println("Модуль першого числа: " + complex1.modulus());
        System.out.println("Модуль другого числа: " + complex2.modulus());
        System.out.println("Аргумент першого числа: " + complex1.argument());
        System.out.println("Аргумент другого числа: " + complex2.argument());

        scanner.close();
    }
}
