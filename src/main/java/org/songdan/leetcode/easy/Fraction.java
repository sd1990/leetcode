package org.songdan.leetcode.easy;

/**
 * 分式化简,将连分数化简为最大分数
 *
 * 从复杂的公式中推导出模型 1+1/2
 *
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 *
 *
 * @author: Songdan
 * @create: 2020-05-01 21:05
 **/
public class Fraction {

    /**
     *
     * @param cont
     * @return int[0] 代表分子 int[1]代表分母
     */
    public int[] sulution(int[] cont){

        return solution0(cont, 0);
    }

    private int[] solution0(int[] cont,int index) {
        if (index==cont.length-1) {
            return new int[]{cont[index],1};
        }
        int[] res = solution0(cont, index+1);
        return new int[]{cont[index] * res[0] + res[1], res[0]};
    }




}
