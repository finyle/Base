package division;

public class BinarySearch01 {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) return mid + 1;
            else if (nums[mid] > target) return mid - 1;
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        System.out.println(binarySearch(nums, target));
    }
}
