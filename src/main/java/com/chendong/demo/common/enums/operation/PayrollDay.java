package com.chendong.demo.common.enums.operation;

/**
 * @author chendong
 * @date 2020/6/5 2:44 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
public enum PayrollDay {

    // 一周
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int HOURS_PRE_SHIFT = 8;

    double pay(double hoursWorked, double payRate) {
        // 基本工资
        double basePay = hoursWorked * payRate;
        // 加班工资
        double overPay;
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overPay = hoursWorked * payRate / 2;
                break;
            default:
                overPay = hoursWorked <= HOURS_PRE_SHIFT ? 0 : (hoursWorked - HOURS_PRE_SHIFT) * payRate / 2;
                break;
        }
        return basePay + overPay;
    }

    public static void main(String[] args) {
        double res0 = MONDAY.pay(9, 1.0);
        double res1 = SUNDAY.pay(9, 1.0);
        System.out.println(res0);
        System.out.println(res1);
        System.out.println(PayrollDay.valueOf("MONDAY"));
        for (PayrollDay value : PayrollDay.values()) {
            System.out.println(value);
        }
    }

}
