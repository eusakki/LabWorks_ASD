public class LUPSolver {
    private final int n;
    private final double[][] A;
    private final double[][] L;
    private final double[][] U;
    private final double[][] P;

    public LUPSolver(double[][] matrix) {
        n = matrix.length;

        A = new double[n][n];
        L = new double[n][n];
        U = new double[n][n];
        P = new double[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, A[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            P[i][i] = 1;
        }

        decompose();
    }

    private void decompose() {
        for (int i = 0; i < n; i++) {
            double max = Math.abs(A[i][i]);
            int pivot = i;

            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > max) {
                    max = Math.abs(A[j][i]);
                    pivot = j;
                }
            }

            if (pivot != i) {
                double[] temp = A[i];
                A[i] = A[pivot];
                A[pivot] = temp;

                double[] tempP = P[i];
                P[i] = P[pivot];
                P[pivot] = tempP;

                for (int k = 0; k < i; k++) {
                    double t = L[i][k];
                    L[i][k] = L[pivot][k];
                    L[pivot][k] = t;
                }
            }

            L[i][i] = 1;

            for (int j = i; j < n; j++) {
                double sum = 0;

                for (int k = 0; k < i; k++) {
                    sum += L[i][k] * U[k][j];
                }

                U[i][j] = A[i][j] - sum;
            }

            for (int j = i + 1; j < n; j++) {
                double sum = 0;

                for (int k = 0; k < i; k++) {
                    sum += L[j][k] * U[k][i];
                }

                L[j][i] = (A[j][i] - sum) / U[i][i];
            }
        }
    }

    public double[] solve(double[] b) {
        double[] Pb = new double[n];

        // Pb = P * b
        for (int i = 0; i < n; i++) {

            double sum = 0;

            for (int j = 0; j < n; j++) {
                sum += P[i][j] * b[j];
            }

            Pb[i] = sum;
        }

        double[] y = new double[n];

        for (int i = 0; i < n; i++) {

            double sum = 0;

            for (int j = 0; j < i; j++) {
                sum += L[i][j] * y[j];
            }

            y[i] = Pb[i] - sum;
        }

        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {

            double sum = 0;

            for (int j = i + 1; j < n; j++) {
                sum += U[i][j] * x[j];
            }

            x[i] = (y[i] - sum) / U[i][i];
        }

        return x;
    }

    public void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.4f ", value);
            }

            System.out.println();
        }
    }

    public double[][] getL() {
        return L;
    }
    public double[][] getU() {
        return U;
    }
    public double[][] getP() {
        return P;
    }
}