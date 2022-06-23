package com.chendong.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Data
@ApiModel(value = "Menutag对象", description = "")
public class Menutag {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "外键，菜单编号")
    private Integer menuid;

    @ApiModelProperty(value = "标签名称")
    private String tagname;

    @ApiModelProperty(value = "是否有效")
    private Boolean isactive;

}
