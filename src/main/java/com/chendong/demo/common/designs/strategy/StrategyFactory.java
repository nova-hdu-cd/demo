package com.chendong.demo.common.designs.strategy;

import java.util.HashMap;
import java.util.Map;

import com.chendong.demo.common.designs.strategy.concrete.AcceptStrategy;
import com.chendong.demo.common.designs.strategy.concrete.CloseIrStrategy;
import com.chendong.demo.common.designs.strategy.concrete.RisingCcbStrategy;

/**
 * @author dong.chen
 * @date 2021 08 18 11:17
 */
public class StrategyFactory {

    private static final Map<String, Strategy> STRATEGY_MAP;

    static {
        STRATEGY_MAP = new HashMap<>(16);
        STRATEGY_MAP.put("accept", new AcceptStrategy());
        STRATEGY_MAP.put("risingCcb", new RisingCcbStrategy());
        STRATEGY_MAP.put("closeIr", new CloseIrStrategy());
    }

    public static Strategy getStrategy(String type) {

        if (type == null || "".equals(type)) {
            throw new IllegalArgumentException("type should not be null!");
        }

        return STRATEGY_MAP.get(type);
    }
}
