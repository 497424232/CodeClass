package com.msb.code.base.class1;

/**
 * 熟悉异或运算
 */
public class Code07_EvenTimesOddTimes {

    /**
     * 数组中 只有一种数出现奇数次
     * @param arr
     * @return
     */
    public static void printOddTimesNum1(int[] arr) {
        int erInfo = 0;
        for (int i = 0; i < arr.length; i++) {
            erInfo = erInfo ^ arr[i];
        }
        System.out.println("eor:" + erInfo);
    }

    /**
     * 数组中 有两种种数出现奇数次
     * @param arr
     * @return
     */
    public static void printOddTimesNum2(int[] arr) {
        int erInfo = 0;
        for (int i = 0; i < arr.length; i++) {
            erInfo = erInfo ^ arr[i];
        }

        //取两种数异或结果的第一个唯一的数
        int rightOne = erInfo & (~erInfo + 1);
        int one = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {
                one ^= arr[i];
            }

        }
        erInfo ^= one;
        System.out.println("eor:" + erInfo + ", rightOne = " + rightOne);

    }

    // arr中，有两种数，出现奇数次(左老师代码)
//    public static void printOddTimesNum2(int[] arr) {
//        int eor = 0;
//        for (int i = 0; i < arr.length; i++) {
//            eor ^= arr[i];
//        }
//        // eor = a ^ b
//        // eor != 0
//        // eor必然有一个位置上是1
//        // 0110010000
//        // 0000010000
//        int rightOne = eor & (~eor + 1); // 提取出最右的1
//        int onlyOne = 0; // eor'
//        for (int i = 0 ; i < arr.length;i++) {
//            //  arr[1] =  111100011110000
//            // rightOne=  000000000010000
//            if ((arr[i] & rightOne) != 0) {
//                onlyOne ^= arr[i];
//            }
//        }
//        System.out.println(onlyOne + " " + (eor ^ onlyOne));
//    }


    public static int bit1counts(int N) {
        int count = 0;

        //   011011010000
        //   000000010000     1

        //   011011000000
        //



        while(N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
            // N -= rightOne
        }


        return count;

    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }
}
