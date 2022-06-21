package com.chendong.demo.common.constants.enums.operation;

/**
 * @author chendong
 * @date 2020/6/5 2:17 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
public enum OperationV1 {
    /**
     * 加减乘除
     */
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationV1(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "OpeationV1{" + "symbol='" + symbol + '\'' + '}';
    }

    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double res0 = PLUS.apply(1.0, 2.0);
        double res1 = MINUS.apply(1.0, 2.0);
        double res2 = TIMES.apply(1.0, 2.0);
        double res3 = DIVIDE.apply(1.0, 2.0);
        System.out.println(res0 + " " + res1 + " " + res2 + " " + res3);
        System.out.println(OperationV1.PLUS);
        System.out.println(OperationV1.PLUS.symbol);
    }

}
