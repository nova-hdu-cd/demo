package com.chendong.demo.domian.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author chendong
 * @date 2020/7/21 10:15 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
@Builder
public class Student extends AbstractPerson {

    private String name;

    private String id;

    private Integer sex;

}
