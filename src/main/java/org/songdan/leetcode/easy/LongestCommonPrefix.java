package org.songdan.leetcode.easy;

/**
 * 最大公共前缀
 *
 * @author: Songdan
 * @create: 2020-07-06 13:32
 **/
public class LongestCommonPrefix {

    public String execute(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String minLenStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length()<minLenStr.length()) {
                minLenStr = strs[i];
            }
        }
        char[][] chArrs = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chArrs[i] = strs[i].toCharArray();
        }
        char[] chs = minLenStr.toCharArray();
        String prefix = "";
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            boolean flag = true;
            for (int j = 0; j < chArrs.length; j++) {
                if (chArrs[j][i] != c) {
                    flag = false;
                }
            }
            if (flag) {
                prefix += c;
            }else{
                break;
            }
        }
        return prefix;
    }

}
