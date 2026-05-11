import java.util.Arrays;

public class Benchmark {
    public static long measure(Runnable algorithm) {
        int runs = 5;
        long total = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            algorithm.run();
            long end = System.nanoTime();
            total += (end - start);
        }

        return total / runs;
    }

    public static long testShell(int[] original) {
        int[] arr = Arrays.copyOf(original, original.length);
        return measure(() -> SortAlgorithms.shellSort(arr));
    }

    public static long testInsertion(int[] original) {
        int[] arr = Arrays.copyOf(original, original.length);
        return measure(() -> SortAlgorithms.insertionSort(arr));
    }
}
