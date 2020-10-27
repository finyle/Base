package sort;

public class HeapSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        buildHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            len--;
            sink(arr, 0, len);
        }
    }

    private static void buildHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            sink(arr, i, len);
        }
    }

    private static void sink(int[] arr, int index, int len) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int present = index;

        if (leftChild < len && arr[leftChild] > arr[present]) present = leftChild;
        if (rightChild < len && arr[rightChild] > arr[present]) present=rightChild;
        if (present != index) {
            int tmp = arr[index];
            arr[index] = arr[present];
            arr[present] = tmp;
            sink(arr, present, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 5};
        sort(arr);
        for (int num:
                arr) {
            System.out.println(num);
        }
    }
}
