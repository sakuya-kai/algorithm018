package com.sakuya.leetcode.week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal1122 {

    /**
     * 时间复杂度O(N * M)
     * 空间复杂度O(N)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index1 = 0, index2 = 0;
        while (index2 < arr2.length) {
            for (int i = index2; i < arr1.length; i++) {
                if (arr1[i] == arr2[index2]) {
                    swap(arr1, index1, i);
                    index1++;
                }
            }
            index2++;
        }
        if (index1 < arr1.length - 1) {
            int[] restArr = new int[arr1.length - index1];
            int restIndex = 0;
            for (int i = index1; i < arr1.length; i++) {
                restArr[restIndex++] = arr1[i];
            }
            Arrays.sort(restArr);
            restIndex = 0;
            while (index1 < arr1.length) {
                arr1[index1++] = restArr[restIndex++];
            }
        }

        return arr1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 利用基数排序
     *
     * 时间复杂度O(N + M + max)
     * 空间复杂度O(max)
     */
    public int[] _relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int x : arr1) {
            max = Math.max(max, x);
        }
        int[] arr3 = new int[max + 1];
        for (int x : arr1) {
            arr3[x] += 1;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int y : arr2) {
            while (arr3[y] > 0) {
                ans[index++] = y;
                arr3[y] -= 1;
            }
        }
        for (int i = 0; i <= max; i++) {
            while (arr3[i] > 0) {
                ans[index++] = i;
                arr3[i] -= 1;
            }
        }
        return ans;
    }

}
