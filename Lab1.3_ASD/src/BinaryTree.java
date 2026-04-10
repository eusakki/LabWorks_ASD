import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    // Adding elements (simple Binary tree search by studentId)
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node node, Student student) {
        if (node == null)
            return new Node(student);

        if (student.studentId.compareTo(node.data.studentId) < 0)
            node.left = insertRec(node.left, student);
        else
            node.right = insertRec(node.right, student);

        return node;
    }

    // Tree traversal by iterative Depth-First Search
    public void iterativeDFS() {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        System.out.printf("%-15s %-10s %-5s %-10s %-12s\n",
                "Surname", "Name", "Course", "ID", "Birth");

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.data);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    // lvl 2 - searching student on 2nd course who was born in the winter
    public List<Student> findWinterSecondCourse() {
        List<Student> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.data.course == 2 && current.data.bornInWinter())
                result.add(current.data);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }

        return result;
    }

    // lvl 3 - removing students by the same criteria
    public void removeWinterSecondCourse() {
        List<Student> toDelete = findWinterSecondCourse();

        for (Student s : toDelete) {
            root = deleteRec(root, s.studentId);
        }
    }

    private Node deleteRec(Node node, String id) {
        if (node == null)
            return null;

        if (id.compareTo(node.data.studentId) < 0)
            node.left = deleteRec(node.left, id);
        else if (id.compareTo(node.data.studentId) > 0)
            node.right = deleteRec(node.right, id);
        else {
            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            Node min = findMin(node.right);
            node.data = min.data;
            node.right = deleteRec(node.right, min.data.studentId);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;

        return node;
    }
}
