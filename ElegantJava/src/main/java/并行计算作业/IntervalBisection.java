package main.java.并行计算作业;

public class IntervalBisection {

    // 定义要求解的方程，修改为 f(x) = x^2 - 2x - 2
    public static double equation(double x) {
        return Math.pow(x, 2) - 2 * x - 2;
    }

    // 区间分割法实现（代码保持不变）
    public static double intervalBisection(double a, double b, double tolerance) {
        if (equation(a) == 0) return a;
        if (equation(b) == 0) return b;

        if (equation(a) * equation(b) >= 0) {
            throw new IllegalArgumentException("区间端点函数值必须异号");
        }

        double c = a;
        int iteration = 0;

        while ((b - a) / 2 > tolerance) {
            c = (a + b) / 2;

            System.out.printf("迭代 %d: 区间 [%.6f, %.6f], 中点 %.6f, f(中点)=%.6f%n",
                    iteration++, a, b, c, equation(c));

            if (equation(c) == 0) {
                return c;
            }

            if (equation(c) * equation(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        return (a + b) / 2;
    }

    public static void main(String[] args) {
        // 修改初始区间为 [2, 4]，因为 f(2)=-2, f(4)=6，满足异号条件
        double a = 2.0;
        double b = 4.0;
        double tolerance = 1e-6;

        try {
            double root = intervalBisection(a, b, tolerance);
            System.out.printf("方程的近似根为: %.6f%n", root);
            System.out.printf("f(%.6f) = %.6f%n", root, equation(root));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


