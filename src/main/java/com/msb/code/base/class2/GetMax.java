package com.msb.code.base.class2;

public class GetMax {
    public static void main(String[] args) {
        int [] arr = new int[21];

        getMax(arr, 0 , arr.length -1);
    }

    public static int getMax(int[] arr, int L, int R) {

        if (L == R){
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int left = getMax(arr, L, mid);
        int right = getMax(arr, mid + 1, R);

        return Math.max(left, right);

    }
}
