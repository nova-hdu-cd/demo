package com.chendong.demo.common.constants.enums.operation;

import static java.lang.System.out;

/**
 * @author chendong
 * @date 2020/6/5 9:47 上午 To change this template use Appearance | Editor | File and Code Templates.
 */
public enum Operation {
    // 加减乘除
    PLUS, MINUS, TIMES, DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                return -1.0;
        }
    }

    public static void main(String[] args) {
        for (Operation value : Operation.values()) {
            out.println(value);
        }

        double res0 = PLUS.apply(1, 2);
        double res1 = MINUS.apply(1, 2);
        double res2 = TIMES.apply(1, 2);
        double res3 = DIVIDE.apply(1, 2);
        out.println(res0 + " " + res1 + " " + res2 + " " + res3);
    }
}
