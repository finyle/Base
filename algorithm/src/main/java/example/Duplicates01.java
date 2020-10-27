package example;

public class Duplicates01 {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] n = {1, 1, 2, 3, 3, 3, 4};
        System.out.println(removeDuplicates(n));
    }
}
