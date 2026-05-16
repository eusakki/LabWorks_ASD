public class TransitionFunction {
    public State nextState(State state, char ch) {
        // LVL 3
        switch (state) {
            case START:
                if (Character.isLowerCase(ch))
                    return State.LOWERCASE;
                break;

            case LOWERCASE:
                if (Character.isLowerCase(ch))
                    return State.LOWERCASE;

                if (ch == '_')
                    return State.UNDERSCORE;

                if (Character.isUpperCase(ch))
                    return State.UPPERCASE;

                if (Character.isDigit(ch))
                    return State.DIGIT;

                break;

            case UNDERSCORE:
                if (Character.isUpperCase(ch))
                    return State.UPPERCASE;

                if (Character.isDigit(ch))
                    return State.DIGIT;

                break;

            case UPPERCASE:
                if (Character.isUpperCase(ch))
                    return State.UPPERCASE;
                break;

            case DIGIT:
                if (Character.isDigit(ch))
                    return State.DIGIT;
                break;
        }

        return State.ERROR;
    }
}
