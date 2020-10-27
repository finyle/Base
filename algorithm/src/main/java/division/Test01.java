package division;

import org.junit.Test;

public class Test01 {
        
    @Test
    public void test01() {

        BinarySearch01 bs = new BinarySearch01();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        System.out.println(bs.binarySearch(nums, target));
    }

    @Test
    public void test02() {

        BinarySearch02 bs = new BinarySearch02();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        System.out.println(bs.left_bound(nums, target));
    }

    @Test
    public void test03() {

        BinarySearch03 bs = new BinarySearch03();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        System.out.println(bs.right_bound(nums, target));
    }





}
