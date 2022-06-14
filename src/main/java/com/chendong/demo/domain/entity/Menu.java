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
@ApiModel(value = "Menu对象", description = "")
public class Menu {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父菜单id")
    private Integer parentid;

    @ApiModelProperty(value = "菜单名称")
    private String menuname;

    @ApiModelProperty(value = "菜单类型：内容管理、图片管理	例如：cm-内容管理；banner-图片管理;journal-期刊菜单；section-栏目菜单；topic-专题菜单")
    private String menutype;

    @ApiModelProperty(value = "内容列表模板类型：用于表示其内容列表展示方式，	pd-图片+描述；pt-图片+标题")
    private String templatetype;

    @ApiModelProperty(value = "是否有效：1-有效；0-无效")
    private Boolean isactive;

    @ApiModelProperty(value = "菜单英文名称")
    private String menuename;

}
