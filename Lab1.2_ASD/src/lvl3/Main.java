package lvl3;

import TrianglePackage.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter table size: ");
        int size = sc.nextInt();

        HashTable table = new HashTable(size);

        for (int i = 0; i < size; i++) {
            Triangle t = new Triangle();
            table.insert(t);
        }

        System.out.println("\nBefore deleting:");
        table.print();

        System.out.print("\nDelete triangles with perimetr > ");
        double limit = sc.nextDouble();

        table.removeByPerimeter(limit);

        System.out.println("\nAfter deleting:");
        table.print();
    }
}
