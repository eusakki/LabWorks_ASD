public class SortAlgorithms {
    // LVL1: Shell Sort (Knuth sequence)
    public static void shellSort(int[] arr) {
        int n = arr.length;

        int gap = 1;
        while (gap < n / 3)
            gap = 3 * gap + 1; // Knuth

        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
            gap /= 3;
        }
    }

    // LVL2: Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}