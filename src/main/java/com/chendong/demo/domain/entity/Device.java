package com.chendong.demo.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 设备表
 *
 * @TableName device
 */
@Data
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 内部设备id
     */
    private String device_id;

    /**
     * 设备的uuid
     */
    private String uuid;

    /**
     * 设备的本地唯一id
     */
    private String cid;

    /**
     * 第三方设备id
     */
    private String third_device_id;

    /**
     * 所属网关id
     */
    private String gateway_id;

    /**
     * 设备供应商code
     */
    private String device_provider_code;

    /**
     * 设备名称
     */
    private String device_name;

    /**
     * 设备ip
     */
    private String device_ip;

    /**
     * 设备mac地址
     */
    private String mac_address;

    /**
     * HTTP/TCP/485等
     */
    private String comm_type;

    /**
     * 产品品类
     */
    private String product_type;

    /**
     * 产品id
     */
    private String product_id;

    /**
     * 安装地点
     */
    private String install_location;

    /**
     * 小区id
     */
    private String project_id;

    /**
     * 设备描述
     */
    private String device_desc;

    /**
     * 扩展信息，内容各方自己定义
     */
    private String extend_data;

    /**
     * 配网状态，0:未配网 1: 已配网
     */
    private Boolean active_status;

    /**
     * 激活时间
     */
    private Long active_time;

    /**
     * 在线状态，0:未在线 1: 在线
     */
    private Boolean online_status;

    /**
     * 删除标志，0：删除，1：有效
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Long gmt_create;

    /**
     * 修改时间
     */
    private Long gmt_modified;

}