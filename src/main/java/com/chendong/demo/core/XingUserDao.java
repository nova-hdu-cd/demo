package com.chendong.demo.core;

import com.chendong.demo.core.entity.XingUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XingUser)表数据库访问层
 *
 * @author chendong
 * @since 2020-08-20 17:16:50
 */
@Mapper
public interface XingUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XingUserDO queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XingUserDO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xingUserDO 实例对象
     * @return 对象列表
     */
    List<XingUserDO> queryAll(XingUserDO xingUserDO);

    /**
     * 新增数据
     *
     * @param xingUserDO 实例对象
     * @return 影响行数
     */
    int insert(XingUserDO xingUserDO);

    /**
     * 修改数据
     *
     * @param xingUserDO 实例对象
     * @return 影响行数
     */
    int update(XingUserDO xingUserDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}