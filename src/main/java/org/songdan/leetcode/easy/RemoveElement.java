package org.songdan.leetcode.easy;

/**
 * 原地移除数组中制定的元素
 *
 * @author: Songdan
 * @create: 2020-07-12 17:04
 **/
public class RemoveElement {

    public int run(int[] nums,int val) {
        //唯一元素的指针
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveElement removeDuplicates = new RemoveElement();
        int result = removeDuplicates.run(nums,1);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
