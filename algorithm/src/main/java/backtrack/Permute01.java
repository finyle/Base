package backtrack;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.LinkedList;
import java.util.List;

public class Permute01 {

    private static List<List<Integer>> res = new LinkedList<>();

    private static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
