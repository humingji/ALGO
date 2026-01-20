package com.limpidcreek.N01_interview150.N01_array_string;

public class N19 {
    /**
     * 14. 最长公共前缀
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     *
     * 提示：
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 如果非空，则仅由小写英文字母组成
     */

    public String longestCommonPrefix(String[] strs) {
        String shortest = "";
        int len = Integer.MAX_VALUE;
        if(strs.length == 1) {
            return strs[0];
        }
        for (int i = strs.length - 1; i >= 0; i--) {
            if(strs[i].length() < len) {
                len = strs[i].length();
                shortest = strs[i];
            }
        }
        String commonPrefix = "";
        boolean found = false;
        for (int i = 0; i < len; i++) {
            String prefix = shortest.substring(0, i + 1);
            for (int j = strs.length - 1; j >= 0; j--) {
                if (strs[j].startsWith(prefix)) {
                    if (j == 0) {
                        commonPrefix = prefix;
                        break;
                    }
                }else {
                    found = true;
                    break;
                }
            }
        }
        return commonPrefix;
    }
}
