package dp;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LengthOfLIS02 {

    public static int lengthOfOLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) right = mid;
                else if (top[mid] < poker) left = mid + 1;
                else right = mid;
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4, 2, 3};
        System.out.println(lengthOfOLIS(nums));
    }
}
