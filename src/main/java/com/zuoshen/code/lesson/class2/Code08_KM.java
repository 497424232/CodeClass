package com.zuoshen.code.lesson.class2;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 在数组中，只有一种数出现了K次，其他数都出现了M次
 * 找出出现K次的数
 */
public class Code08_KM {


    /**
     * 查找整形数字，长度为32，通过位运算获取答案
     *
     * @return
     */
    public static int findNumOnlyKTimes(int[] arr, int k, int m) {
        int ans = 0;
        // 定义一个32长度的数组，记录整个数组中的1的个数
        int[] allAnsArr = new int[32];

        // 记录整形数组中所有数转为2进制后
        // 0~31 位置出现了多少次1，
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < allAnsArr.length; j++) {
                allAnsArr[j] += (arr[i] >> j )& 1;
            }
        }
        for (int i = 0; i < allAnsArr.length; i++) {
            // 模m 等于0，表示在这个位置上的数出现了m次
            if (allAnsArr[i] % m != 0) {
                ans |= (1<< i);
            }
        }
        return ans;
    }

    /**
     * 测试方法
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer integer = map.get(arr[i]);
                map.put(arr[i], integer+1) ;
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == k) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    public static int[] getRandomArray(int kinds, int range, int k, int m) {
        int[] arr = new int[k + (kinds -1) * m];

        int index = 0;
        Set<Integer> set = new HashSet<>();
//        for (;index < k; index ++) {
//            arr[index] = getRandomInt(range);
//            set.add(arr[index]);
//        }
//
//        for (int i = 1; i < kinds; i++) {
//            while (!set.contains(getRandomInt(range))) {
//                for (;index < m; index ++) {
//                    arr[index] = getRandomInt(range);
//                    set.add(arr[index]);
//                    if (index == k + i*m){
//                        break;
//                    }
//                }
//            }
//        }

        //todo 老师思路
        int kNum = getRandomInt(range);
        for (;index < k; index ++) {
            arr[index]= kNum;
        }
        set.add(kNum);

        // 填完k次的数后种类减少
        kinds --;

        while (kinds != 0) {
            int mNum = 0;
            // 如果set判断已经有重复数据了，就重新获取随机数
            do {
                mNum = getRandomInt(range);
            } while (set.contains(mNum));
            set.add(mNum);
            kinds --;
            for (int i = 0; i < m; i++) {
                //todo 注意，接在index之后填写m的数字
                arr[index ++ ] = mNum;
            }
//            for (;index<m; index++) {
//                arr[index] = mNum;
//            }
        }

        // 随机打乱数组顺序
        for (int i = 0; i < arr.length; i++) {
            int random = (int)Math.random() * arr.length;
            int temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;
        }

        return arr;
    }

    public static int getRandomInt(int range) {
        return ((int)(Math.random() * range) + 1 )-((int)(Math.random() * range) + 1 );
    }


    public static void main(String[] args) {


        int testTime = 100000;
        int kinds = 10;
        int range = 100;
        int max = 9;

        System.out.println("测试开始");

        for (int i = 0; i < testTime; i++) {
            int k = (int)(Math.random() * max) + 1;
            int m = (int)(Math.random() * max) + 1;

            k = Math.min(k, m);
            m = Math.max(k, m);
            m = k == m ? m + 1 : m;

            int[] arr = getRandomArray(kinds, range, k, m);
            int kmAns = findNumOnlyKTimes(arr, k ,m);
            int testAns = test(arr, k, m);
            if (kmAns != testAns) {
                System.out.println("出错拉！！！！");
            }

//            for (int num : arr) {
//                System.out.print(num + ",");
//            }
//            System.out.println();
        }
        System.out.println("测试结束！！");


        int [] arr = new int[]{2,-1,5,-1,5,2,2,5,1,1,1};
        int k = 2;
        int m = 3;

        System.out.println(findNumOnlyKTimes(arr, k, m));
        System.out.println(test(arr, k, m));
    }


}
