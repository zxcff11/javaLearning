package main.java.并行计算作业;

public class LinearRecurrence {


    /**
     * 一阶线性递推计算 y[n] = a * y[n-1] + b * x[n]
     *
     * @param x  输入序列
     * @param a  系数 a
     * @param b  系数 b
     * @param y0 初始值 y[0]
     * @return 输出序列 y
     */
    public static double[] computeRecurrence(double[] x, double a, double b, double y0) {
        int n = x.length;
        double[] y = new double[n];
        y[0] = a * y0 + b * x[0];  // 初始递推

        for (int i = 1; i < n; i++) {
            y[i] = a * y[i - 1] + b * x[i];
        }

        return y;
    }

    public static void main(String[] args) {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};  // 输入数据
        double a = 0.5;
        double b = 1.0;
        double y0 = 0.0;

        double[] y = computeRecurrence(x, a, b, y0);

        System.out.println("输出序列 y:");
        for (double v : y) {
            System.out.printf("%.4f ", v);
        }
    }

}
