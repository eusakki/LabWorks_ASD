import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Student("Yevtushenko", "Daniel", 2, "KB101",
                LocalDate.of(2007,4,4)));

        tree.insert(new Student("Dmitrenko", "Yurii", 2, "KB102",
                LocalDate.of(2007,12,27)));

        tree.insert(new Student("Vlasyuk", "Artem", 3, "KB103",
                LocalDate.of(2006,9,8)));

        tree.insert(new Student("Samar", "Yaroslav", 4, "KB104",
                LocalDate.of(2005,2,23)));

        tree.insert(new Student("Vasyuk", "Valera", 2, "KB105",
                LocalDate.of(2007,1,15)));

        System.out.println("TREE CONTENT:");
        tree.iterativeDFS();

        //LVL 2
        System.out.println("\n Students of 2nd course born in winter:");
        List<Student> result = tree.findWinterSecondCourse();

        for (Student s : result)
            System.out.println(s);

        //LVL 3
        tree.removeWinterSecondCourse();
        System.out.println("\nTREE AFTER DELETION:");
        tree.iterativeDFS();
    }
}
