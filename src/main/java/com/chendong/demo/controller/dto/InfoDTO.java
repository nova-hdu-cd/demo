package com.chendong.demo.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName InfoVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/27 13:13
 * @Version 1.0
 */
@ApiModel(value = "信息DTO")
public class InfoDTO extends BaseDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoDTO() {
        super();
    }

    public InfoDTO(String caller, String projectId, String namespace, String clientEntryId, String name) {
        super(caller, projectId, namespace, clientEntryId);
        this.name = name;
    }

    @Override
    public String toString() {
        return "InfoVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
