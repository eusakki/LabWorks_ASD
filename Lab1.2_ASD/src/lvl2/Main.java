package lvl2;

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

        table.print();
    }
}
