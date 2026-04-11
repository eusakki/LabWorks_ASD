import java.util.ArrayList;

public class Sorter {
    //LVL 1 - Insertion Sort for array
    public static void insertionSort(Student[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Student key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].ratio() > key.ratio()) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    //LVL 3 - Bucket Sort
    public static void bucketSort(Student[] arr) {
        int bucketCount = 10;

        ArrayList<Student>[] buckets = new ArrayList[bucketCount];

        for (int i = 0; i < bucketCount; i++)
            buckets[i] = new ArrayList<>();

        for (Student s : arr) {
            int index = (int) (s.ratio() * bucketCount);

            if (index == bucketCount)
                index = bucketCount - 1;

            buckets[index].add(s);
        }

        int k = 0;

        for (ArrayList<Student> bucket : buckets) {
            Student[] temp = bucket.toArray(new Student[0]);

            insertionSort(temp);

            for (Student s : temp)
                arr[k++] = s;
        }
    }
}
