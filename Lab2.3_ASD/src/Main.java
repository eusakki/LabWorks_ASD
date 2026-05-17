import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // LVL 1
        System.out.println("----- LVL 1 -----");

        System.out.print("Enter number of students n: "); // 20
        int n = scanner.nextInt();

        System.out.print("Enter number of positions k: "); // 3
        int k = scanner.nextInt();

        long arrangements = Combinatorics.arrangements(n, k);

        System.out.println("Number of arrangements: " + arrangements);

        // LVL 2
        System.out.println("\n----- LVL 2 -----");
        System.out.print("Enter number of unique digits: "); // Digits: 1 1 1 3 5 7 7 7
        int m = scanner.nextInt();

        int[] digits = new int[m];
        int[] counts = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Digit: ");
            digits[i] = scanner.nextInt();

            System.out.print("Count: ");
            counts[i] = scanner.nextInt();
        }

        long permutations = Combinatorics.permutationsWithRepetition(counts);
        System.out.println("Number of different numbers: " + permutations);

        // LVL 3
        System.out.println("\n----- LVL 3 -----");

        Combinatorics.writeArrangementsToFile(n, k);
        System.out.println("Lexicographic order of arrangements were written to arrangements.txt");
    }
}
