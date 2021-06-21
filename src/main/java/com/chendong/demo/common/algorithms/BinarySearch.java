package com.chendong.demo.common.algorithms;

public class BinarySearch {

    /**
     * 二分查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int searchBinary(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = searchBinary(arr, 7);
        System.out.println(res);
    }
}
