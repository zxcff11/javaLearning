package demo;

public class quickSort {

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int piv = Partition(A, low, high);
            quickSort(A, low, piv - 1);
            quickSort(A, piv + 1, high);
        }
    }

    public static int Partition(int[] A, int low, int high) {
        int piv = A[low];
        while (low < high) {
            while (low < high && A[high] >= piv) {
                high--;
            }
            // 将比枢纽小的元素移动到左端
            A[low] = A[high];
            while (low < high && A[low] <= piv) {
                low++;
            }
            // 将比枢纽大的元素移动到右端
            A[high] = A[low];
        }
        A[high] = piv;
        return high;
    }

    public static void main(String[] args) {
        int[] A = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.println(i);
        }
    }

}
