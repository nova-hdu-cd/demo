package com.chendong.demo.common.utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入输出模版
 *
 * @author chendong
 * @date 2020/8/29 4:36 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str0 = sc.nextLine();
        String[] split0 = str0.split(" ");
        int n = Integer.parseInt(split0[0]);
        int m = Integer.parseInt(split0[1]);

        //获取输入的整数序列
        String str1 = sc.nextLine();
        String[] split1 = str1.split(" ");
        //转为整数数组
        int[] ints = new int[split1.length];
        for (int i = 0; i < split1.length; i++) {
            ints[i] = Integer.parseInt(split1[i]);
        }

        System.out.println(n + " " + m);
        System.out.println(Arrays.toString(ints));
    }
}
