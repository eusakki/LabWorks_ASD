package TrianglePackage;

public class Triangle {
    private double x1, y1, x2, y2, x3, y3;

    public Triangle () {
        generateValidTriangle();
    }

    private void generateValidTriangle() {
        do {
            x1 = Math.random() * 10;
            y1 = Math.random() * 10;
            x2 = Math.random() * 10;
            y2 = Math.random() * 10;
            x3 = Math.random() * 10;
            y3 = Math.random() * 10;
        } while (getArea() == 0);
    }

    private double side(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double getPerimetr() {
        return side(x1, y1, x2, y2) +
               side(x2, y2, x3, y3) +
               side(x3, y3, x1, y1);
    }

    public double getArea() {
        double a = side(x1, y1, x2, y2);
        double b = side(x2, y2, x3, y3);
        double c = side(x3, y3, x1, y1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return String.format("Triangle: P=%.2f S=%.2f", getPerimetr(), getArea());
    }
}
