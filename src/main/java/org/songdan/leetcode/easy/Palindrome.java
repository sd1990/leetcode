package org.songdan.leetcode.easy;

import java.util.LinkedList;

/**
 * 回文数字
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 *
 * @author: Songdan
 * @create: 2020-05-05 15:03
 **/
public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int num = x;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        while (x != 0) {
            queue.addFirst(x % 10);
            stack.addLast(x % 10);
            x /= 10;
        }
        while (!queue.isEmpty()) {
            if (!queue.removeFirst().equals(stack.removeFirst())) {
                return false;
            }
        }
        return true;
    }

}
