
public class MassiveMain {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 20) - 10);
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indexOfMax]) {
                indexOfMax = i;
            } else if (array[i] < array[indexOfMin]) {
                indexOfMin = i;
            }
        }
        int a = array[indexOfMax];
        array[indexOfMax] = array[indexOfMin];
        array[indexOfMin] = a;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}