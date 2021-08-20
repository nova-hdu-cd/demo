package com.chendong.demo.common.designs.strategy;

/**
 * 策略A
 *
 * @author dong.chen
 * @date 2021 08 18 11:16
 */
public class RisingCcbStrategy implements Strategy {

    @Override
    public void algorithm(Integer irId) {
        System.out.println("rising Ccb " + irId);
    }
}
