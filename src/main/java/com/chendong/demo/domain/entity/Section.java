package com.chendong.demo.domain.entity;

import java.time.LocalDateTime;

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
@ApiModel(value = "Section对象", description = "")
public class Section {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "期刊id")
    private Integer journalId;

    @ApiModelProperty(value = "期刊名")
    private String journalName;

    @ApiModelProperty(value = "栏目封面id")
    private Integer imageId;

    @ApiModelProperty(value = "栏目名")
    private String columnName;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "栏目描述")
    private String descr;

    @ApiModelProperty(value = "业务删除 0：删除 1：未删除")
    private Boolean active;

    private LocalDateTime created;

    private String createdby;

    private LocalDateTime updated;

    private String updatedby;

}
