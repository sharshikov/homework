import java.util.Scanner;
public class GiftMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Candy candy = new Candy();
        Jellybean jelly = new Jellybean();
        Present present = new Present(candy, jelly);
        String name;
        Double weight;
        while (true){
            System.out.println("\nАссортимент: введите 1");
            System.out.println("Добавить товар в подарок: введите 2");
            System.out.println("Убрать товар из подарка: введите 3");
            System.out.println("Содержимое подарка: введите 4");
            switch (scanner.nextInt()){
                case 1:
                    candy.printInfo();
                    jelly.printInfo();
                    break;
                case 2:
                    candy.printName();
                    jelly.printName();
                    System.out.print("Введите название товара: ");
                    name = scanner.next();
                    if(!(jelly.contain(name)||candy.contain(name))){
                        System.out.println("Такого товара в ассортименте нет");
                        break;
                    }
                    System.out.print("Введите вес товара: ");
                    weight= scanner.nextDouble();
                    present.addSweet(name,weight);
                    break;
                case 3:
                    if(present.printSize()==0)break;
                    present.printName();
                    System.out.print("Введите название товара: ");
                    name = scanner.next();
                    present.deleteSweet(name);
                    break;
                case 4:
                    if(present.printSize()==0)break;
                    present.printInfo();
                    break;
                    default:
                        System.out.println("Ошибка");
            }
        }
    }
}
