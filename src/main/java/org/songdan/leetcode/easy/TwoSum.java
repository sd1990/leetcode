package org.songdan.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * @author: Songdan
 * @create: 2020-05-04 16:25
 **/
public class TwoSum {

    public int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num0 = nums[i];
            int num1 = target - num0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]==num1) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] solution1(int[] nums, int target) {
        Num[] numArr = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = new Num(nums[i], i);
        }
        Comparator<Num> comparator = Comparator.comparingInt(o -> o.value);
        Arrays.sort(numArr, comparator);
        for (int i = 0; i < numArr.length; i++) {
            Num num0 = numArr[i];
            int j = Arrays.binarySearch(numArr,i+1,numArr.length,new Num(target - num0.value,-1),comparator);
            if (j >=0) {
                Num num1 = numArr[j];
                return new int[]{num0.index, num1.index};
            }
        }
        return null;
    }

    class Num{
        int value;
        int index;

        public Num(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] solution3(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hash.containsKey(nums[i])) {
                return new int[]{i, hash.get(nums[i])};
            }
            hash.put(target - nums[i], i);
        }
        return null;
    }
}
