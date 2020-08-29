package com.chendong.demo.domian.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author chendong
 * @date 2020/7/22 8:29 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
@Builder
public class UserDO {

    private String name;

    private String id;

    private String sex;

    private String no;

}
