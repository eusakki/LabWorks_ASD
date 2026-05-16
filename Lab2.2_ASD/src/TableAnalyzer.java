import java.io.*;
import java.util.regex.*;

public class TableAnalyzer {
    public static void analyzeFile(String fileName) {
        // LVL 3
        TransitionFunction tf = new TransitionFunction();

        Pattern splitter = Pattern.compile("[@$]");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = splitter.split(line);

                for (String word : words) {
                    State state = State.START;

                    for (int i = 0; i < word.length(); i++) {
                        state = tf.nextState(state, word.charAt(i));

                        if (state == State.ERROR)
                            break;
                    }

                    boolean correct =
                            state == State.UPPERCASE ||
                            state == State.DIGIT;

                    System.out.printf("%-15s : %s\n",
                            word,
                            correct ? "CORRECT" : "WRONG");
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
