import java.util.HashMap;
import java.util.Map;

public class Candy {
    private final Map<String,Double> candys;
    public Candy(){
        candys = new HashMap<>();
        candys.put("Белиссимо",623d);
        candys.put("Вираж",740d);
        candys.put("Элле",500d);
    }
    public void printInfo(){
        for (Map.Entry entry : candys.entrySet()) {
            System.out.println("Конфеты:" + entry.getKey() + " Цена:"
                    + entry.getValue());
        }
    }
    public void printName() {
        for (String key : candys.keySet()) {
            System.out.println("Конфеты: "+key);
        }
    }
    public Double getPrice(String name) {
        if(candys.containsKey(name)) {
            return candys.get(name);
        }
        else return 0d;
    }
    public boolean contain(String name) {
        return candys.containsKey(name);
    }
}
