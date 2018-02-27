import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Massiv {
    String[] mass;
    int size;
    String word;
    Massiv(Scanner scanner){
        System.out.println("Введите размерность массива: ");
        size = scanner.nextInt();
        mass = new String[size];
        for (int i = 0;i<mass.length;i++) {
            System.out.println("Введите слово: ");
            mass[i] = scanner.next();
        }
        System.out.println(Arrays.asList(mass));
        search();
    }
    public void search(){
        System.out.println("Cамое длинное слово: "+Arrays.stream(mass).max(Comparator.comparing(String::length)).get());
    }
}
