import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- LVL 1 -----");

        RegexSearcher.searchWords("words.txt");

        // LVL 2
        System.out.println("\n----- LVL 2 -----");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: "); // Correct: hello_WORLD, h_123, hellYEAH; Wrong: HELLO, 123abc, hell-no
        String word = scanner.nextLine();

        boolean result = SwitchAnalyzer.analyze(word);

        System.out.println(result ? "Correct" : "Wrong");

        // LVL 3
        System.out.println("\n----- LVL 3 -----");

        TableAnalyzer.analyzeFile("separated_words.txt");
    }
}
