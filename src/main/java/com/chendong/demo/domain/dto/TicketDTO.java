package com.chendong.demo.domain.dto;

import lombok.NonNull;

/**
 * 工单DTO
 *
 * @author chendong
 * @date 2020/7/21 10:15 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class TicketDTO {

    private String name;

    @NonNull
    private String id;

    @NonNull
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public TicketDTO() {
        super();
    }

    public TicketDTO(String name, @NonNull String id, @NonNull Integer sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    public TicketDTO(String caller, String projectId, String namespace, String clientEntryId, String name, @NonNull String id, @NonNull Integer sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sex=" + sex +
                '}';
    }
}
