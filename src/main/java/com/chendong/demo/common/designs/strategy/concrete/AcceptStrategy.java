package com.chendong.demo.common.designs.strategy.concrete;

import com.chendong.demo.common.designs.strategy.Strategy;

/**
 * @author dong.chen
 * @date 2021 08 18 13:18
 */
public class AcceptStrategy implements Strategy {
    @Override
    public void algorithm(Integer irId) {
        System.out.println("accept ir " + irId);
    }
}