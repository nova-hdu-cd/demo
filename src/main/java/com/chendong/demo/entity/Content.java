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
@ApiModel(value = "Content对象", description = "")
public class Content {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "外键,菜单编号")
    private Integer menuid;

    @ApiModelProperty(value = "类容详情类型：pd-图文、pdf-PDF、null表示没有详情")
    private String contenttype;

    @ApiModelProperty(value = "预览图片保存名称")
    private String imagesavename;

    @ApiModelProperty(value = "预览图片原名")
    private String imagename;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "PDF文件保存名称")
    private String pdfsavename;

    @ApiModelProperty(value = "PDF文件名称")
    private String pdfname;

    @ApiModelProperty(value = "详细描述信息")
    private String detailcontent;

    @ApiModelProperty(value = "是否置顶")
    private Boolean istop;

    @ApiModelProperty(value = "是否有效")
    private Boolean isactive;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "创建人")
    private String createdby;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime updated;

    @ApiModelProperty(value = "最后修改人")
    private String updatedby;


}
