package com.limpidcreek.N01_interview150.N01_array_string;

public class N15 {
    /**
     * 42. 接雨水
     *
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     */
    public int trap(int[] height) {
        int[] left2right = new int[height.length];
        int left = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= left) {
                left = height[i];
                left2right[i] = height[i];
            }
        }
        int right = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= right) {
                right = height[i];
                left2right[i] = height[i];
            }
        }
        left = 0;
        int leftHeight = 0;
        int sum = 0;
        int divide = 0;
        for (int i = 0; i < left2right.length; i++) {
            if (left2right[i] == 0) {
                divide += height[i];
            } else {
                if (left2right[i] > leftHeight) {
                    sum += leftHeight * (i - left - 1) - divide;
                    left = i;
                    leftHeight = left2right[i];
                    divide = 0;
                } else {
                    sum += left2right[i] * (i - left - 1) - divide;
                    left = i;
                    leftHeight = left2right[i];
                    divide = 0;
                }
            }
        }
        return sum;
    }
}
