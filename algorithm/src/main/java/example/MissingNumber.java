package example;

public class MissingNumber {
    static int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {0,3,1,4};
        System.out.println(missingNumber(n));
    }

}
