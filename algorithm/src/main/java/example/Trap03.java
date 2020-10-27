package example;

public class Trap03 {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int leftMax, rightMax;
        int left = 0, right = height.length - 1;
        leftMax = height[0];
        rightMax = height[height.length - 1];
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {3, 1, 4, 5};
        System.out.println(trap(n));
    }
}
