package demo.数据结构与算法;

public class BubbleSort {

    private static void bubblesort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {49, 38, 65, 97, 76, 13, 27, 49};
        bubblesort(A);
        for (int i : A) {
            System.out.print(i + " ");
        }


    }
}
