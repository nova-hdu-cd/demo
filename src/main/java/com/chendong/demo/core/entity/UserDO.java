package com.chendong.demo.core.entity;

/**
 * 用户信息DO
 *
 * @author chendong
 * @date 2020/7/22 8:29 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class UserDO extends BaseDO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户id
     */
    private String id;

    /**
     * 性别
     */
    private String sex;

    /**
     * 编号
     */
    private String no;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}
