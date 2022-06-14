package com.chendong.demo.common.designs.builds;

/**
 * 下发同步数据的抽象构建对象，子类继承实现具体的build逻辑
 *
 * @author: niezg date： 2019/12/3
 */
public abstract class IssueDataBuilder<D extends IssueData> {

    private IssueDataCmdBuilder<D, ?> parentBuilder;

    public void setParentBuilder(IssueDataCmdBuilder<D, ?> parentBuilder) {
        this.parentBuilder = parentBuilder;
    }

    public IssueDataCmdBuilder<D, ?> parentBuilder() {
        return parentBuilder;
    }

    public abstract Integer dpid();

    public abstract Boolean isGateWay();

    /**
     * data对应的mode
     *
     * @return
     */
    public abstract String mode();

    public abstract D buildData();

}
