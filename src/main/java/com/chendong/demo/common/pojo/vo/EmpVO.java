package com.chendong.demo.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName EmpVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/25 15:50
 * @Version 1.0
 */
@ApiModel(value = "雇员视图类", description = "雇员对象")
public class EmpVO extends BaseVO {

    @ApiModelProperty(value = "姓名", name = "name", example = "xiaohua", required = true)
    @NotEmpty
    private String name;

    @ApiModelProperty(value = "年龄", name = "age", example = "12", required = true)
    @NotBlank
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmpVO() {
        super();
    }

    public EmpVO(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public EmpVO(String projectId, String namespace, String clientEntryId, String unisocId, String name, Integer age) {
        super(projectId, namespace, clientEntryId, unisocId);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
