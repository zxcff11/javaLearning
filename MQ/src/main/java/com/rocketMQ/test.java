package com.rocketMQ;

public class test {

     static public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][n-1-i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = rotate(nums);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}
