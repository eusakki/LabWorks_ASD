public class LUPSolver {
    private final int n;
    private final double[][] L;
    private final double[][] U;
    private final double[][] P;

    public LUPSolver(double[][] A) {
        n = A.length;

        L = new double[n][n];
        U = new double[n][n];
        P = new double[n][n];

        // Matrix's copy
        double[][] LU = new double[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, LU[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            P[i][i] = 1;
        }

        decompose(LU);
    }

    private void decompose(double[][] LU) {
        for (int k = 0; k < n; k++) {
            double max = 0;
            int pivot = k;

            for (int i = k; i < n; i++) {
                if (Math.abs(LU[i][k]) > max) {
                    max = Math.abs(LU[i][k]);
                    pivot = i;
                }
            }

            if (max == 0) {
                throw new RuntimeException("Matrix is singular!");
            }

            // Rearranging rows
            if (pivot != k) {
                double[] temp = LU[k];
                LU[k] = LU[pivot];
                LU[pivot] = temp;

                double[] tempP = P[k];
                P[k] = P[pivot];
                P[pivot] = tempP;

                // Rearranging L
                for (int j = 0; j < k; j++) {
                    double t = L[k][j];
                    L[k][j] = L[pivot][j];
                    L[pivot][j] = t;
                }
            }

            // Calculation
            for (int i = k + 1; i < n; i++) {
                LU[i][k] /= LU[k][k];

                for (int j = k + 1; j < n; j++) {
                    LU[i][j] -= LU[i][k] * LU[k][j];
                }
            }
        }

        // Splitting LU into L and U
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;

            for (int j = 0; j < n; j++) {
                if (i > j) {
                    L[i][j] = LU[i][j];
                } else {
                    U[i][j] = LU[i][j];
                }
            }
        }
    }

    public double[] solve(double[] b) {
        double[] Pb = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Pb[i] += P[i][j] * b[j];
            }
        }

        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            y[i] = Pb[i];

            for (int j = 0; j < i; j++) {
                y[i] -= L[i][j] * y[j];
            }
        }

        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            x[i] = y[i];

            for (int j = i + 1; j < n; j++) {
                x[i] -= U[i][j] * x[j];
            }

            x[i] /= U[i][i];
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