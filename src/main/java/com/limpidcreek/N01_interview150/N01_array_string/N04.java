package com.limpidcreek.N01_interview150.N01_array_string;

public class N04 {

    /*80. 删除有序数组中的重复项 II
    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    示例 1：

    输入：nums = [1,1,1,2,2,3]
    输出：5, nums = [1,1,2,2,3]
    解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
    示例 2：

    输入：nums = [0,0,1,1,1,1,2,3,3]
    输出：7, nums = [0,0,1,1,2,3,3]
    解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。


    提示：

            1 <= nums.length <= 3 * 104
            -104 <= nums[i] <= 104
    nums 已按升序排列*/

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public static int removeDuplicates(int[] nums) {
        int start = 0;
        int start_ = 1;
        int count = 1;
        while (start_ < nums.length) {
            if (nums[start_] == nums[start]) {
                if (count != 2){
                    count++;
                    nums[++start]= nums[start_];}else{
                    start_++;
                    continue;
                }
            }else if(nums[start_] != nums[start]) {
                nums[++start]= nums[start_];
                count = 1;
                start_++;
            }
        }
        return ++start;
    }

}
