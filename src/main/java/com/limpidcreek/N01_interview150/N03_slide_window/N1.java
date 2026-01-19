package com.limpidcreek.N01_interview150.N03_slide_window;

public class N1 {
/*

    209. 长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 target 。

    找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



    示例 1：

    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    示例 2：

    输入：target = 4, nums = [1,4,4]
    输出：1
    示例 3：

    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0


    提示：
        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104
*/

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        sum += nums[b];
        while(b < nums.length) {
            if (target<=sum) {
                if(b-a+1 <= min) {
                    min = b-a+1;
                    if(b == nums.length) {
                        break;
                    }
                }
                sum -= nums[a];
                a++;
            }else{
                b++;
                if(b == nums.length) {
                    break;
                }
                sum += nums[b];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
