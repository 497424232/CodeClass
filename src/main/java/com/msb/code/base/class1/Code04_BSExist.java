package com.msb.code.base.class1;

/**
 * 在一个有序数组中，找一个数是否存在
 * 使用二分法
 */
public class Code04_BSExist {
    public static void main(String[] args) {

    }

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R
        while (L < R) {
            mid = L + ((R - L) >> 1); // mid = (L + R) / 2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
}
