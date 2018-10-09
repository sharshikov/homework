import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrList = getArrayList();
        sortArrayList(arrList);
        getDuplicateValues(arrList);
    }

    public static ArrayList<String> getArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("filepath"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(" ");
                arrayList.addAll(Arrays.asList(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void sortArrayList(ArrayList<String> arrayList) {
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        for (String s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println("\n-------------");
    }

    public static void getDuplicateValues(ArrayList<String> arrayList) {
        Set<String> hs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        hs.addAll(arrayList);
        int max = 0;
        int i = 0;
        StringBuilder maxString = new StringBuilder();
        for (String s : hs) {
            for (String a : arrayList) {
                if (s.equalsIgnoreCase(a)) {
                    i++;
                }
            }
            if (i > max) {
                max = i;
                maxString.delete(0, maxString.length());
                maxString.append(s);
            }
            System.out.println(s+" "+i);
            i = 0;
        }
        System.out.println("-------------");
        System.out.println(maxString + " " + max);
    }
}