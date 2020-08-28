package com.chendong.demo.dao;

import com.chendong.demo.entity.XinyangUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XinyangUser)表数据库访问层
 *
 * @author chendong
 * @since 2020-08-20 17:16:50
 */
@Mapper
public interface XinyangUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XinyangUser queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XinyangUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xinyangUser 实例对象
     * @return 对象列表
     */
    List<XinyangUser> queryAll(XinyangUser xinyangUser);

    /**
     * 新增数据
     *
     * @param xinyangUser 实例对象
     * @return 影响行数
     */
    int insert(XinyangUser xinyangUser);

    /**
     * 修改数据
     *
     * @param xinyangUser 实例对象
     * @return 影响行数
     */
    int update(XinyangUser xinyangUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}