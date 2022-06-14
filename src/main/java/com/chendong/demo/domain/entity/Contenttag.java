package com.chendong.demo.domain.entity;

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
@ApiModel(value = "Contenttag对象", description = "")
public class Contenttag {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "外键，内容id")
    private Integer contentid;

    @ApiModelProperty(value = "外键，标签id")
    private Integer tagid;

}
