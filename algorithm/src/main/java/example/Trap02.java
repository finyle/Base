package example;

public class Trap02 {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        // 数组充当备忘录
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        // 初始化base case
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        // 从左到右计算leftMax
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // 从右到左计算rightMax
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // 计算结果
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {3, 1, 4, 5};
        System.out.println(trap(n));
    }
}
