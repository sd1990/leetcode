package org.songdan.leetcode.easy;

/**
 * 移除有序数组中重复的元素
 *
 * @author: Songdan
 * @create: 2020-07-12 17:04
 **/
public class RemoveDuplicates {

    public int run(int[] nums) {
        //唯一元素的指针
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.run(nums);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
