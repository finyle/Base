package division;

public class BinarySearch02 {
    public static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        System.out.println(left_bound(nums, target));
    }
}
