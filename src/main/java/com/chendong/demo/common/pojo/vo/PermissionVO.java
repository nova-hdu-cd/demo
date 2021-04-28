package com.chendong.demo.common.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PermissionVO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 父ID
     */
    private String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 权限URL
     */
    @JSONField(serialize = false)
    private String url;
    /**
     * 图标
     */
    @JSONField(serialize = false)
    private String icon;
    /**
     * 是否菜单
     */
    private String isMenu;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 子集合
     */
    private List<PermissionVO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenu() {
        return isMenu;
    }

    public void setMenu(String menu) {
        isMenu = menu;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<PermissionVO> getList() {
        return children;
    }

    public void setList(List<PermissionVO> childrenList) {
        this.children = childrenList;
    }

    @Override
    public String toString() {
        return "PermissionVO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", isMenu=" + isMenu +
                ", sort=" + sort +
                '}';
    }
}