import java.util.Random;

public class DataGenerator {
    static Random rand = new Random();

    // Random array
    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(10000);
        return arr;
    }

    // Sorted (the best scenario)
    public static int[] sortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = i;
        return arr;
    }

    // Reverse (the worst scenario)
    public static int[] reversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = size - i;
        return arr;
    }
}
