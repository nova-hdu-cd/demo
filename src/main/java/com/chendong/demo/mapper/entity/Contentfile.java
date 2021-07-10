package com.chendong.demo.mapper.entity;

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
@ApiModel(value = "Contentfile对象", description = "")
public class Contentfile {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "外键，菜单编号")
    private Integer menuid;

    @ApiModelProperty(value = "外键,内容编号")
    private Integer contentid;

    @ApiModelProperty(value = "文件保存名称")
    private String filesavename;

    @ApiModelProperty(value = "文件名称")
    private String filename;

    @ApiModelProperty(value = "排序使用")
    private Integer sort;

    @ApiModelProperty(value = "文件类型：1-banner；2-内容图片；3-封面图；4-pdf	5-期刊封面图 6-栏目封面图 7-专题封面图")
    private Integer type;


}
