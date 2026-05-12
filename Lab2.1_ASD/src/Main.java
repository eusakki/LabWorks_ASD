import java.util.Scanner;

public class Main {
    // Функція для інтегрування
    static double f(double x) {
        return Math.sqrt(x * x + 9) / Math.exp(0.1 * x);
    }

    // Аналітичне (чисельно точне по малому кроку)
    static double accurateIntegral(double a, double b) {
        double h = 0.0001;
        double sum = 0;
        for (double x = a; x < b; x += h)
            sum += f(x) * h;
        return sum;
    }

    // Метод прямокутників
    static double rectangles(double a, double b, double h) {
        double sum = 0;
        for (double x = a; x < b; x += h)
            sum += f(x);
        return sum * h;
    }

    // Метод трапецій
    static double trapezoids(double a, double b, double h) {
        double sum = (f(a) + f(b) / 2);
        for (double x = a + h; x < b; x += h)
            sum += f(x);
        return sum * h;
    }

    // Метод Сімпсона
    static double simpson(double a, double b, double h) {
        int n = (int)((b - a) / h);
        if (n % 2 == 1) n++;

        double sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 2 == 0 ? 2 : 4) * f(x);
        }
        return sum * h / 3;
    }

    // Функція для рівняння
    static double func(double x) {
        return 2 * x - 3 * Math.sin(2 * x) - 1;
    }

    // Похідна
    static double derivative(double x) {
        return 2 - 6 * Math.cos(2 * x);
    }

    // LVL2: Метод половинного ділення
    static double bisection(double a, double b, double eps) {
        if (func(a) * func(b) >= 0) return Double.NaN;

        while ((b - a) / 2 > eps) {
            double c = (a + b) / 2;
            if (func(c) == 0) return c;
            if (func(a) * func(c) < 0)
                b = c;
            else
                a = c;
        }
        return (a + b) / 2;
    }

    // LVL2: Метод дотичних (Ньютона)
    static double newton(double x0, double eps) {
        double x = x0;
        while (true) {
            double x1 = x - func(x) / derivative(x);
            if (Math.abs(x1 - x) < eps) return x1;
            x = x1;
        }
    }

    // LVL2: Метод хорд
    static double secant(double a, double b, double eps) {
        double x0 = a, x1 = b;
        while (Math.abs(x1 - x0) > eps) {
            double x2 = x1 - func(x1) * (x1 - x0) / (func(x1) - func(x0));
            x0 = x1;
            x1 = x2;
        }
        return x1;
    }

    // LVL3: Рунге-Кутта(4-го порядку)
    static double dy(double x, double y) {
        return (1 + y) / Math.tan(x);
    }

    static void rungeKutta(double x0, double y0, double h, double xn) {
        System.out.println("\n----- Runge-Kutta table -----");
        System.out.printf("%-10s %-10s\n", "x", "y");

        double x = x0;
        double y = y0;

        while (x <= xn) {
            System.out.printf("%-10.4f %-10.4f\n", x, y);

            double k1 = h * dy(x,y);
            double k2 = h * dy(x + h/2, y + k1/2);
            double k3 = h * dy(x + h/2, y + k1/2);
            double k4 = h * dy(x + h, y + k3);

            y += (k1 + 2*k2 + 2*k3 + k4) / 6;
            x += h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // LVL1
        System.out.println("Enter limits a, b and step h:"); // 3, 8, 1
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double h = sc.nextDouble();

        System.out.println("\n----- Integration -----");
        System.out.println("Метод прямокутників: " + rectangles(a, b, h));
        System.out.println("Метод трапецій: " + trapezoids(a, b, h));
        System.out.println("Метод Сімпсона: " + simpson(a, b, h));
        System.out.println("Accurate: " + accurateIntegral(a, b));

        // LVL2
        System.out.println("\nEnter interval for root finding:"); // Один корінь: 0, 2; Декілька: -3, 3; Жодного: 3, 4
        double l = sc.nextDouble();
        double r = sc.nextDouble();
        double eps = 0.0001;

        System.out.println("\n----- Roots -----");
        System.out.println("Метод половинного ділення: " + bisection(l, r, eps));
        System.out.println("Метод дотичних (Ньютона): " + newton((l + r)/2, eps));
        System.out.println("Метод хорд: " + secant(l, r, eps));

        // LVL3
        System.out.println("\nEnter x0, y0, h, xn:"); // 1, 1, 0.1, 2
        double x0 = sc.nextDouble();
        double y0 = sc.nextDouble();
        double step = sc.nextDouble();
        double xn = sc.nextDouble();

        rungeKutta(x0, y0, step, xn);
    }
}