package org.songdan.leetcode.easy;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author: Songdan
 * @create: 2020-07-12 17:53
 **/
public class SearchInsert {

    public int run(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            int mVal = nums[mid];
            if (target == mVal) {
                return mid;
            } else {
                if (target < mVal) {
                    hight = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.run(new int[]{1, 3, 5, 6}, 2));
    }

}
