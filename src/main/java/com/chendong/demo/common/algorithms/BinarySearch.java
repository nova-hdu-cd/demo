package com.chendong.demo.common.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> list = Arrays.asList("1:2", "2:1", "2:4", "4:2");
        List<String> lists = new ArrayList<>(list);
        int res = 0;
        for (int i = 0; i < lists.size(); i++) {
            String target = lists.get(i);
            String[] split = target.split(":");
            target = split[1] + ":" + split[0];
            for (int j = i + 1; j < lists.size(); j++) {
                if (lists.get(j).equals(target)) {
                    res += 2;
                }
            }
        }
        int s = 1;
        if (res != lists.size()) {
            s = 0;
        }

        List<String> list1 = Arrays.asList("a", "c", "B", "F", "G", "f");
    }
}
