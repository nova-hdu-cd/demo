package com.chendong.demo.common.designs.builds;

import org.springframework.util.Assert;

import com.chendong.demo.common.designs.builds.op.*;

/**
 * @author: niezg date： 2019/12/3
 */
public final class IssueDataCmdBuilder<D extends IssueData, DB extends IssueDataBuilder<D>>
    extends AbstractCmdBuilder<IssueDataCmd<D>, IssueDataCmdBuilder<D, DB>> {

    /**
     * add:新增;update:修改;del:删除
     */
    private OP type;

    /**
     * 数据的类别，如residentCarPermission
     */
    private String mode;

    /**
     * 随mode不同而不同
     */
    private D data;

    /**
     * 具体data的builder对象
     */
    private DB dataBuilder;

    private IssueDataCmdBuilder() {}

    public static <T extends IssueData, B extends IssueDataBuilder<T>> IssueDataCmdBuilder
        asIssueDataCmdBuilder(B dataBuilder) {
        Assert.notNull(dataBuilder, "数据同步指令的data构建对象不能为空！");
        IssueDataCmdBuilder<T, B> issueDataCmdBuilder = new IssueDataCmdBuilder();
        if (dataBuilder instanceof AddOP) {
            issueDataCmdBuilder.withType(OP.add);
        } else if (dataBuilder instanceof UpdateOP) {
            issueDataCmdBuilder.withType(OP.update);
        } else if (dataBuilder instanceof DelOP) {
            issueDataCmdBuilder.withType(OP.del);
        } else if (dataBuilder instanceof EnableOP) {
            issueDataCmdBuilder.withType(OP.enable);
        } else if (dataBuilder instanceof ClearOP) {
            issueDataCmdBuilder.withType(OP.clear);
        } else if (dataBuilder instanceof MultiAddOP) {
            issueDataCmdBuilder.withType(OP.multiadd);
        } else if (dataBuilder instanceof Upload) {
            issueDataCmdBuilder.withType(OP.upload);
        }
        issueDataCmdBuilder.withMode(dataBuilder.mode());
        issueDataCmdBuilder.withDataBuilder(dataBuilder);
        dataBuilder.setParentBuilder(issueDataCmdBuilder);
        return issueDataCmdBuilder;
    }

    public DB dataBuilder() {
        return dataBuilder;
    }

    public IssueDataCmdBuilder<D, DB> withType(OP type) {
        this.type = type;
        return this;
    }

    private IssueDataCmdBuilder<D, DB> withMode(String mode) {
        this.mode = mode;
        return this;
    }

    private IssueDataCmdBuilder<D, DB> withDataBuilder(DB dataBuilder) {
        this.dataBuilder = dataBuilder;
        return this;
    }

    @Override
    protected Class cmdClass() {
        return IssueDataCmd.class;
    }

    @Override
    protected void addFields(IssueDataCmd<D> cmd) {
        Assert.notNull(type, "type不能为空！");
        cmd.setType(type);
        Assert.notNull(dataBuilder.mode(), "mode不能为空！");
        cmd.setMode(dataBuilder.mode());
        cmd.setData(dataBuilder.buildData());
        cmd.setDpid(dataBuilder.dpid());
        cmd.setGateway(dataBuilder.isGateWay());
    }

}
