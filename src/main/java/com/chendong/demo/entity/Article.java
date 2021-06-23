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
@ApiModel(value = "Article对象", description = "")
public class Article {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "期刊id")
    private Integer journalId;

    @ApiModelProperty(value = "栏目id")
    private Integer sectionId;

    @ApiModelProperty(value = "专题id")
    private Integer specialTopicId;

    @ApiModelProperty(value = "图片id")
    private Integer imageId;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "栏目名字")
    private String sectionName;

    @ApiModelProperty(value = "文章图片")
    private String contentImage;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "文章描述")
    private String descr;

    @ApiModelProperty(value = "业务删除 0：删除 1：未删除")
    private Boolean active;

    @ApiModelProperty(value = "快速导航 1:是 0:否;-1:忽略")
    private Boolean navigation;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "创建人")
    private String createdby;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updated;

    @ApiModelProperty(value = "更新人")
    private String updatedby;


}
