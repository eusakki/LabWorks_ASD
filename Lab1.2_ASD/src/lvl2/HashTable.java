package lvl2;

import TrianglePackage.Triangle;

public class HashTable {
    private Triangle[] table;
    private int size;
    private final double A = 0.618033;

    public HashTable(int size) {
        this.size = size;
        table = new Triangle[size];
    }

    private int hash(double key) {
        double fractional = (key * A) % 1;
        return (int)(size * fractional);
    }

    public boolean insert(Triangle t) {
        int index = hash(t.getArea());
        int start = index;

        while (table[index] != null) {
            index = (index + 1) % size;
            if (index == start)
                return false;
        }

        table[index] = t;
        return true;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null)
                System.out.printf("[%d] Key=%.2f %s\n", i, table[i].getArea(), table[i]);
            else
                System.out.printf("[%d] --- empty ---\n", i);
        }
    }
}
