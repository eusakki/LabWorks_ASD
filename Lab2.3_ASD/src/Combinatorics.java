import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Combinatorics {
    public static long factorial(int n) {
        long result = 1;

        for (int i = 2; i <=n; i++) {
            result *= i;
        }

        return result;
    }

    // LVL 1
    public static long arrangements(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    // LVL 2
    public static long permutationsWithRepetition(int[] counts) {
        int total = 0;

        for (int count : counts) {
            total += count;
        }
        long result = factorial(total);

        for (int count : counts) {
            result /= factorial(count);
        }

        return result;
    }

    // LVL 3
    public static void writeArrangementsToFile(int n, int k)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("arrangements.txt"));

        boolean[] used = new boolean[n];
        int[] current = new int[k];

        generateArrangements(
                writer,
                used,
                current,
                0,
                n,
                k
        );

        writer.close();
    }

    private static void generateArrangements(
            BufferedWriter writer,
            boolean[] used,
            int[] current,
            int depth,
            int n,
            int k
    ) throws IOException {
        if (depth == k) {
            for (int i = 0; i < k; i ++) {
                writer.write((current[i] + 1) + " ");
            }

            writer.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;

                current[depth] = i;

                generateArrangements(
                        writer,
                        used,
                        current,
                        depth + 1,
                        n,
                        k
                );

                used[i] = false;
            }
        }
    }
}
