package example;

public class Trap01 {
    public static int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            // 找右边最高的柱子
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            // 如果自己就是最高的话，
            // leftMax == rightMax == height[i]
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {3, 1, 4, 5};
        System.out.println(trap(n));
    }
}
