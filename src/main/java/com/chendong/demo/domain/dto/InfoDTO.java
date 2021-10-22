package com.chendong.demo.domain.dto;

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
public class InfoDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoDTO() {
    }

    public InfoDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "InfoVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
