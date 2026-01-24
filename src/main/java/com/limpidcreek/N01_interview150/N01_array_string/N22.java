package com.limpidcreek.N01_interview150.N01_array_string;

public class N22 {
    /**
     * 28. 找出字符串中第一个匹配项的下标
     *
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     *
     *
     * 提示：
     *
     * 1 <= haystack.length, needle.length <= 104
     * haystack 和 needle 仅由小写英文字符组成
     */

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        int[] next = new int[needle.length()];
        int i = 0;
        //构建needle的next数组
        for (int j = 1; j < needle.length(); j++) {
            while (i >= 0){
                if (needle.charAt(j) != needle.charAt(i)) {
                    if (i == 0){
                        next[j] = i;
                        break;
                    }else {
                        i = next[i - 1];
                    }
                }else {
                    next[j] = ++i;
                    break;
                }
            }
        }
        //构建结束，匹配开始
        int k = 0,l = 0;
        for (; k < haystack.length(); k++) {
            while (l > 0 && needle.charAt(l) != haystack.charAt(k)) {
                l = next[l - 1];
            }
            if (haystack.charAt(k) == needle.charAt(l)) {
                l++;
            }
            if (l == needle.length()) {
                return k - l + 1;
            }
        }
        return -1;
    }
}
