package com.limpidcreek.N01_interview150.N01_array_string;

import java.util.ArrayList;
import java.util.List;

public class N21 {
    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     */
    public String convert(String s, int numRows) {
        //第一想法使用二维数组，写出来非常可怕而且不对
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : list) res.append(row);
        return res.toString();
    }
}
