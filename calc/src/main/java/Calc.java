import java.util.Scanner;

public class Calc {
    double a;
    double b;
    String c;
    double result;

    Calc(Scanner scanner) {
        System.out.print("Введите первый операнд: ");
        a = scanner.nextDouble();
        System.out.print("Введите второй операнд: ");
        b = scanner.nextDouble();
        System.out.print("Введите оператор: ");
        c = scanner.next();
        System.out.printf("Результат: %.2f",res(a,b,c));
    }
    Calc(){

    }


    public double res(double num1, double num2, String c) {
        switch(c) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                return 0d;
        }
        return result;
    }
}

