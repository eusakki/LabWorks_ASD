import java.util.*;

public class BST {
    Node root;

    // Insertion at the root
    public Node insert(Node root, Student s) {
        if (root == null)
            return new Node(s);

        root = splay(root, s.name);

        if (root.data.name.equals(s.name))
            return root;

        Node newNode = new Node(s);

        if (s.name.compareTo(root.data.name) < 0) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }

        return newNode;
    }

    // Search
    public Student search(String key) {
        root = splay(root, key);

        if (root != null && root.data.name.equals(key))
            return root.data;

        return null;
    }

    // BFS output
    public void printBFS() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }

    // Splay (Amortized)
    private Node splay(Node root, String key) {
        if (root == null || root.data.name.equals(key))
            return root;

        // Left
        if (key.compareTo(root.data.name) < 0) {
            if (root.left == null)
                return root;

            // Zig-Zig
            if (key.compareTo(root.left.data.name) < 0) {
                root.left.left = splay(root.left.left, key);
                root = rotateRight(root);
            }
            // Zig-Zag
            else if (key.compareTo(root.left.data.name) > 0) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = rotateLeft(root.left);
            }

            return (root.left == null) ? root : rotateRight(root);
        }
        //Right
        else {
            if (root.right == null)
                return root;

            // Zag-Zag
            if (key.compareTo(root.right.data.name) > 0) {
                root.right.right = splay(root.right.right, key);
                root = rotateLeft(root);
            }
            // Zag-Zig
            else if (key.compareTo(root.right.data.name) < 0) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rotateRight(root.right);
            }

            return (root.right == null) ? root : rotateLeft(root);
        }
    }

    // Rotations
    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }
}
