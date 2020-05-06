package org.songdan.leetcode.easy;

/**
 * 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author: Songdan
 * @create: 2020-05-05 13:04
 **/
public class NumReverse {

    public int solution2(int n) {
        if (n == 0) {
            return 0;
        }
        boolean start = false;
        StringBuilder s = new StringBuilder();
        long num = Math.abs((long)n);
        while (num != 0) {
            long i = num % 10;
            if (i>0 && !start) {
                start = true;
            }
            if (start) {
                s.append(i);
            }
            num /= 10;
        }
        System.out.println(s);
        Long l = Long.parseLong(s.toString());
        if (l > Integer.MAX_VALUE || l<Integer.MIN_VALUE) {
            return 0;
        }
        return l.intValue() * (n > 0 ? 1 : -1);
    }

    public int solution(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int)res == res ? (int)res : 0;
    }

    public static void main(String[] args) {
        System.out.println(new NumReverse().solution(123));
    }

}
