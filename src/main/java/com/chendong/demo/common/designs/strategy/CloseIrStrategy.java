package com.chendong.demo.common.designs.strategy;

/**
 * @author dong.chen
 * @date 2021 08 18 13:12
 */
public class CloseIrStrategy implements Strategy {
    @Override
    public void algorithm(Integer irId) {
        System.out.println("close ir " + irId);
    }
}
