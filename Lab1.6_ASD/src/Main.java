import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 100;

        int[] sizes = {N, N * N, N * N * N}; // 100, 10.000, 1.000.000

        FileWriter writer = new FileWriter("results.csv");
        writer.write("Size,Shell,Insertion\n");

        // LVL1
        System.out.println("----- LVL1 + LVL2 -----");

        for (int size : sizes) {
            int[] data = DataGenerator.randomArray(size);

            long shellTime = Benchmark.testShell(data);
            long insertionTime = Benchmark.testInsertion(data);

            System.out.println("Size: " + size);
            System.out.println("Shell: " + shellTime);
            System.out.println("Insertion: " + insertionTime);

            writer.write(size + "," + shellTime + "," + insertionTime + "\n");
        }

        // LVL3
        System.out.println("\n ----- LVL3 -----");

        int size = 10000;

        int[] best = DataGenerator.sortedArray(size);
        int[] worst = DataGenerator.reversedArray(size);
        int[] avg = DataGenerator.randomArray(size);

        writer.write("\nCase,Shell,Insertion\n");

        writer.write("Best," +
                Benchmark.testShell(best) + "," +
                Benchmark.testInsertion(best) + "\n");

        writer.write("Worst," +
                Benchmark.testShell(worst) + "," +
                Benchmark.testInsertion(worst) + "\n");

        writer.write("Average," +
                Benchmark.testShell(avg) + "," +
                Benchmark.testInsertion(avg) + "\n");

        writer.close();

        System.out.println("Results saved to results.csv");
    }
}
