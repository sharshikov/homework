import java.util.HashMap;
import java.util.Map;

public class Jellybean {
    private final Map<String,Double> jelly;
    public Jellybean(){
        jelly = new HashMap<>();
        jelly.put("Гранат", 654d);
        jelly.put("Имбирный", 785d);
        jelly.put("Шахматный", 400d);
    }
    public void printInfo(){
        for (Map.Entry entry : jelly.entrySet()) {
            System.out.println("Мармелад:" + entry.getKey() + " Цена:"
                    + entry.getValue());
        }
    }
    public void printName() {
        for (String key : jelly.keySet()) {
            System.out.println("Мармелад: "+key);
        }
    }
    public Double getPrice(String name) {
        if(jelly.containsKey(name)) {
            return jelly.get(name);
        }
        else return 0d;
    }
    public boolean contain(String name) {
        return jelly.containsKey(name);
    }
}
