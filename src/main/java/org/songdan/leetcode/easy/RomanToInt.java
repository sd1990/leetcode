package org.songdan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *
 * @author: Songdan
 * @create: 2020-05-23 17:07
 **/
public class RomanToInt {

    private Map<String, Integer> mapping = new HashMap<>();

    {
        mapping.put("I", 1);
        mapping.put("V", 5);
        mapping.put("X", 10);
        mapping.put("L", 50);
        mapping.put("C", 100);
        mapping.put("D", 500);
        mapping.put("M", 1000);
    }

    public int convert(String exp) {
        char[] chars = exp.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            char c1 = chars[i];
            Integer n1 = mapping.get(String.valueOf(c1));
            if (i < chars.length - 1) {
                char c2 = chars[i+1];
                Integer n2 = mapping.get(String.valueOf(c2));
                if (n1 < n2) {
                    sum += (n2 - n1);
                    i++;
                    continue;
                }
            }
            sum += n1;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt roman = new RomanToInt();
        System.out.println(roman.convert("IV"));
    }

}
