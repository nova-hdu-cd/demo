package com.chendong.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Data
@ApiModel(value = "SpecialTopic对象", description = "")
public class SpecialTopic {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父专题id（父专题为0，子专题为其父专题id）")
    private Integer parentId;

    @ApiModelProperty(value = "期刊id")
    private Integer journalId;

    @ApiModelProperty(value = "专题图片id")
    private Integer imageId;

    @ApiModelProperty(value = "专题名字")
    private String topicName;

    private String keywords;

    @ApiModelProperty(value = "专题描述")
    private String descr;

    @ApiModelProperty(value = "业务删除 0：删除 1：未删除")
    private Boolean active;

    private LocalDateTime created;

    private String createdby;

    private LocalDateTime updated;

    private String updatedby;


}
