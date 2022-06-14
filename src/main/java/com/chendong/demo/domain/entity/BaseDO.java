package com.chendong.demo.domain.entity;

import java.io.Serializable;

/**
 * BaseDO
 *
 * @author chendong
 * @date 2020/7/22 8:29 下午 To change this template use Appearance | Editor | File and Code Templates.
 */

public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = -5325661895329167468L;

    /**
     * 主键id
     */
    private String mainId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long changeTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String changer;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Long changeTime) {
        this.changeTime = changeTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    @Override
    public String toString() {
        return "BaseDO   {" + "mainId='" + mainId + '\'' + ", createTime=" + createTime + ", changeTime=" + changeTime
            + ", creator='" + creator + '\'' + ", changer='" + changer + '\'' + '}';
    }
}
