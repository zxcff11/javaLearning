package demo.数据结构与算法;

public class QuickSort {

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int piv = Partition(arr, left, right);
            quickSort(arr, left, piv - 1);
            quickSort(arr, piv + 1, right);
        }


    }

    private static int Partition(int[] arr, int left, int right) {

        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        // arr[right] = pivot;
        return left;

    }

    public static void main(String[] args) {
        int[] A = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.println(i);
        }

    }
}
