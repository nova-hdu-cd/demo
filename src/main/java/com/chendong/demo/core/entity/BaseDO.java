package com.chendong.demo.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * BaseDO
 *
 * @author chendong
 * @date 2020/7/22 8:29 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = -5325661895329167468L;

    /**
     * 主键id
     */
    private String mainId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long changeTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String changer;

}
