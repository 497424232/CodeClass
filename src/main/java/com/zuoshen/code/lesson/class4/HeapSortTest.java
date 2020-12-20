package com.zuoshen.code.lesson.class4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSortTest {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        // heapIfy方式时间复杂度为 N
//        for (int i = arr.length - 1; i >= 0; i--) {
//            heapIfy(arr, i, arr.length);
//        }

        int heapSize = arr.length;
        heapSize --;
        swap(arr, 0, heapSize);
        heapIfy(arr, 0, heapSize);
        while (heapSize > 0) {
            heapSize --;
            swap(arr, 0, heapSize);
            heapIfy(arr, 0, heapSize);
        }

    }


    /**
     * 堆 ，从下往上顶
     * arr[index]刚来的数，往上
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        // 当子节点数据大于父节点数据时，交换位置
        // 条件终止条件：子节点数据 < 父节点数据
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }
    /**
     * 堆 ，从上往下加
     * 相当于数组中某个数据换为较小数，则和子节点数据比较
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        // 左孩子下标不越界时
        while (left < heapSize) {
            // 拿到子节点中较大的数，交换位置
            int right = left + 1;
            int largeIndex = right > heapSize ? (arr[right] > arr[left] ? right : left) : left;

            if (arr[index] >= arr[largeIndex]) {
                break;
            }
            swap(arr, index, largeIndex);
            index = largeIndex;
            left = index * 2 + 1;
        }

    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {

        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(8);
        heap.add(0);
        heap.add(2);
        heap.add(9);
        heap.add(1);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        int[] arr = new int[]{1, -5, -6, 1, -4 };
        heapSort(arr);

//        int testTime = 500000;
//        int maxSize = 10;
//        int maxValue = 10;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            heapSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        heapSort(arr);
//        printArray(arr);
    }

}

