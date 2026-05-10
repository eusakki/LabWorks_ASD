public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[20];

        // Unsorted insert
        students[0] = new Student("Vasyuk", "Valera", 2, "M", false);
        students[1] = new Student("Dmitrenko", "Yurianna", 3, "F", true);
        students[2] = new Student("Samar", "Yaroslav", 6, "M", true);
        students[3] = new Student("Yevtushenko", "Anya", 1, "F", false);
        students[4] = new Student("Koval", "Valera", 6, "M", true);

        for (int i = 5; i < 20; i++) {
            students[i] = new Student(
                    "Sur" + i,
                    "Name" + i,
                    i % 6 + 1,
                    i % 2 == 0 ? "M" : "F",
                    i % 3 == 0
            );
        }

        // Output
        System.out.println("Original array:");
        for (Student s : students)
            System.out.println(s);

        // Search
        System.out.println("\nSearch result:");
        System.out.println(SearchUtils.linearSearch(students, "Valera"));

        // Delete
        students = SearchUtils.removeStudents(students);

        System.out.println("\nAfter removal:");
        for (Student s : students)
            System.out.println(s);

        // BST
        BST tree = new BST();

        for (Student s : students) {
            tree.root = tree.insert(tree.root, s);

//            System.out.println("\nBST after inserting: " + s.name);
//            tree.printBFS();
        }
        System.out.println("\nBST after inserting students:");
        tree.printBFS();

        // Search in BST
        System.out.println("\nBST search result:");
        System.out.println(tree.search("Anya"));
    }
}
