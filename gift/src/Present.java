import java.util.HashMap;
import java.util.Map;

public class Present {
    Candy candy;
    Jellybean jelly;
    private final Map<String,Double> present;
    public Present(Candy candy, Jellybean jelly){
        present = new HashMap<>();
        this.jelly = jelly;
        this.candy = candy;
    }
    public void addSweet(String name, Double weight) {
        if(!present.containsKey(name))
        present.put(name,weight);
        else System.out.println("Уже есть такой товар");
    }
    public void deleteSweet(String name) {
            if (present.containsKey(name))
                present.remove(name);
            else System.out.println("Такого товара нет");
    }
    public void printName(){
        for (String key : present.keySet()) {
            System.out.println("Товар "+key);
        }
    }
    public Double weightTotal(){
        double sum=0;
        for (double value : present.values()) {
           sum+=value;
        }
        return sum;
    }
    public Double getWeight(String name){
        return present.get(name);
    }
    public Double priceTotal(){
        double sum = 0;
        for (Map.Entry entry : present.entrySet()) {
            sum+=getWeight(entry.getKey().toString())*jelly.getPrice(entry.getKey().toString());
            sum+=getWeight(entry.getKey().toString())*candy.getPrice(entry.getKey().toString());
        }
        return sum;
    }
    public void printInfo(){
            printName();
        System.out.printf("Общий вес %.2f \n",weightTotal());
        System.out.printf("Общая цена %.2f\n",priceTotal());
    }
    public int printSize(){
        if(present.size()==0){
            System.out.println("Подарок пуст");
            return 0;
        }
        return 1;
    }
}
