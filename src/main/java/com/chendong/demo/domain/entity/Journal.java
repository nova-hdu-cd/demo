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
@ApiModel(value = "Journal对象", description = "")
public class Journal {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "期刊封面id")
    private Integer imageId;

    @ApiModelProperty(value = "pdf id")
    private Integer pdfId;

    @ApiModelProperty(value = "期刊号")
    private String num;

    @ApiModelProperty(value = "期刊名")
    private String name;

    @ApiModelProperty(value = "是否发布 0：不发布 ，1：发布")
    private Boolean publish;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "期刊描述")
    private String descr;

    @ApiModelProperty(value = "业务删除 0：删除 1：未删除")
    private Boolean active;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "创建人")
    private String createdby;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updated;

    @ApiModelProperty(value = "更新人")
    private String updatedby;

}
