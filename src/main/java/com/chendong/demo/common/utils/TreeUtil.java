package com.chendong.demo.common.utils;

import com.chendong.demo.domain.vo.PermissionVO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TreeUtil工具类，将List的树形节点数据
 * 封装成树形结构的形式返回给前端
 *
 * @author dong.chen
 */
public class TreeUtil {

    /**
     * 存放所有的树状节点数据
     */
    private List<PermissionVO> menuList;

    /**
     * 存放返回树状数据，已经按照树形处理过
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

            String rootId1 = "0", rootId2 = "";
            //根节点默认是""或null或0,根据业务改变
            if (null == treeNode.getParentId() || rootId2.equals(treeNode.getParentId()) || rootId1.equals(treeNode.getParentId())) {
                //构建树型结构
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
        //获取其子节点列表，设置给children属性
        mapArray.put("children", menuChild(treeNode.getId().toString()));
    }

    /**
     * 根据父节点id获取子节点列表集合
     *
     * @param parentId 父节点id
     * @return 子节点集合
     */
    private List<?> menuChild(String parentId) {
        //父节点为parentId的子节点集合
        List<Object> lists = new ArrayList<>();
        menuList.forEach(treeNode -> {
            //通用节点对象
            Map<String, Object> childArray = new LinkedHashMap<>();
            if (null != treeNode.getParentId() && !"".equals(treeNode.getParentId())) {
                //这里根据业务替换下父id
                //非父节点处理
                if (treeNode.getParentId().equals(parentId)) {
                    //当前节点的父节点为parentId，则继续构建树
                    setTreeMap(childArray, treeNode);
                    //添加到子节点集合
                    lists.add(childArray);
                }
            }
        });
        return lists;
    }
}