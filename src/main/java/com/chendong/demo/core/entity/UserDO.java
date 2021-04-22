package com.chendong.demo.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户信息DO
 *
 * @author chendong
 * @date 2020/7/22 8:29 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO extends BaseDO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户id
     */
    private String id;

    /**
     * 性别
     */
    private String sex;

    /**
     * 编号
     */
    private String no;

}
