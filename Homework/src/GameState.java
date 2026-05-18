import java.util.ArrayList;
import java.util.List;

public class GameState {
    private String kingPosition;
    private List<String> knightPositions;
    private int move;

    public GameState(String kingPosition,
                     List<String> knightPositions,
                     int move) {
        this.kingPosition = kingPosition;
        this.knightPositions = new ArrayList<>(knightPositions);
        this.move= move;
    }

    public String getKingPosition() {
        return kingPosition;
    }

    public List<String> getKnightPositions() {
        return knightPositions;
    }

    public int getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "Move: " + move +
                "| King: = " + kingPosition +
                "| Knights: = " + knightPositions;
    }
}
