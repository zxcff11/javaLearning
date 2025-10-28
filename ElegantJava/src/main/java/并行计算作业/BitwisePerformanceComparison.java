package main.java.并行计算作业;

public class BitwisePerformanceComparison {
    public static void main(String[] args) {
        final int TEST_SIZE = (int) 1e12; // 测试次数
        int testValue = 0x12345678;      // 测试用的整数

        // 1. 测试奇偶性判断
        long startTime, endTime;

        // 常规方式
        startTime = System.nanoTime();
        boolean parityNormal = false;
        for (int i = 0; i < TEST_SIZE; i++) {
            parityNormal = (testValue % 2) == 0;
        }
        endTime = System.nanoTime();
        System.out.printf("常规奇偶判断耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);

        // 位运算方式
        startTime = System.nanoTime();
        boolean parityBitwise = false;
        for (int i = 0; i < TEST_SIZE; i++) {
            parityBitwise = (testValue & 1) == 0;
        }
        endTime = System.nanoTime();
        System.out.printf("位运算奇偶判断耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);

        // 2. 测试乘除2的幂运算
        // 常规方式
        startTime = System.nanoTime();
        int resultNormal = 0;
        for (int i = 0; i < TEST_SIZE; i++) {
            resultNormal = (testValue * 8) / 4;
        }
        endTime = System.nanoTime();
        System.out.printf("常规乘除运算耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);

        // 位运算方式
        startTime = System.nanoTime();
        int resultBitwise = 0;
        for (int i = 0; i < TEST_SIZE; i++) {
            resultBitwise = (testValue << 3) >> 2;
        }
        endTime = System.nanoTime();
        System.out.printf("位运算乘除运算耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);

        // 3. 测试掩码操作（清零特定位）
        int mask = ~(1 << 16);

        // 常规方式
        startTime = System.nanoTime();
        int maskedNormal = 0;
        for (int i = 0; i < TEST_SIZE; i++) {
            if ((testValue & (1 << 16)) != 0) {
                maskedNormal = testValue - (1 << 16);
            } else {
                maskedNormal = testValue;
            }
        }
        endTime = System.nanoTime();
        System.out.printf("常规掩码操作耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);

        // 位运算方式
        startTime = System.nanoTime();
        int maskedBitwise = 0;
        for (int i = 0; i < TEST_SIZE; i++) {
            maskedBitwise = testValue & mask;
        }
        endTime = System.nanoTime();
        System.out.printf("位运算掩码操作耗时: %.2f 毫秒%n", (endTime - startTime) / 1e6);
    }
}