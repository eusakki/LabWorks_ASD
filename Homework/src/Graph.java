import java.util.*;

public class Graph {
    private final Map<GameState, List<GameState>> adjacencyList;

    public Graph () {
        adjacencyList = new HashMap<>();
    }

    public void addState(GameState state) {
        adjacencyList.putIfAbsent(state, new ArrayList<>());
    }

    public void addTransition(GameState from, GameState to) {
        adjacencyList.get(from).add(to);
    }

    // LVL 2 - Building a graph
    public void buildGraph() {
        GameState s0 = new GameState(
                "A1",
                Arrays.asList("B3"),
                0
        );

        GameState s1 = new GameState(
                "A2",
                Arrays.asList("B3"),
                1
        );

        GameState s2 = new GameState(
                "A2",
                Arrays.asList("C5"),
                2
        );

        GameState s3 = new GameState(
                "B2",
                Arrays.asList("C5"),
                3
        );

        GameState s4 = new GameState(
                "B2",
                Arrays.asList("D7"),
                4
        );

        GameState s5 = new GameState(
                "C3",
                Arrays.asList("D7"),
                5
        );

        GameState s6 = new GameState(
                "C3",
                Arrays.asList("E5"),
                6
        );

        GameState s7 = new GameState(
                "D4",
                Arrays.asList("E5"),
                7
        );

        GameState s8 = new GameState(
                "D4",
                Arrays.asList("F7"),
                8
        );

        GameState s9 = new GameState(
                "E5",
                Arrays.asList("F7"),
                9
        );

        GameState s10 = new GameState(
                "E5",
                Arrays.asList("E5"),
                10
        );

        addState(s0);
        addState(s1);
        addState(s2);
        addState(s3);
        addState(s4);
        addState(s5);
        addState(s6);
        addState(s7);
        addState(s8);
        addState(s9);
        addState(s10);

        addTransition(s0, s1);
        addTransition(s1, s2);
        addTransition(s2, s3);
        addTransition(s3, s4);
        addTransition(s4, s5);
        addTransition(s5, s6);
        addTransition(s6, s7);
        addTransition(s7, s8);
        addTransition(s8, s9);
        addTransition(s9, s10);
    }

    public void printGraph() {
        for (GameState state : adjacencyList.keySet()) {
            System.out.println(state);

            for (GameState next : adjacencyList.get(state)) {
                System.out.println("  -> " + next);
            }

            System.out.println();
        }
    }

    // LVL 2
    public void dfs(GameState start) {
        Set<GameState> visited = new HashSet<>();

        dfsRecursive(start, visited);
    }

    private void dfsRecursive(GameState state, Set<GameState> visited) {
        if (visited.contains(state))
            return;

        visited.add(state);

        System.out.println(state);

        for (GameState next : adjacencyList.get(state)) {
            dfsRecursive(next, visited);
        }
    }

    public GameState getFirstState() {
        return adjacencyList.keySet().iterator().next();
    }
}