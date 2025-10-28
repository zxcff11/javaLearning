package main.java.并行计算作业;

import java.util.Scanner;

public class BufferOverflowExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String input = scanner.nextLine(); // 假设用户输入超长字符串

        // 定义固定长度的缓冲区（仅能容纳10个字符）
        char[] buffer = new char[10];

        // 错误方式：直接复制输入字符串到缓冲区，未检查长度（模拟漏洞）
        for (int i = 0; i < input.length(); i++) {
            buffer[i] = input.charAt(i); // 当input长度>10时，触发数组越界（缓冲区溢出）
        }

        System.out.println("用户名为：" + new String(buffer));
        scanner.close();
    }
}