package org.songdan.leetcode.easy;

/**
 * 实现 strStr() 函数。
 * TODO KMP算法实现
 *
 * @author: Songdan
 * @create: 2020-07-12 17:32
 **/
public class StrStr {

    public int run(String haystack, String needle) {
        //暴力破解
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return needle.length();
        }
        char[] chs1 = haystack.toCharArray();
        char[] chs2 = needle.toCharArray();
        for (int i = 0; i < chs1.length - chs2.length+1; i++) {
            if (chs1[i] != chs2[0]) {
                continue;
            }
            int m = i+1;
            boolean find = true;
            for (int n = 1; n < chs2.length;) {
                if (chs1[m++] != chs2[n++]) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return -1;
    }

}
