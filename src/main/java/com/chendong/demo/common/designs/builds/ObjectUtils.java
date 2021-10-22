package com.chendong.demo.common.designs.builds;

/**
 * @author dong.chen
 */
public class ObjectUtils {
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);

        }
    }
}