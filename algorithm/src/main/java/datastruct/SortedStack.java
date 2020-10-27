package datastruct;

import java.util.Arrays;
import java.util.Stack;

public class SortedStack {
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
