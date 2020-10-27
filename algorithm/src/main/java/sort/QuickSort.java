package sort;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int pivotIndex = partation(arr, startIndex, endIndex);
        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    private static int partation(int[] arr, int startInex, int endIndex) {
        int pivot = arr[startInex];
        int mark = startInex;
        for (int i = startInex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startInex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        sort(arr);
        for (int num:
                arr) {
            System.out.println(num);
        }
    }

}
