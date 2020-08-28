package com.chendong.demo.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chendong
 * @date 2020/7/21 10:22 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
public abstract class AbstractPerson implements Serializable {

    private String id;
    private String name;
    private String age;


}
