package com.chendong.demo.mapper;

import com.chendong.demo.domain.entity.Device;

/**
 * @Entity generator.domain.Device
 */
public interface DeviceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

}
