package com.chendong.demo.common.designs.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dong.chen
 * @date 2021 08 18 11:17
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("accept", new AcceptStrategy());
        strategyMap.put("risingCcb", new RisingCcbStrategy());
        strategyMap.put("closeIr", new CloseIrStrategy());
    }

    public static Strategy getStrategy(String type) {

        if (type == null || "".equals(type)) {
            throw new IllegalArgumentException("type should not be null!");
        }

        return strategyMap.get(type);
    }
}
