public class SwitchAnalyzer {
    public static boolean analyze(String word) {
        // LVL 2
        State state = State.START;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            switch (state) {
                case START:
                    if (Character.isLowerCase(ch)) {
                        state = State.LOWERCASE;
                    } else {
                        state = State.ERROR;
                    }

                    break;

                case LOWERCASE:
                    if (Character.isLowerCase(ch)) {
                        state = State.LOWERCASE;
                    }
                    else if (ch == '_') {
                        state = State.UNDERSCORE;
                    }
                    else if (Character.isUpperCase(ch)) {
                        state = State.UPPERCASE;
                    }
                    else if (Character.isDigit(ch)) {
                        state = State.DIGIT;
                    }
                    else {
                        state = State.ERROR;
                    }

                    break;

                case UNDERSCORE:
                    if (Character.isUpperCase(ch)) {
                        state = State.UPPERCASE;
                    }
                    else if (Character.isDigit(ch)) {
                        state = State.DIGIT;
                    }
                    else {
                        state = State.ERROR;
                    }

                    break;

                case UPPERCASE:
                    if (Character.isUpperCase(ch)) {
                        state = State.UPPERCASE;
                    }
                    else {
                        state = State.ERROR;
                    }

                    break;

                case DIGIT:
                    if (Character.isDigit(ch)) {
                        state = State.DIGIT;
                    }
                    else {
                        state = State.ERROR;
                    }

                    break;
            }

            if (state == State.ERROR) {
                return false;
            }
        }

        return state == State.UPPERCASE || state == State.DIGIT;
    }
}