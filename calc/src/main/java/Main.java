import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1: Калькулятор");
        System.out.println("Введите 2: Поиск элемента массива");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:new Calc(scanner);
                break;
            case 2:new Massiv(scanner);
                break;
            default:
                System.out.println("Ошибка");
        }
    }
}
