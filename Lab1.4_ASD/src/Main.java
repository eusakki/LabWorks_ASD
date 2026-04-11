public class Main {
    public static void main(String[] args) {
        Student[] students1 = {
                new Student("Yevtushenko", 40, 5),
                new Student("Vlasyuk", 42, 10),
                new Student("Dmitrenko", 38 , 2),
                new Student("Samar", 36, 12),
                new Student("Koval", 40, 1)
        };

        System.out.println("ARRAY BEFORE SORT:");
        printArray(students1);

        //LVL 1
        Sorter.insertionSort(students1);

        System.out.println("\nARRAY AFTER INSERTION SORT:");
        printArray(students1);

        //LVL 2 - Doubly Linked List
        Student[] students2 = {
                new Student("Yevtushenko", 40, 5),
                new Student("Vlasyuk", 42, 10),
                new Student("Dmitrenko", 38 , 2),
                new Student("Samar", 36, 12),
                new Student("Koval", 40, 1)
        };
        DoublyLinkedList list = new DoublyLinkedList();

        for (Student s : students2)
            list.add(s);

        System.out.println("\nLIST BEFORE SORT:");
        list.print();

        list.insertionSort();

        System.out.println("\nLIST AFTER SORT:");
        list.print();

        //LVL 3 - Bucket Sort
        Student[] students3 = {
                new Student("Yevtushenko", 40, 5),
                new Student("Vlasyuk", 42, 10),
                new Student("Dmitrenko", 38 , 2),
                new Student("Samar", 36, 12),
                new Student("Koval", 40, 1)
        };

        System.out.println("\nARRAY BEFORE BUCKET SORT:");
        printArray(students3);

        Sorter.bucketSort(students3);

        System.out.println("\nARRAY AFTER BUCKET SORT:");
        printArray(students3);
        }

    static void printArray(Student[] arr) {
        for (Student s : arr)
            System.out.println(s);
    }
}
