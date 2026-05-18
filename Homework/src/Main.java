import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LVL 1
        System.out.println("----- LVL1: LUP decomposition -----");

        int n = 4;

        double[][] A = new double[n][n];
        double[] b = new double[n];

        System.out.println("Enter matrix coefficiens:");

        for (int i = 0; i < n; i++) {
            System.out.println("Equation " + (i + 1));

            for (int j = 0; j < n; j++) {
                System.out.println("a[" + i + "][" + j + "] =");
                A[i][j] = scanner.nextDouble();
            }

            System.out.println("b[" + i + "] = ");
            b[i] = scanner.nextDouble();
        }

        LUPSolver solver = new LUPSolver(A);

        System.out.println("\nMatrix L:");
        solver.printMatrix(solver.getL());

        System.out.println("\nMatrix U:");
        solver.printMatrix(solver.getU());

        System.out.println("\nMatrix P:");
        solver.printMatrix(solver.getP());

        double[] x = solver.solve(b);

        System.out.println("\nSolution:");

        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d = %.4f%n", i + 1, x[i]);
        }

        // LVL 2
        System.out.println("\n----- LVL2: Graph DFS -----");
        Graph graph = new Graph();

        graph.buildGraph();

        System.out.println("\nGraph:");
        graph.printGraph();

        System.out.println("\nDFS traversal:");
        graph.dfs(graph.getFirstState());
    }
}
