package main.java.并行计算作业;

public class Main {
    public static int findFirstDifferentBit(int a, int b) {
        int xorResult = a ^ b;

        if (xorResult == 0) {
            return -1; // 所有位都相同
        }

        // 计算最低设置位的位序（从右到左，从0开始计数）
        return Integer.numberOfTrailingZeros(xorResult);
    }

    public static void main(String[] args) {
        int a = 12; // 二进制: 1100
        int b = 10; // 二进制: 1010
        int result = findFirstDifferentBit(a, b);

        System.out.println("最低不同位的位序是: " + result); // 输出应为1（从右到左第2位）
    }
}