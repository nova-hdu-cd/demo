package com.chendong.demo.common.utils;

import com.chendong.demo.controller.vo.PermissionVO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    /*
     * 存放所有树状数据
     */
    private List<PermissionVO> menuList;

    /*
     * 存放返回树状数据
     */
    public List<Object> list = new ArrayList<>();

    /**
     * 获取结构树
     *
     * @param allMenuList 所有数据
     * @return 结构树数据
     */
    public List<Object> treeMenu(List<PermissionVO> allMenuList) {
        this.menuList = allMenuList;
        allMenuList.forEach(treeNode -> {
            Map<String, Object> mapArray = new LinkedHashMap<>();
            //根节点默认是"",根据业务改变
            if (null == treeNode.getParentId() || "".equals(treeNode.getParentId())) {
                setTreeMap(mapArray, treeNode);
                list.add(mapArray);
            }
        });
        return list;
    }

    /**
     * 构造树状结构
     *
     * @param mapArray 节点对象
     * @param treeNode 节点
     *                 根据业务改为接受树状数据的类的结构
     */
    private void setTreeMap(Map<String, Object> mapArray, PermissionVO treeNode) {
        mapArray.put("id", treeNode.getId());
        mapArray.put("parentId", treeNode.getParentId());
        mapArray.put("name", treeNode.getName());
        mapArray.put("url", treeNode.getUrl());
        mapArray.put("icon", treeNode.getIcon());
        mapArray.put("isMenu", treeNode.getMenu());
        mapArray.put("sort", treeNode.getSort());
        //获取子节点
        mapArray.put("children", menuChild(treeNode.getId().toString()));
    }

    /**
     * 根据父节点id获取子节点
     *
     * @param parentId 父节点id
     * @return 子节点集合
     */
    private List<?> menuChild(String parentId) {
        List<Object> lists = new ArrayList<>();
        menuList.forEach(treeNode -> {
            Map<String, Object> childArray = new LinkedHashMap<>();
            if (null != treeNode.getParentId() && !"".equals(treeNode.getParentId())) {
                //这里根据业务替换下父id
                if (treeNode.getParentId().equals(parentId)) {
                    setTreeMap(childArray, treeNode);
                    lists.add(childArray);
                }
            }
        });
        return lists;
    }
}