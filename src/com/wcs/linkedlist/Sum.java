package com.wcs.linkedlist;

/**
 * @Description: 用递归的方式将数组的所有元素加起来求和
 * 递归：将原问题转换成最小的问题，通过解决最小的问题，来解决原问题。
 * (需要通过人工逻辑控制，跳出递归
 * 如：当l=数组的长度的时候,就没有数据了，所以跳出递归，返回一个0作为加数与先前的加数相加作为最终的总数返回)
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/11 17:18
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }

}
