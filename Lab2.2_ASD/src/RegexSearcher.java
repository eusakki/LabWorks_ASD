import java.io.*;
import java.util.regex.*;

public class RegexSearcher {
    private static final String REGEX = "[a-z]+_?([A-Z]+|\\d+)";

    public static void searchWords(String fileName) {
        Pattern pattern = Pattern.compile(REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Correct words:");

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}