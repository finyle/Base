package sort;

public class MergeSort {
    public static void sort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        sort(tmpArr, arr, 0, arr.length - 1);
    }

    private static void sort(int[] tmpArr, int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        sort(tmpArr, arr, startIndex, midIndex);
        sort(tmpArr, arr, midIndex + 1, endIndex);
        merge(tmpArr, arr, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] tmpArr, int[] arr, int startIndex, int midIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
           tmpArr[i] = arr[i];
        }
        int left = startIndex, right = midIndex + 1;
        for (int j = startIndex; j <= endIndex; j++) {
            if (left > midIndex) arr[j] = tmpArr[right++];
            else if (right > endIndex) arr[j] = tmpArr[left++];
            else if (tmpArr[right] < tmpArr[left]) arr[j] = tmpArr[right++];
            else arr[j] = tmpArr[left++];
        }
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
