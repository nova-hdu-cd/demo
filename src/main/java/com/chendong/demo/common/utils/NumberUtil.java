package com.chendong.demo.common.utils;

import java.util.Random;

public class NumberUtil {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public int getRandomNumber(int seed) {
        return RANDOM_NUMBER_GENERATOR.nextInt();
    }

}
