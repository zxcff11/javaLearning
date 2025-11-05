package demo.数据结构与算法;

public class heapSort {

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i > 0; i--) {
            headAdjust(a, i, n);
        }
    }

    private static void headAdjust(int[] a, int k, int n) {
        a[0] = a[k];
        for (int i = 2 * k; i <= n; i *= 2) {
            if (i < n && a[i] < a[i + 1]) {
                i++;
            }
            if (a[0] >= a[i]) {
                break;
            } else {
                a[k] = a[i];
                k = i;
            }
        }
        a[k] = a[0];
    }

    private static void heapSort(int[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i > 1; i--) {
            System.out.println(a[1]);
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            headAdjust(a, 1, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 49, 38, 65, 97, 76, 13, 27, 49};
        heapSort(A, A.length - 1);
    }
}
