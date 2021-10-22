package com.chendong.demo.common.designs.strategy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dong.chen
 * @date 2021 08 18 13:09
 */
public class StrategyTest {

    public static void main(String[] args) {
        Strategy a = StrategyFactory.getStrategy("accept");
        a.algorithm(1);

        Strategy b = StrategyFactory.getStrategy("risingCcb");
        b.algorithm(2);

        Strategy c = StrategyFactory.getStrategy("closeIr");
        c.algorithm(3);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }

}
