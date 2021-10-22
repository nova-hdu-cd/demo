package com.chendong.demo.common.designs.builds;

/**
 * @author: niezg
 * date： 2019/12/3
 */
public class IssueDataCmd<T extends IssueData> extends CmdSupport {
    //add:新增;update:修改;del:删除
    private OP type;
    //数据的类别，如residentCarPermission
    private String mode;
    //随mode不同代表不同的数据结构
    private T data;

    public OP getType() {
        return type;
    }

    public void setType(OP type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
