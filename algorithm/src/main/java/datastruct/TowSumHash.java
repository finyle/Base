package datastruct;

import java.util.Arrays;
import java.util.HashMap;

public class TowSumHash {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[] {i, index.get(other)};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 6};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
